package com.olacabs.fabric;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.apache.avro.AvroTypeException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.JsonDecoder;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by swapnil.marghade on 07/12/15.
 */
public class JsonToAvroConverter {
    private ObjectMapper mapper ;
    private JsonToAvroConverter(){

    }
    public JsonToAvroConverter(ObjectMapper mapper){
        super();
        this.mapper = mapper;
    }



    public Boolean validate(String avroSchemaString, String jsonString) throws IOException {
        try {

            Schema.Parser t = new Schema.Parser();
            Schema schema = t.parse(avroSchemaString);
            GenericDatumReader reader = new GenericDatumReader(schema);
            JsonDecoder decoder = DecoderFactory.get().jsonDecoder(schema, jsonString);
            reader.read(null, decoder);
            return true;
        } catch (IOException e) {
            throw e;
        } catch (AvroTypeException e) {
            throw e;
        }
    }

    public String convertSchema(String jsonString) throws IOException {
        JsonNode jsonNode = mapper.readTree(jsonString);
        String finalSchema = "{\"namespace\" : \"com.olacabs.fabric\","+"\"name\": \"outerrecord\","+" \"type\" :  \"record\",";
        String fields = getFields(jsonNode);
        finalSchema += fields +"}";
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper.readValue(finalSchema,Object.class));
    }


    private String getFields(JsonNode jsonNode) {
        String fields = "\"fields\" :[";

        Iterator<Map.Entry<String, JsonNode>> elements = jsonNode.fields();
        int recordsRecorded = 0;

        while(elements.hasNext()){

            //Add , to all records inside the list except last 1.
            if(recordsRecorded > 0){
                fields += ",";
            }

            Map.Entry<String, JsonNode> map = elements.next();
            JsonNode nextNode = map.getValue();
            System.out.println(map.getKey() + " - " + nextNode.getNodeType());

            switch (nextNode.getNodeType()){
                case NUMBER:{

                    fields += "{\"name\": \""+map.getKey()+"\", \"type\": \""+(nextNode.isLong() ? "long" : "double")+"\"}";
                    break;
                }
                case STRING:{
                    fields += "{\"name\": \""+map.getKey()+"\", \"type\": \"string\"}";
                    break;
                }
                case ARRAY:{

                    ArrayNode arrayNode = (ArrayNode) nextNode;
                    JsonNode jsonNode1 = arrayNode.get(0);

                    if(jsonNode1.getNodeType() == JsonNodeType.NUMBER){
                        fields += "{\"name\": \"" + map.getKey() + "\", \"type\": {\n" +
                                "        \"type\": \"array\",\n" +
                                "        \"items\": \""+(nextNode.isLong() ? "long" : "double")+"\"}}" ;
                    }else if (jsonNode1.getNodeType() == JsonNodeType.STRING){
                        fields += "{\"name\": \"" + map.getKey() + "\", \"type\": {\n" +
                                "        \"type\": \"array\",\n" +
                                "        \"items\": \"string\"}}" ;
                    } else {
                        fields += "{\"name\": \"" + map.getKey() + "\", \"type\": {\n" +
                                "        \"type\": \"array\",\n" +
                                "        \"items\": {\n" +
                                "            \"type\": \"record\",\n" +
                                "            \"name\": \"" + generateRandomNumber(map) + "\"," + getFields(jsonNode1) + "}}}";
                    }

                    break;
                }

                case OBJECT:{
                    fields += "{\"name\" : \""+map.getKey()+"\", \n" +
                            "                     \"type\" : {\n" +
                            "                         \"type\" : \"record\",\n"+
                            "                         \"name\" : \""+ generateRandomNumber(map) +"\",\n"+getFields(nextNode)+" }} "; ;

                }


            }
            recordsRecorded++;
        }
        return fields+"]";
    }

    private String generateRandomNumber(Map.Entry<String, JsonNode> map) {
        return (map.getKey()+"_"+(int)(Math.random()*100));
    }


}
