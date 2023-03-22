package atomicitybusiness.method;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.json.JsonSanitizer;

public class JsonUtils {

    public static <T> T fromJsonToObject(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        T object = null;
        try {
            object = objectMapper.readValue(JsonSanitizer.sanitize(json), clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static <T> String fromObjectToJson(T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
