package com.zhangziwa.practisesvr.utils;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class ReflectUtils {
    public static Map<String, Map<String, Object>> getChange(Object originObject, Object newObject) {
        // 存在为null比价就没意义了
        if (ObjectUtils.anyNull(originObject, newObject)) {
            return new HashMap<>();
        }

        // 不同类型无法比较
        if (ObjectUtils.notEqual(originObject.getClass(), newObject.getClass())) {
            return new HashMap<>();
        }

        // 内容都相等所以没必要比较
        if (Objects.deepEquals(originObject, newObject)) {
            return new HashMap<>();
        }

        Map<String, Map<String, Object>> result = Maps.newHashMap();

        Field[] declaredFields = originObject.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            // 检查Field是否为合成字段、如果该字段是合成字段则不进行比较
            if (field.isSynthetic()) {
                continue;
            }

            // serialVersionUID适用于java序列化机制,非业务属性
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }

            // 实现方式1
            // field.setAccessible(true);
            // Object o = field.get(originObject);
            // Object n = field.get(originObject);

            // 实现方式2
            PropertyDescriptor propertyDescriptor;
            try {
                propertyDescriptor = new PropertyDescriptor(field.getName(), originObject.getClass());
                Method readMethod = propertyDescriptor.getReadMethod();
                Object originValue = readMethod.invoke(originObject);
                Object newValue = readMethod.invoke(newObject);
                if (!Objects.deepEquals(originValue, newValue)) {
                    // 值不相等的话记录属性和值
                    HashMap<String, Object> keyValue = Maps.newHashMap();
                    keyValue.put("origin", originValue);
                    keyValue.put("new", newValue);
                    result.put(field.getName(), keyValue);
                }
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                log.error("getChange occur error" + e.getMessage());
            }
        }
        return result;
    }

    public static <T> Object getFieldValue(T t, String filedName) {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(filedName, t.getClass());
            Method readMethod = propertyDescriptor.getReadMethod();
            return readMethod.invoke(t);
        } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void setFieldValue(T t, String filedName, Object value) {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(filedName, t.getClass());
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if (writeMethod != null) {
                writeMethod.invoke(t, value);
            } else {
                System.out.println("not found write method");
            }
        } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }
}
