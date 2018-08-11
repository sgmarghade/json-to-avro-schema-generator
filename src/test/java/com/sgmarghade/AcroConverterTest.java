package com.sgmarghade;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author swapnil.marghade on 07/12/15.
 */
public class AcroConverterTest {

    private final ObjectMapper mapper = new ObjectMapper();
    private AvroConverter converter;

    @Before
    public void setup(){
        converter = new AvroConverter(mapper);

    }

    @Test
    public void validSchemShouldHaveValidNameSpaceNameAndRecord() throws IOException {
        JsonNode jsonNode = mapper.readTree(converter.convert(TestHelper.getJson()));
        Assert.assertEquals("com.sgmarghade.test",jsonNode.at("/namespace").asText());
        Assert.assertEquals("outer_record",jsonNode.at("/name").asText());
        Assert.assertEquals("record",jsonNode.at("/type").asText());
    }


    @Test
    public void validSchemaShouldHaveRecordType() throws IOException {
        JsonNode jsonNode = mapper.readTree(converter.convert(TestHelper.getJson()));
        ArrayNode arrayNode = (ArrayNode) jsonNode.at("/fields");
        Assert.assertEquals("record",arrayNode.get(0).at("/type/type").asText());
    }

    @Test
    public void jsonWithNullValue() throws IOException {
        String schema = converter.convert(TestHelper.getJsonWithNullField());
        Assert.assertEquals(true, converter.validate(schema,TestHelper.getJsonWithNullField()));

        final JsonNode schemaTree = mapper.readTree(schema);
        final ArrayNode fields = (ArrayNode) schemaTree.at("/fields");
        Assert.assertEquals("fieldThatsNull",fields.get(0).at("/name").asText());
        Assert.assertEquals(true,fields.get(0).at("/type").isArray());
        Assert.assertEquals("null",fields.get(0).at("/type/0").asText());
    }

    @Test
    public void jsonWithBooleanValue() throws IOException {
        String schema = converter.convert(TestHelper.getJsonWithBooleanField());
        Assert.assertEquals(true, converter.validate(schema,TestHelper.getJsonWithBooleanField()));

        final JsonNode schemaTree = mapper.readTree(schema);
        final ArrayNode fields = (ArrayNode) schemaTree.at("/fields");
        Assert.assertEquals("fieldThatsBoolean",fields.get(0).at("/name").asText());
        Assert.assertEquals("boolean",fields.get(0).at("/type").asText());
    }

    @Test(expected = RuntimeException.class)
    public void jsonWithEmptyArray() throws IOException {
        converter.convert(TestHelper.getJsonWithEmptyArray());
    }

    @Test
    public void generatedSchemaShouldVerifyInputJson() throws IOException {
        String schema = converter.convert(TestHelper.getJson());
        Assert.assertEquals(true, converter.validate(schema,TestHelper.getJson()));

    }

}
