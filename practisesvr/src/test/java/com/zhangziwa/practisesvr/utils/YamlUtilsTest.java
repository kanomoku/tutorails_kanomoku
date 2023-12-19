package com.zhangziwa.practisesvr.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class YamlUtilsTest {

    @Test
    public void testYamlToMap() {
        String str = "---\nkey1: value1\nkey2: value2\n...\n";
        Map<String, Object> map = YamlUtils.yamlToMap(str);
        Assert.assertEquals(2, map.size());
        Assert.assertEquals("{key1=value1, key2=value2}", map.toString());
    }

    @Test
    public void testYamlToMap2() {
        String str = "---\nkey1: value1\nkey2: value2\n...\n";
        Map<String, Object> map = YamlUtils.yamlToMap2(str);
        System.out.println(map);
        Assert.assertEquals(2, map.size());
        Assert.assertEquals("{key1=value1, key2=value2}", map.toString());
    }

    @Test
    public void testMapToYaml() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        String resStr = YamlUtils.mapToYaml(map);
        Assert.assertEquals("---\nkey1: value1\nkey2: value2\n...\n", resStr);
    }
}