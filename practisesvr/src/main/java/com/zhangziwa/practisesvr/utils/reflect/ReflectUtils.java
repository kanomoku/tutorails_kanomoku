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
    /**
     * <p>该方法用于比较两个对象的属性，并返回一个映射，表示被更新了的属性及其原值和新值。此方法适用于具有相同类类型的对象，
     * 并通过Java反射机制获取并比较它们的所有非合成字段（不包括serialVersionUID）的值。</p>
     *
     * @param originObject 原始对象实例，用于获取原有属性值
     * @param newObject    新对象实例，用于获取更新后的属性值
     * @return 一个Map<String, Map < String, Object>>类型的对象，其中：
     * - 键（String类型）：表示发生变化的属性名称
     * - 值（Map<String, Object>类型）：包含键为"origin"和"new"的子映射，分别表示原值和新值
     * @throws IntrospectionException    如果在获取属性描述符时出现异常
     * @throws IllegalAccessException    如果在访问或调用getter方法时无权访问私有属性
     * @throws InvocationTargetException 如果在调用getter方法时抛出了异常
     */
    public static Map<String, Map<String, Object>> getChange(Object originObject, Object newObject) {
        // 存在为null比较就没意义了
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

        // 反射比较对象的字段
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

            try {
                // 实现方式2
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), originObject.getClass());
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

    /**
     * <p>该静态方法用于获取两个相同类型对象之间的属性变化信息，比较前后对象（`prev`和`after`）的属性值，并返回一个映射表，
     * 映射表的键为发生变化的属性名，值为一个包含原值和新值的列表。</p>
     *
     * <p>通过Java反射API遍历对象的所有属性（排除预定义的排除字段如"id", "created_at", "updated_at"以及"serialVersionUID"），
     * 比较每个属性在前后对象中的取值是否相等。如果存在差异，则将此属性及其对应的原始值和更新后的值加入结果集合中。</p>
     *
     * @param <T>   泛型参数，表示被比较的对象类型
     * @param prev  需要进行比较的原始对象实例
     * @param after 需要进行比较的新对象实例
     * @return 一个Map对象，键为字符串类型的属性名，值为一个Object列表，列表中包含了旧值和新值
     * @throws RuntimeException 如果在使用Java反射过程中发生异常，例如IntrospectionException或在读取属性时抛出IllegalAccessException、InvocationTargetException
     */
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
            if (exceptFields.contains(propertyName)) {
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
                if (!preValue.equals(afterValue)) {
                    res.put(propertyName, Arrays.asList(preValue, afterValue));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println("data compare occur error" + e.getMessage());
            }
        }
        return res;
    }

    /**
     * 通过反射机制获取给定对象指定属性字段的值。
     * 此方法接收一个泛型对象 {@code T} 和一个字符串类型的字段名称，
     * 并尝试在该对象的类中查找具有匹配名称的属性描述符。
     * 它随后调用该属性的读取方法（getter）来获取并返回该字段的当前值。
     *
     * @param <T>       需要读取其字段值的对象类型
     * @param t         对象实例，其属性值将被读取
     * @param fieldName 要读取的属性字段名称
     * @return 字段的值，可以是任意类型，与目标字段的实际类型一致
     * @throws RuntimeException 如果在访问或读取属性值过程中发生异常，例如非法访问权限、
     *                          方法不存在或者Introspection异常时抛出此异常
     */
    public static <T> Object getFieldValue(T t, String fieldName) {
        // 检查传入的对象和字段名称是否为空
        if (t == null || fieldName == null || fieldName.isEmpty()) {
            throw new IllegalArgumentException("对象或字段名称不能为空");
        }
        try {
            // 创建属性描述符，用于获取读取方法
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, t.getClass());
            // 获取属性的读取方法
            Method readMethod = propertyDescriptor.getReadMethod();
            // 如果找到读取方法，则调用它来获取属性值
            if (readMethod != null) {
                return readMethod.invoke(t);
            } else {
                // 如果没有找到读取方法，则抛出异常
                throw new RuntimeException("属性 '" + fieldName + "' 无法读取");
            }
        } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
            // 对于反射操作出现的异常，封装为运行时异常并抛出
            throw new RuntimeException("访问属性 '" + fieldName + "' 时发生错误", e);
        }
    }

    /**
     * 通过反射机制动态地为给定对象的指定属性设置值。
     *
     * @param <T>       对象类型
     * @param object    需要修改属性的对象，不能为空
     * @param fieldName 需要设置的属性名称，不能为空且不能是空字符串
     * @param value     将要赋予属性的新值
     * @throws IllegalArgumentException 如果传入的对象或字段名为空，或者找不到与字段名对应的setter方法时抛出异常
     * @throws RuntimeException         在尝试通过反射设置属性值时发生任何反射相关的异常（如IllegalAccessException, InvocationTargetException, IntrospectionException）时，包装原始异常并抛出RuntimeException
     */
    public static <T> void setFieldValue(final T object, final String fieldName, final Object value) {
        if (object == null || fieldName == null || fieldName.isEmpty()) {
            throw new IllegalArgumentException("Object or fieldName cannot be null/empty");
        }

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, object.getClass());
            Method writeMethod = propertyDescriptor.getWriteMethod();

            if (writeMethod != null) {
                writeMethod.invoke(object, value);
            } else {
                System.err.println("未找到设置方法: " + fieldName);
            }
        } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
            throw new RuntimeException("通过反射设置属性时发生异常: " + e.getMessage(), e);
        }
    }

    /**
     * 将给定的实体对象转换为Map，其中键是属性名，值是属性值。
     * <p>
     * 此方法通过Java反射机制（{@link Introspector}）获取类的所有属性描述符，
     * 并调用getter方法来读取属性值。注意，此方法会忽略名为"serialVersionUID"的属性。
     *
     * @param <T>    实体类的类型
     * @param entity 需要转换为Map的对象实例
     * @return 包含对象属性名与对应属性值的映射关系的Map
     * @throws RuntimeException 当出现IntrospectionException、InvocationTargetException或IllegalAccessException时抛出
     */
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
            throw new RuntimeException("Error occurred while converting entity to map", e);
        }
    }
}
