package map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InitMap {
    private static final Map<String, String> myMap = new HashMap<>();
    /*慎用！  非静态内部类/ 匿名内部类包含了外围实例的引用， 如果拥有比 外部类更长的生命周期，有内存泄露隐患*/
    private static final HashMap<String, String> myMap1 = new HashMap<>() {{
        put("key1", "value1");
        put("key2", "value2");
    }};
    private static final Map<String, String> myMap20 = Map.of(); //不可变集合
    private static final Map<String, String> myMap2 = Map.of("kye1", "value1", "key2", "value2"); //不可变集合
    private static final Map<String, String> myMap21 =
        Map.of("kye1", "value1", "key2", "value2", "kye3", "value1", "kye4", "value1", "kye5", "value1", "kye6",
            "value1", "kye7", "value1", "kye8", "value1", "kye9", "value10", "kye10", "value1"); //不可变集合

    static {
        myMap.put("key1", "value1");
        myMap.put("key2", "value2");
    }

    Map<String, String> myMap3 = ImmutableMap.of("kye1", "value1", "key2", "value2");
    Map<String, String> myMap4 =
        ImmutableMap.<String, String>builder().put("kye1", "value1").put("key2", "value2").build();

    @Test void test() {
        System.out.println(myMap);
        System.out.println(myMap1);
        System.out.println(myMap2);
        System.out.println(myMap3);
        System.out.println(myMap4);
        System.out.println(myMap21);
        System.out.println(myMap20);

        Map<String, String> myMap = new HashMap<>();
        myMap.put("key1", "value1");
        Map<String, String> myMap1 = Maps.newHashMap();
        Map<String, String> myMap3 = Collections.emptyMap();
        Map myMap2 = MapUtils.EMPTY_MAP;
        Map myMap4 = Collections.EMPTY_MAP;

    }

    @Test void test2() {
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
