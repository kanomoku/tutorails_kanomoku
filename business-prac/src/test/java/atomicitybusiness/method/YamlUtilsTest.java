package atomicitybusiness.method;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class YamlUtilsTest {

    @Test
    public void fromYamlStringToMap() {
        String str = "---\nkey1: value1\nkey2: value2\n...\n";
        Map<String, Object> map = YamlUtils.fromYamlStringToMap(str);
        System.out.println(map);
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void fromMapToYamlString() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        String resStr = YamlUtils.fromMapToYamlString(map);
        Assert.assertEquals("---\nkey1: value1\nkey2: value2\n...\n", resStr);
    }
}