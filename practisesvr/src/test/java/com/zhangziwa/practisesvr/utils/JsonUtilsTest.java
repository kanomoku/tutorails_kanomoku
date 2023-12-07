package com.zhangziwa.practisesvr.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonUtilsTest {

    @Test
    public void testToJson_BeanToJson() {
        Person person = new Person();
        person.setId(1);
        person.setName("name");
        person.setAge(18);

        String json = JsonUtils.toJson(person);
        assertThat(json).isEqualTo("{\"id\":1,\"name\":\"name\",\"age\":18,\"nickName\":null}");
    }

    @Test
    public void testToJson_MapToJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1L);
        map.put("name", "name");
        map.put("age", 18);

        String json = JsonUtils.toJson(map);
        assertThat(json).isEqualTo("{\"name\":\"name\",\"id\":1,\"age\":18}");
    }

    @Test
    public void testToJson_BeanToJsonFile() throws Exception {
        Person person = new Person();
        person.setId(1);
        person.setName("name");
        person.setAge(18);

        JsonUtils.toJsonFile(person);
    }

    @Test
    public void testToJson_noNull_Snake() {
        Person person = new Person();
        person.setId(1);
        person.setName("name");
        person.setAge(null);
        person.setNickName("nickName");

        String json = JsonUtils.toJsonNonNullSnake(person);
        assertThat(json).isEqualTo("{\"id\":1,\"name\":\"name\",\"nick_name\":\"nickName\"}");
    }

    @Test
    public void testToJson2_Gson() {
        Person person = new Person();
        person.setId(1);
        person.setName("name");
        person.setAge(18);

        String json = JsonUtils.toJsonG(person);
        assertThat(json).isEqualTo("{\"id\":1,\"name\":\"name\",\"age\":18,\"nickName\":null}");
    }

    @Test
    public void testJsonToBean() {
        String json = "{\"id\":1,\"name\":\"name\",\"age\":18}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = JsonUtils.jsonToT(json, Person.class);
        System.out.println(person);
    }

    @Test
    public void testJsonToMap() {
        String json = "{\"id\":1,\"name\":\"name\",\"age\":18}";
        Map map = JsonUtils.jsonToT(json, Map.class);
        System.out.println(map);
    }

    @Test
    public void testJsonToBean_noNull_Snake() {
        String json = "{\"id\":1,\"name\":\"name\",\"nick_name\":\"nickName\"\"nick_name1\":\"nickName\"}";
        Person person = JsonUtils.jsonToTNonNullSnake(json, Person.class);
        System.out.println(person);
    }

    @Test
    public void testJsonFileToT() {
        Person person = JsonUtils.jsonFileToT(Person.class);
        System.out.println(person);
    }

    @Test
    public void testJsonToJsonNode() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("name", Arrays.asList("name1", "name2", "name3"));
        map.put("age", Arrays.asList("11", "23", "23"));
        map.put("num", Arrays.asList("123", "234", "345"));
        String json1 = JsonUtils.toJson(map);
        System.out.println(json1);

        JsonNode jsonNode = JsonUtils.jsonToJsonNode(JsonUtils.toJson(map));
        JsonNode list = jsonNode.get("name");
        JsonNode str = list.get(0);

        System.out.println(jsonNode);
        System.out.println(list);
        System.out.println(str);
    }

    @Test
    public void testJsonToBean_Gson() {
        String json = "{\"id\":1,\"name\":\"name\",\"nick_name\":\"nickName\"}";
        String json2 = "{\"id\":1,\"name\":\"name\",\"age\":18},\"nickName\":\"nickName\"}";
        Person person = JsonUtils.jsonToTG(json, Person.class);
        System.out.println(person);
        Person person2 = JsonUtils.jsonToTG(json2, Person.class);
        System.out.println(person2);
    }

    @Test
    public void jsonToList() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "name1", 13, "nickName"));
        list.add(new Person(2, "name2", 14, "nickName2"));
        System.out.println(JsonUtils.toJson(list));

        String json = JsonUtils.toJson(list);
        List<Person> people = JsonUtils.jsonToList(json, Person.class);
        System.out.println(people);
    }

    @Test
    public void testJsonToListObject() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "name1", 13, "nickName"));
        list.add(new Person(2, "name2", 14, "nickName2"));
        System.out.println(JsonUtils.toJson(list));

        String json = JsonUtils.toJson(list);
        List<Person> people = JsonUtils.jsonToList2(json);
        System.out.println(people);
    }

    @Test
    public void testJsonToListMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "name1");
        map.put("age", "age1");
        map.put("num", "num1");
        String json = JsonUtils.toJson(map);
        System.out.println(json);

        Map<String, Object> people = JsonUtils.jsonToMap(json);
        System.out.println(people);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person {
        private Integer id;
        private String name;
        private Integer age;
        private String nickName;
    }
}