# Usage
- git clone
- mvn clean install

### Command line usage :-

- java -jar target/avro-schema-generator-1.0-SNAPSHOT.jar 'java -jar target/avro-schema-generator-1.0-SNAPSHOT.jar '{
                                                                                                                  	"key1": 2.2,
                                                                                                                  	"key2": {
                                                                                                                  		"key3": "string"
                                                                                                                  	}
                                                                                                                  }'

- output :-

- ```{
  "namespace" : "com.sgmarghade.test",
  "name" : "outer_record",
  "type" : "record",
  "fields" : [ {
    "name" : "key1",
    "type" : "double"
  }, {
    "name" : "key2",
    "type" : {
      "type" : "record",
      "name" : "key2_17",
      "fields" : [ {
        "name" : "key3",
        "type" : "string"
      } ]
    }
  } ]}


### Using as library :-

-  String avroSchemaString = new AvroConverter(new ObjectMapper()).convert(jsonString);
