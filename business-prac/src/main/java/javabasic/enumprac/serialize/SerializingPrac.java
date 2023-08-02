package javabasic.enumprac.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class SerializingPrac {

    public static void main(String[] args) throws JsonProcessingException {
        enumToJson();
//        jsonToEnumDefault();
//        JsonToEnumjsonToEnumDefault();
//        jsonToEnumJsonValue();
//        jsonToEnumJsonProperty();
        jsonToEnumJsonCreator();
    }

    private static void jsonToEnumJsonCreator() throws JsonProcessingException {
        String json = "{\n" +
                "    \"distance\": {\n" +
                "        \"unit\":\"miles\", \n" +
                "        \"meters\":1609.34\n" +
                "    }\n" +
                "}";
        String json1 = "{" + "\"distance\": {" + "\"unit\":\"miles\", " + "\"meters\":1609.34" + "}" + "}";

        City city1 = new ObjectMapper().readValue(json, City.class);
        System.out.println(city1.toString()); // City(distance=MILE)

        City city2 = new ObjectMapper().readValue(json1, City.class);
        System.out.println(city2.toString()); // City(distance=MILE)
    }

    private static void jsonToEnumJsonProperty() throws JsonProcessingException {
        String json = "{\"distance\":\"distance-in-km\"}";
        City city1 = new ObjectMapper().readValue(json, City.class);
        System.out.println(city1.toString()); // City(distance=KILOMETER)
    }

    private static void enumToJson() throws JsonProcessingException {
        City city = new City().setDistance(Distance.KILOMETER);
        String s = new ObjectMapper().writeValueAsString(city);
        System.out.println(s); // {"distance":"KILOMETER"}
    }

    private static void jsonToEnumJsonValue() throws JsonProcessingException {
        String json3 = "{\"distance\":\"0.0254\"}";
        City city3 = new ObjectMapper().readValue(json3, City.class);
        System.out.println(city3.toString()); // City(distance=INCH)
    }

    private static void JsonToEnumjsonToEnumDefault() throws JsonProcessingException {
        ObjectMapper objectMapper = JsonMapper.builder().enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS).build();
        String json1 = "{\"distance\":\"KiLoMeTeR\"}";
        City city2 = objectMapper.readValue(json1, City.class);
        System.out.println(city2.toString()); // City(distance=KILOMETER)
    }

    private static void jsonToEnumDefault() throws JsonProcessingException {
        String json = "{\"distance\":\"KILOMETER\"}";
        City city1 = new ObjectMapper().readValue(json, City.class);
        System.out.println(city1.toString()); // City(distance=KILOMETER)
    }
}
