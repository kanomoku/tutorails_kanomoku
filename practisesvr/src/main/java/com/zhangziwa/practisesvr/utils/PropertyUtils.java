package com.zhangziwa.practisesvr.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    private static final Properties properties = new Properties();

    static {
        try (InputStream resourceAsStream = PropertyUtils.class.getResourceAsStream("/key.properties")) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getKey() {
        return properties.getProperty("key");
    }

    public static String getValue() {
        return properties.getProperty("value");
    }
}
