package com.olacabs.fabric;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws IOException {

//
//        String actual1 = "{\n" +
//                "\t\"key1\": \"string1\",\n" +
//                "\t\"key2\": 2.2\n" +
//                "}";
//
//        String schema = "{\n" +
//                "  \"namespace\" : \"com.olacabs.fabric\",\n" +
//                "  \"name\" : \"outerrecord\",\n" +
//                "  \"type\" : \"record\",\n" +
//                "  \"fields\" : [ {\n" +
//                "    \"name\" : \"key1\",\n" +
//                "    \"type\" : \"string\"\n" +
//                "  }, {\n" +
//                "    \"name\" : \"key2\",\n" +
//                "    \"type\" : \"double\"\n" +
//                "  } ]\n" +
//                "}\n";
//
//
//        new JsonToAvroConverter(new ObjectMapper()).validate(schema,actual1);
        System.out.println( new JsonToAvroConverter(new ObjectMapper()).convertSchema(args[0]));
    }



}