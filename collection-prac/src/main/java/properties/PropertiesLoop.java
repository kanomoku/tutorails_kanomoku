package properties;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesLoop {


    public static void printProp(Properties properties) {
        Set<Object> keys = properties.keySet();
        for (Object key : keys) {
            properties.get(key);
        }
    }

    public static void printProp2(Properties properties) {
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            entry.getKey();
            entry.getValue();
        }
    }

    public static void printProp3(Properties properties) {
        Set<String> p = properties.stringPropertyNames();
        for (String key : p) {
            properties.getProperty(key);
        }
    }

    public static void printProp4(Properties properties) {
        Enumeration<?> e = properties.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = properties.getProperty(key);
        }
    }
}