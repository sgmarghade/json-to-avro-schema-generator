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
        Assert.assertEquals("com.sgmarghade.fabric",jsonNode.at("/namespace").asText());
        Assert.assertEquals("outer_record",jsonNode.at("/name").asText());
        Assert.assertEquals("record",jsonNode.at("/type").asText());
    }


    @Test
    public void validSchemaShouldHaveRecordType() throws IOException {
        JsonNode jsonNode = mapper.readTree(converter.convert(TestHelper.getJson()));
        ArrayNode arrayNode = (ArrayNode) jsonNode.at("/fields");
        Assert.assertEquals("record",arrayNode.get(0).at("/type/type").asText());
    }

    @Test(expected = RuntimeException.class)
    public void invalidJsonWithNullValueShouldThrowException() throws IOException {
        ObjectNode jsonNode = (ObjectNode) mapper.readTree(TestHelper.getJson());
        jsonNode.set("dummyString", null);
        converter.convert(jsonNode.toString());
    }

    @Test
    public void generatedSchemaShouldVerifyInputJson() throws IOException {
        String schema = converter.convert(TestHelper.getJson());
        Assert.assertEquals(true, converter.validate(schema,TestHelper.getJson()));

    }

}
