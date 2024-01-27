package map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InitMap {
    private static final Map<String, String> map1 = new HashMap<>();

    static {
        map1.put("key1", "value1");
        map1.put("key2", "value2");
    }

    /*慎用！  非静态内部类/ 匿名内部类包含了外围实例的引用， 如果拥有比 外部类更长的生命周期，有内存泄露隐患*/
    private static final HashMap<String, String> map2 = new HashMap<>() {{
        put("key1", "value1");
        put("key2", "value2");
    }};

    private static final Map<String, String> map3 = Map.of("kye1", "value1", "key2", "value2"); //不可变集合

    Map<String, String> map4 = ImmutableMap.of("kye1", "value1", "key2", "value2");
    Map<String, String> map5 = ImmutableMap.<String, String>builder().put("kye1", "value1").put("key2", "value2").build();

    @Test
    void test1() {
        System.out.println(map1);
        map1.put("key3", "value3");
        System.out.println(map1);
    }

    @Test
    void test2() {
        System.out.println(map2);
        map2.put("key3", "value3");
        System.out.println(map2);
    }

    @Test
    void test3() {
        System.out.println(map3);
        map3.put("key3", "value3");
    }

    @Test
    void test4() {
        System.out.println(map4);
        map4.put("key3", "value3");
    }

    @Test
    void test5() {
        System.out.println(map5);
        map5.put("key3", "value3");
    }

    @Test
    void test6() {
        Map<String, String> immutableMap = Collections.unmodifiableMap(new HashMap<>() {{
            put("key1", "value1");
            put("key2", "value2");
        }});

        System.out.println(immutableMap); // {key1=value1, key2=value2}
        immutableMap.put("key3", "value3"); // java.lang.UnsupportedOperationException
    }

    @Test
    void testEmpty() {
        // Constructs an empty HashMap with the default initial capacity (16) and the default load factor (0.75).
        // Since:1.2
        Map<String, String> myMap = new HashMap<>();
        myMap.put("key1", "value1");
        System.out.println(myMap);

        // com.google.common.collect
        // Creates a mutable, empty HashMap instance.
        Map<String, String> myMap1 = Maps.newHashMap();
        myMap1.put("key1", "value1");
        System.out.println(myMap1);

        // Returns an empty map (immutable). This map is serializable.
        // Since: 1.5
        Map<String, String> myMap3 = Collections.emptyMap();

        // The empty map (immutable). This map is serializable.
        // Since:1.3
        Map myMap4 = Collections.EMPTY_MAP;

        // An empty unmodifiable map.
        // This was not provided in JDK1.2.
        Map myMap2 = MapUtils.EMPTY_MAP;
    }
}
