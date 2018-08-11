package com.sgmarghade;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.JsonDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * @author swapnil.marghade on 07/12/15.
 */
public class AvroConverter {

    private static final Logger logger = LoggerFactory.getLogger(AvroConverter.class);

    private static final String NAME = "name";
    private static final String TYPE = "type";
    private static final String ARRAY = "array";
    private static final String ITEMS = "items";
    private static final String STRING = "string";
    private static final String RECORD = "record";
    private static final String FIELDS = "fields";
    private static final String NULL = "null";
    private static final String BOOLEAN = "boolean";

    private final ObjectMapper mapper;

    /**
     * Constructor
     *
     * @param mapper to serialize
     */
    public AvroConverter(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * validation
     *
     * @param avroSchemaString to validate
     * @param jsonString       to validate
     * @return true if validated, false otherwise
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public boolean validate(final String avroSchemaString, final String jsonString) throws IOException {
        Schema.Parser t = new Schema.Parser();
        Schema schema = t.parse(avroSchemaString);
        GenericDatumReader reader = new GenericDatumReader(schema);
        JsonDecoder decoder = DecoderFactory.get().jsonDecoder(schema, jsonString);
        reader.read(null, decoder);
        return true;
    }

    /**
     * convert to avro schema
     *
     * @param json to convert
     * @return avro schema json
     * @throws IOException
     */
    public String convert(final String json) throws IOException {
        final JsonNode jsonNode = mapper.readTree(json);
        final ObjectNode finalSchema = mapper.createObjectNode();
        finalSchema.put("namespace", "com.sgmarghade.test");
        finalSchema.put(NAME, "outer_record");
        finalSchema.put(TYPE, RECORD);
        finalSchema.set(FIELDS, getFields(jsonNode));
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(finalSchema);
    }

    /**
     * @param jsonNode to getFields
     * @return array nodes of fields
     */
    private ArrayNode getFields(final JsonNode jsonNode) {
        final ArrayNode fields = mapper.createArrayNode();
        final Iterator<Map.Entry<String, JsonNode>> elements = jsonNode.fields();

        Map.Entry<String, JsonNode> map;
        while (elements.hasNext()) {
            map = elements.next();
            final JsonNode nextNode = map.getValue();

            switch (nextNode.getNodeType()) {
                case NUMBER:
                    fields.add(mapper.createObjectNode().put(NAME, map.getKey()).put(TYPE, (nextNode.isLong() ? "long" : "double")));
                    break;

                case STRING:
                    fields.add(mapper.createObjectNode().put(NAME, map.getKey()).put(TYPE, STRING));
                    break;

                case ARRAY:
                    final ArrayNode arrayNode = (ArrayNode) nextNode;
                    final JsonNode element = arrayNode.get(0);
                    final ObjectNode objectNode = mapper.createObjectNode();
                    objectNode.put(NAME, map.getKey());

                    if (element == null) {
                        throw new RuntimeException("Unable to guess at schema type for empty array");
                    }

                    if (element.getNodeType() == JsonNodeType.NUMBER) {
                        objectNode.set(TYPE, mapper.createObjectNode().put(TYPE, ARRAY).put(ITEMS, (nextNode.isLong() ? "long" : "double")));
                        fields.add(objectNode);
                    } else if (element.getNodeType() == JsonNodeType.STRING) {
                        objectNode.set(TYPE, mapper.createObjectNode().put(TYPE, ARRAY).put(ITEMS, STRING));
                        fields.add(objectNode);
                    } else {
                        objectNode.set(TYPE, mapper.createObjectNode().put(TYPE, ARRAY).set(ITEMS, mapper.createObjectNode()
                                .put(TYPE, RECORD).put(NAME, generateRandomNumber(map)).set(FIELDS, getFields(element))));
                    }
                    fields.add(objectNode);
                    break;

                case OBJECT:

                    ObjectNode node = mapper.createObjectNode();
                    node.put(NAME, map.getKey());
                    node.set(TYPE, mapper.createObjectNode().put(TYPE, RECORD).put(NAME, generateRandomNumber(map)).set(FIELDS, getFields(nextNode)));
                    fields.add(node);
                    break;

                case NULL:

                    ObjectNode unionNullNode = mapper.createObjectNode();
                    unionNullNode.put(NAME, map.getKey());
                    unionNullNode.putArray(TYPE).add(NULL);
                    fields.add(unionNullNode);
                    break;

                case BOOLEAN:

                    fields.add(mapper.createObjectNode().put(NAME, map.getKey()).put(TYPE, BOOLEAN));
                    break;

                default:
                    logger.error("Node type not found - " + nextNode.getNodeType());
                    throw new RuntimeException("Unable to determine action for ndoetype "+nextNode.getNodeType()+"; Allowed types are ARRAY, STRING, NUMBER, OBJECT");
            }
        }
        return fields;
    }

    /**
     * @param map to create random number
     * @return random
     */
    private String generateRandomNumber(Map.Entry<String, JsonNode> map) {
        return (map.getKey() + "_" + new Random().nextInt(100));
    }
}
