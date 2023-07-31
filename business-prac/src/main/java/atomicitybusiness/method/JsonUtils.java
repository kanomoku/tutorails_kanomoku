package atomicitybusiness.method;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.json.JsonSanitizer;
import lombok.extern.slf4j.Slf4j;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonUtils {
    private JsonUtils() {
    }

    public static <T> String toJson(T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.info("occur error:{}", e.getMessage());
        }
        return jsonStr;
    }

    public static <T> String toJsonNonNullSnake(T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.info("occur error:{}", e.getMessage());
        }
        return jsonStr;
    }

    public static <T> String toJsonG(T object) {
        Gson gson = new GsonBuilder().setLenient()// json宽松
                .enableComplexMapKeySerialization()//支持Map的key为复杂对象的形式
                .serializeNulls() //智能null
                // .setPrettyPrinting()// 美化格式
                .disableHtmlEscaping() //默认是GSON把HTML转义的
                .create();
        return gson.toJson(object);
    }

    public static <T> T jsonToT(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = null;
        try {
            t = objectMapper.readValue(JsonSanitizer.sanitize(json), clazz);
        } catch (JsonProcessingException e) {
            log.info("occur error:{}", e.getMessage());
        }
        return t;
    }

    public static <T> T jsonToTNonNullSnake(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 跳过不认识字段
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // 不包括null
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE); // 属性蛇形命名
        T t = null;
        try {
            t = objectMapper.readValue(JsonSanitizer.sanitize(json), clazz);
        } catch (JsonProcessingException e) {
            log.info("occur error:{}", e.getMessage());
        }
        return t;
    }

    public static <T> T jsonToTG(String json, Class<T> clazz) {
        Gson gson = new GsonBuilder().setLenient()// json宽松
                .enableComplexMapKeySerialization()//支持Map的key为复杂对象的形式
                .serializeNulls() //智能null
                .setPrettyPrinting()// 美化格式
                .disableHtmlEscaping() //默认是GSON把HTML转义的
                .create();

        return gson.fromJson(Normalizer.normalize(JsonSanitizer.sanitize(json), Normalizer.Form.NFC), clazz);
    }

    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> list = new ArrayList<>();
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            list.add(objectMapper.readValue(JsonSanitizer.sanitize(json), javaType));
        } catch (JsonProcessingException e) {
            log.info("occur error:{}", e.getMessage());
        }
        return list;
    }
}
