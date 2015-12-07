package com.olacabs.fabric;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException {


        String actual1 = "{\n" +
                "\t\"table\": \"consumer_apps\",\n" +
                "\t\"documents\": [{\n" +
                "\t\t\"id\": \"1a73ec08-ae8a-4510-8627-40c73fab85f0\",\n" +
                "\t\t\"timestamp\": 1449469901550,\n" +
                "\t\t\"data\": {\n" +
                "\t\t\t\"responseInfo\": {\n" +
                "\t\t\t\t\"payloadSize\": 47,\n" +
                "\t\t\t\t\"status\": \"200\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"timestamp\": 1449469901550,\n" +
                "\t\t\t\"carrierName\": \"Aircel\",\n" +
                "\t\t\t\"networkType\": \"2G\",\n" +
                "\t\t\t\"requestInfo\": {\n" +
                "\t\t\t\t\"headers\": {\n" +
                "\t\t\t\t\t\"X-SESSION-ID\": \"55a311fb-8d76-44ce-bead-f1b77343c263\",\n" +
                "\t\t\t\t\t\"os\": \"android_4.4.2\",\n" +
                "\t\t\t\t\t\"Authorization\": \"consumerapps 04d57bbf-23e7-41bd-872b-9724b946edf1\",\n" +
                "\t\t\t\t\t\"X-DEVICE-MODEL\": \"HTC Desire 620G dual sim\",\n" +
                "\t\t\t\t\t\"client\": \"android\",\n" +
                "\t\t\t\t\t\"api-key\": \"@ndro1d\",\n" +
                "\t\t\t\t\t\"app_version\": \"3.3.11\",\n" +
                "\t\t\t\t\t\"User-Agent\": \"OlaConsumerApp/3.3.11 (android/4.4.2)\",\n" +
                "\t\t\t\t\t\"X-REQUEST-ID\": \"aabWiXEkVCvifya404oXnUBwSXQ=\\n\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"paramSize\": 190,\n" +
                "\t\t\t\t\"params\": \"{\\\"lng\\\":\\\"77.61506000000008\\\",\\\"user_id\\\":\\\"MYLYC4xSzZpbve0CmFhLOVmNiGUnaynlvZj150qaNO/KK9NbbZeXopdTahS1\\\\nLYzQf1OLsQf2jdItf0g71iUKzg\\\\u003d\\\\u003d\\\\n    \\\",\\\"ab_variant\\\":\\\"B\\\",\\\"lat\\\":\\\"12.93506\\\",\\\"version\\\":\\\"3.3.11\\\"}\",\n" +
                "\t\t\t\t\"type\": \"GET\",\n" +
                "\t\t\t\t\"url\": \"https://apps.olacabs.com/v3/cab/city_wise_fare_breakup_with_surcharge?lng=77.61506000000008&user_id=MYLYC4xSzZpbve0CmFhLOVmNiGUnaynlvZj150qaNO%2FKK9NbbZeXopdTahS1%0ALYzQf1OLsQf2jdItf0g71iUKzg%3D%3D%0A%20%20%20%20&ab_variant=B&lat=12.93506&version=3.3.11\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"eventType\": \"networkInfo\",\n" +
                "\t\t\t\"elapsedTime\": 8940\n" +
                "\t\t}\n" +
                "\t}]\n" +
                "}";

        String schema = "{\n" +
                "\t\"namespace\": \"com.olacabs.fabric\",\n" +
                "\t\"name\": \"outer_record\",\n" +
                "\t\"type\": \"record\",\n" +
                "\t\"fields\": [{\n" +
                "\t\t\"name\": \"table\",\n" +
                "\t\t\"type\": \"string\"\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"documents\",\n" +
                "\t\t\"type\": {\n" +
                "\t\t\t\"type\": \"array\",\n" +
                "\t\t\t\"name\": \"array_12\",\n" +
                "\t\t\t\"items\": {\n" +
                "\t\t\t\t\"name\": \"documents_35\",\n" +
                "\t\t\t\t\"fields\": [{\n" +
                "\t\t\t\t\t\"name\": \"id\",\n" +
                "\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"name\": \"timestamp\",\n" +
                "\t\t\t\t\t\"type\": \"long\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"name\": \"data\",\n" +
                "\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\"type\": \"record\",\n" +
                "\t\t\t\t\t\t\"name\": \"data_41\",\n" +
                "\t\t\t\t\t\t\"fields\": [{\n" +
                "\t\t\t\t\t\t\t\"name\": \"responseInfo\",\n" +
                "\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\"type\": \"record\",\n" +
                "\t\t\t\t\t\t\t\t\"name\": \"responseInfo_37\",\n" +
                "\t\t\t\t\t\t\t\t\"fields\": [{\n" +
                "\t\t\t\t\t\t\t\t\t\"name\": \"payloadSize\",\n" +
                "\t\t\t\t\t\t\t\t\t\"type\": \"double\"\n" +
                "\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\"name\": \"status\",\n" +
                "\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"name\": \"timestamp\",\n" +
                "\t\t\t\t\t\t\t\"type\": \"long\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"name\": \"carrierName\",\n" +
                "\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"name\": \"networkType\",\n" +
                "\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"name\": \"requestInfo\",\n" +
                "\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\"type\": \"record\",\n" +
                "\t\t\t\t\t\t\t\t\"name\": \"requestInfo_50\",\n" +
                "\t\t\t\t\t\t\t\t\"fields\": [{\n" +
                "\t\t\t\t\t\t\t\t\t\"name\": \"headers\",\n" +
                "\t\t\t\t\t\t\t\t\t\"type\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"record\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"name\": \"headers_19\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"fields\": [{\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"X-SESSION-ID\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"os\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"Authorization\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"X-DEVICE-MODEL\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"client\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"api-key\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"app_version\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"User-Agent\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"X-REQUEST-ID\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\"name\": \"paramSize\",\n" +
                "\t\t\t\t\t\t\t\t\t\"type\": \"double\"\n" +
                "\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\"name\": \"params\",\n" +
                "\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\"name\": \"type\",\n" +
                "\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\t\"name\": \"url\",\n" +
                "\t\t\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"name\": \"eventType\",\n" +
                "\t\t\t\t\t\t\t\"type\": \"string\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"name\": \"elapsedTime\",\n" +
                "\t\t\t\t\t\t\t\"type\": \"double\"\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t}]\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}]\n" +
                "}";


        new AvroConverter(new ObjectMapper()).validate(schema, actual1);
//        System.out.println( new AvroConverter(new ObjectMapper()).convert(args[0]));
    }


}