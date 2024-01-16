package com.zhangziwa.practisesvr.utils.reflect;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.apache.commons.lang3.ObjectUtils.allNull;
import static org.apache.commons.lang3.ObjectUtils.anyNull;

@Slf4j
public class ReflectUtils {
    // 获取对象被更新的属性和值
    public static Map<String, Map<String, Object>> getChange(Object originObject, Object newObject) {
        // 存在为null比价就没意义了
        if (anyNull(originObject, newObject)) {
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

    // 获取对象被更新的属性和值
    public static <T> Map<String, List<Object>> getChange2(T prev, T after) {
        Set<String> exceptFields = new HashSet<>(Arrays.asList("id", "created_at", "updated_at"));
        Map<String, List<Object>> res = new HashMap<>();
        Class<?> aClass = prev.getClass();
        PropertyDescriptor[] properties = new PropertyDescriptor[0];
        try {
            properties = Introspector.getBeanInfo(aClass, Object.class).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            System.out.println("Introspector.getBeanInfo exception" + e.getMessage());
        }

        for (PropertyDescriptor propertyDescriptor : properties) {
            String propertyName = propertyDescriptor.getName();
            if ("serialVersionUID".equals(propertyName)) {
                continue;
            }
            if (exceptFields.contains(propertyName)){
                continue;
            }
            Method readMethod = propertyDescriptor.getReadMethod();
            try {
                Object preValue = readMethod.invoke(prev);
                Object afterValue = readMethod.invoke(after);
                if (allNull(preValue, afterValue)) {
                    continue;
                }
                if (anyNull(preValue, afterValue)) {
                    res.put(propertyName, Arrays.asList(preValue, afterValue));
                    continue;
                }
                if (!preValue.equals(afterValue)){
                    res.put(propertyName, Arrays.asList(preValue, afterValue));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println("data compare occur error" + e.getMessage());
            }
        }
        return res;
    }

    // 通过反射读取属性值
    public static <T> Object getFieldValue(T t, String filedName) {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(filedName, t.getClass());
            Method readMethod = propertyDescriptor.getReadMethod();
            return readMethod.invoke(t);
        } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }

    // 通过反射给属性赋值
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

    // 类转map
    public static <T> Map<String, Object> beanToMap(T entity) {
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(entity.getClass(), Object.class).getPropertyDescriptors();
            Map<String, Object> map = new HashMap<>(propertyDescriptors.length);
            for (PropertyDescriptor property : propertyDescriptors) {
                String propertyName = property.getName();
                if ("serialVersionUID".equals(propertyName)) {
                    continue;
                }
                Method readMethod = property.getReadMethod();
                map.put(propertyName, readMethod.invoke(entity));
            }
            return map;
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
