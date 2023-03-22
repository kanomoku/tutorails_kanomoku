package atomicitybusiness.method;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonUtilsTest {

    @Test
    public void testBeanToJson(){
        Person person = new Person();
        person.setId(1);
        person.setName("name");
        person.setAge(18);

        String json = JsonUtils.fromObjectToJson(person);
        System.out.println(json);
        assertThat(json).isEqualTo("{\"id\":1,\"name\":\"name\",\"age\":18}");
    }

    @Test
    public void testMapToJson(){
        Map map = new HashMap();
        map.put("id",1L);
        map.put("name","name");
        map.put("age",18);

        String json = JsonUtils.fromObjectToJson(map);
        System.out.println(json);
        assertThat(json).isEqualTo("{\"name\":\"name\",\"id\":1,\"age\":18}");
    }

    @Test
    public void testJsonToBean() {
        String json = "{\"id\":1,\"name\":\"name\",\"age\":18}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = JsonUtils.fromJsonToObject(json, Person.class);
        System.out.println(person);
    }

    @Test
    public void testJsonToMap(){
        String json = "{\"id\":1,\"name\":\"name\",\"age\":18}";
        Map map = JsonUtils.fromJsonToObject(json, Map.class);
        System.out.println(map);
    }
}