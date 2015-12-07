package com.olacabs.fabric;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException {

//
//        String actual1 = "{\n" +
//                "\t\"table\": \"consumer_apps\",\n" +
//                "\t\"documents\": [{\n" +
//                "\t\t\"id\": \"1a73ec08-ae8a-4510-8627-40c73fab85f0\",\n" +
//                "\t\t\"timestamp\": 1449469901550,\n" +
//                "\t\t\"data\": {\n" +
//                "\t\t\t\"responseInfo\": {\n" +
//                "\t\t\t\t\"payloadSize\": 47,\n" +
//                "\t\t\t\t\"status\": \"200\"\n" +
//                "\t\t\t},\n" +
//                "\t\t\t\"timestamp\": 1449469901550,\n" +
//                "\t\t\t\"carrierName\": \"Aircel\",\n" +
//                "\t\t\t\"networkType\": \"2G\",\n" +
//                "\t\t\t\"requestInfo\": {\n" +
//                "\t\t\t\t\"headers\": {\n" +
//                "\t\t\t\t\t\"X_SESSION_ID\": \"55a311fb-8d76-44ce-bead-f1b77343c263\",\n" +
//                "\t\t\t\t\t\"os\": \"android_4.4.2\",\n" +
//                "\t\t\t\t\t\"Authorization\": \"consumerapps 04d57bbf-23e7-41bd-872b-9724b946edf1\",\n" +
//                "\t\t\t\t\t\"X_DEVICE_MODEL\": \"HTC Desire 620G dual sim\",\n" +
//                "\t\t\t\t\t\"client\": \"android\",\n" +
//                "\t\t\t\t\t\"api_key\": \"@ndro1d\",\n" +
//                "\t\t\t\t\t\"app_version\": \"3.3.11\",\n" +
//                "\t\t\t\t\t\"User_Agent\": \"OlaConsumerApp/3.3.11 (android/4.4.2)\",\n" +
//                "\t\t\t\t\t\"X_REQUEST_ID\": \"aabWiXEkVCvifya404oXnUBwSXQ=\\n\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t\"paramSize\": 190,\n" +
//                "\t\t\t\t\"params\": \"{\\\"lng\\\":\\\"77.61506000000008\\\",\\\"user_id\\\":\\\"MYLYC4xSzZpbve0CmFhLOVmNiGUnaynlvZj150qaNO/KK9NbbZeXopdTahS1\\\\nLYzQf1OLsQf2jdItf0g71iUKzg\\\\u003d\\\\u003d\\\\n    \\\",\\\"ab_variant\\\":\\\"B\\\",\\\"lat\\\":\\\"12.93506\\\",\\\"version\\\":\\\"3.3.11\\\"}\",\n" +
//                "\t\t\t\t\"type\": \"GET\",\n" +
//                "\t\t\t\t\"url\": \"https://apps.olacabs.com/v3/cab/city_wise_fare_breakup_with_surcharge?lng=77.61506000000008&user_id=MYLYC4xSzZpbve0CmFhLOVmNiGUnaynlvZj150qaNO%2FKK9NbbZeXopdTahS1%0ALYzQf1OLsQf2jdItf0g71iUKzg%3D%3D%0A%20%20%20%20&ab_variant=B&lat=12.93506&version=3.3.11\"\n" +
//                "\t\t\t},\n" +
//                "\t\t\t\"eventType\": \"networkInfo\",\n" +
//                "\t\t\t\"elapsedTime\": 8940\n" +
//                "\t\t}\n" +
//                "\t}, {\n" +
//                "\t\t\"id\": \"1a73ec08-ae8a-4510-8627-40c73fab85f0\",\n" +
//                "\t\t\"timestamp\": 1449469901550,\n" +
//                "\t\t\"data\": {\n" +
//                "\t\t\t\"responseInfo\": {\n" +
//                "\t\t\t\t\"payloadSize\": 47,\n" +
//                "\t\t\t\t\"status\": \"200\"\n" +
//                "\t\t\t},\n" +
//                "\t\t\t\"timestamp\": 1449469901550,\n" +
//                "\t\t\t\"carrierName\": \"Aircel\",\n" +
//                "\t\t\t\"networkType\": \"2G\",\n" +
//                "\t\t\t\"requestInfo\": {\n" +
//                "\t\t\t\t\"headers\": {\n" +
//                "\t\t\t\t\t\"X_SESSION_ID\": \"55a311fb-8d76-44ce-bead-f1b77343c263\",\n" +
//                "\t\t\t\t\t\"os\": \"android_4.4.2\",\n" +
//                "\t\t\t\t\t\"Authorization\": \"consumerapps 04d57bbf-23e7-41bd-872b-9724b946edf1\",\n" +
//                "\t\t\t\t\t\"X_DEVICE_MODEL\": \"HTC Desire 620G dual sim\",\n" +
//                "\t\t\t\t\t\"client\": \"android\",\n" +
//                "\t\t\t\t\t\"api_key\": \"@ndro1d\",\n" +
//                "\t\t\t\t\t\"app_version\": \"3.3.11\",\n" +
//                "\t\t\t\t\t\"User_Agent\": \"OlaConsumerApp/3.3.11 (android/4.4.2)\",\n" +
//                "\t\t\t\t\t\"X_REQUEST_ID\": \"aabWiXEkVCvifya404oXnUBwSXQ=\\n\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t\"paramSize\": 190,\n" +
//                "\t\t\t\t\"params\": \"{\\\"lng\\\":\\\"77.61506000000008\\\",\\\"user_id\\\":\\\"MYLYC4xSzZpbve0CmFhLOVmNiGUnaynlvZj150qaNO/KK9NbbZeXopdTahS1\\\\nLYzQf1OLsQf2jdItf0g71iUKzg\\\\u003d\\\\u003d\\\\n    \\\",\\\"ab_variant\\\":\\\"B\\\",\\\"lat\\\":\\\"12.93506\\\",\\\"version\\\":\\\"3.3.11\\\"}\",\n" +
//                "\t\t\t\t\"type\": \"GET\",\n" +
//                "\t\t\t\t\"url\": \"https://apps.olacabs.com/v3/cab/city_wise_fare_breakup_with_surcharge?lng=77.61506000000008&user_id=MYLYC4xSzZpbve0CmFhLOVmNiGUnaynlvZj150qaNO%2FKK9NbbZeXopdTahS1%0ALYzQf1OLsQf2jdItf0g71iUKzg%3D%3D%0A%20%20%20%20&ab_variant=B&lat=12.93506&version=3.3.11\"\n" +
//                "\t\t\t},\n" +
//                "\t\t\t\"eventType\": \"networkInfo\",\n" +
//                "\t\t\t\"elapsedTime\": 8940\n" +
//                "\t\t}\n" +
//                "\t}]\n" +
//                "}";
//
//        String schema = "{\n" +
//                "  \"namespace\" : \"com.olacabs.fabric\",\n" +
//                "  \"name\" : \"outer_record\",\n" +
//                "  \"type\" : \"record\",\n" +
//                "  \"fields\" : [ {\n" +
//                "    \"name\" : \"table\",\n" +
//                "    \"type\" : \"string\"\n" +
//                "  }, {\n" +
//                "    \"name\" : \"documents\",\n" +
//                "    \"type\" : {\n" +
//                "      \"type\" : \"array\",\n" +
//                "      \"items\" : {\n" +
//                "        \"type\" : \"record\",\n" +
//                "        \"name\" : \"documents_67\",\n" +
//                "        \"fields\" : [ {\n" +
//                "          \"name\" : \"id\",\n" +
//                "          \"type\" : \"string\"\n" +
//                "        }, {\n" +
//                "          \"name\" : \"timestamp\",\n" +
//                "          \"type\" : \"long\"\n" +
//                "        }, {\n" +
//                "          \"name\" : \"data\",\n" +
//                "          \"type\" : {\n" +
//                "            \"type\" : \"record\",\n" +
//                "            \"name\" : \"data_22\",\n" +
//                "            \"fields\" : [ {\n" +
//                "              \"name\" : \"responseInfo\",\n" +
//                "              \"type\" : {\n" +
//                "                \"type\" : \"record\",\n" +
//                "                \"name\" : \"responseInfo_77\",\n" +
//                "                \"fields\" : [ {\n" +
//                "                  \"name\" : \"payloadSize\",\n" +
//                "                  \"type\" : \"double\"\n" +
//                "                }, {\n" +
//                "                  \"name\" : \"status\",\n" +
//                "                  \"type\" : \"string\"\n" +
//                "                } ]\n" +
//                "              }\n" +
//                "            }, {\n" +
//                "              \"name\" : \"timestamp\",\n" +
//                "              \"type\" : \"long\"\n" +
//                "            }, {\n" +
//                "              \"name\" : \"carrierName\",\n" +
//                "              \"type\" : \"string\"\n" +
//                "            }, {\n" +
//                "              \"name\" : \"networkType\",\n" +
//                "              \"type\" : \"string\"\n" +
//                "            }, {\n" +
//                "              \"name\" : \"requestInfo\",\n" +
//                "              \"type\" : {\n" +
//                "                \"type\" : \"record\",\n" +
//                "                \"name\" : \"requestInfo_5\",\n" +
//                "                \"fields\" : [ {\n" +
//                "                  \"name\" : \"headers\",\n" +
//                "                  \"type\" : {\n" +
//                "                    \"type\" : \"record\",\n" +
//                "                    \"name\" : \"headers_26\",\n" +
//                "                    \"fields\" : [ {\n" +
//                "                      \"name\" : \"X_SESSION_ID\",\n" +
//                "                      \"type\" : \"string\"\n" +
//                "                    }, {\n" +
//                "                      \"name\" : \"os\",\n" +
//                "                      \"type\" : \"string\"\n" +
//                "                    }, {\n" +
//                "                      \"name\" : \"Authorization\",\n" +
//                "                      \"type\" : \"string\"\n" +
//                "                    }, {\n" +
//                "                      \"name\" : \"X_DEVICE_MODEL\",\n" +
//                "                      \"type\" : \"string\"\n" +
//                "                    }, {\n" +
//                "                      \"name\" : \"client\",\n" +
//                "                      \"type\" : \"string\"\n" +
//                "                    }, {\n" +
//                "                      \"name\" : \"api_key\",\n" +
//                "                      \"type\" : \"string\"\n" +
//                "                    }, {\n" +
//                "                      \"name\" : \"app_version\",\n" +
//                "                      \"type\" : \"string\"\n" +
//                "                    }, {\n" +
//                "                      \"name\" : \"User_Agent\",\n" +
//                "                      \"type\" : \"string\"\n" +
//                "                    }, {\n" +
//                "                      \"name\" : \"X_REQUEST_ID\",\n" +
//                "                      \"type\" : \"string\"\n" +
//                "                    } ]\n" +
//                "                  }\n" +
//                "                }, {\n" +
//                "                  \"name\" : \"paramSize\",\n" +
//                "                  \"type\" : \"double\"\n" +
//                "                }, {\n" +
//                "                  \"name\" : \"params\",\n" +
//                "                  \"type\" : \"string\"\n" +
//                "                }, {\n" +
//                "                  \"name\" : \"type\",\n" +
//                "                  \"type\" : \"string\"\n" +
//                "                }, {\n" +
//                "                  \"name\" : \"url\",\n" +
//                "                  \"type\" : \"string\"\n" +
//                "                } ]\n" +
//                "              }\n" +
//                "            }, {\n" +
//                "              \"name\" : \"eventType\",\n" +
//                "              \"type\" : \"string\"\n" +
//                "            }, {\n" +
//                "              \"name\" : \"elapsedTime\",\n" +
//                "              \"type\" : \"double\"\n" +
//                "            } ]\n" +
//                "          }\n" +
//                "        } ]\n" +
//                "      }\n" +
//                "    }\n" +
//                "  } ]\n" +
//                "}";


//        new AvroConverter(new ObjectMapper()).validate(schema, actual1);
        System.out.println( new AvroConverter(new ObjectMapper()).convert(args[0]));
    }


}