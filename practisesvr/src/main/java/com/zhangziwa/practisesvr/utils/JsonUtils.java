package com.zhangziwa.practisesvr.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.json.JsonSanitizer;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JsonUtils {
    private JsonUtils() {
    }

    // 常用用法
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

    // 定制化用法：例如过滤值为null的，属性使用蛇形命名
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

    // toJson 然后写入文件里
    public static <T> void toJsonFile(T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 前提文件必须存在，其次是文件内容全覆盖的方式写入
            objectMapper.writeValue(new File("D:/output/car.json"), object);
        } catch (IOException e) {
            log.info("occur error:{}", e.getMessage());
        }
    }

    // 可定制化用法
    public static <T> String toJsonG(T object) {
        Gson gson = new GsonBuilder()
                .setLenient()// json宽松,来忽略一些不标准的 JSON 数据格式
                .enableComplexMapKeySerialization()//支持Map的key为复杂对象的形式
                .serializeNulls() //智能null
                // .setPrettyPrinting()// 美化格式
                .disableHtmlEscaping() //默认是GSON把HTML转义的
                .create();
        return gson.toJson(object);
    }

    // 常用用法
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

    // 定制化用法
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

    // 读取json文件到Java Object
    public static <T> T jsonFileToT(Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = null;
        try {
//            t = objectMapper.readValue(new URL("file:D:/output/car.json"), clazz);
            t = objectMapper.readValue(new File("D:/output/car.json"), clazz);
        } catch (IOException e) {
            log.info("occur error:{}", e.getMessage());
        }
        return t;
    }

    // json to JsonNode
    public static JsonNode jsonToJsonNode(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            log.info("occur error:{}", e.getMessage());
        }
        return jsonNode;
    }

    // 定制化用法
    public static <T> T jsonToTG(String json, Class<T> clazz) {
        Gson gson = new GsonBuilder().setLenient()// json宽松
                .enableComplexMapKeySerialization()//支持Map的key为复杂对象的形式
                .serializeNulls() //智能null
                .setPrettyPrinting()// 美化格式
                .disableHtmlEscaping() //默认是GSON把HTML转义的
                .create();

        return gson.fromJson(Normalizer.normalize(JsonSanitizer.sanitize(json), Normalizer.Form.NFC), clazz);
    }

    // JSON Array String to List
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

    // JSON Array String to List
    public static <T> List<T> jsonToList2(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> list = new ArrayList<>();
        try {
            list = objectMapper.readValue(json, new TypeReference<List<T>>() {});
        } catch (JsonProcessingException e) {
            log.info("occur error:{}", e.getMessage());
        }
        return list;
    }

    // JSON Array String to Map
    public static Map<String, Object> jsonToMap(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap();
        try {
            map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        } catch (JsonProcessingException e) {
            log.info("occur error:{}", e.getMessage());
        }
        return map;
    }
}
