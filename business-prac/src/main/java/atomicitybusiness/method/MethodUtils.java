package atomicitybusiness.method;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class MethodUtils {
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

        Map<String, Map<String, Object>> res = Maps.newHashMap();

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
            PropertyDescriptor propertyDescriptor = null;
            try {
                propertyDescriptor = new PropertyDescriptor(field.getName(), originObject.getClass());
                Method readMethod = propertyDescriptor.getReadMethod();
                Object originValue = readMethod.invoke(originObject);
                Object newValue = readMethod.invoke(newObject);
                if (!Objects.deepEquals(originValue, newValue)) {
                    // 值不相等的话记录属性和值
                    HashMap<String, Object> keyValue = new HashMap();
                    keyValue.put("origin", originValue);
                    keyValue.put("new", newValue);
                    res.put(field.getName(), keyValue);
                }
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                log.error("getChange occur error" + e.getMessage());
            }

        }
        return res;
    }

    public List<Integer> processTabIds(List<Integer> newTagIds, List<Integer> addTagIds, List<Integer> deleteTagIds, List<Integer> existingTagIds) {
        List<Integer> tagIds;
        if (CollectionUtils.isNotEmpty(existingTagIds)) {
            // 有既存的标签、就把他们当做源数据
            tagIds = existingTagIds;
        } else if (CollectionUtils.isNotEmpty(newTagIds)) {
            // 没有既存的标签、就把新传进来的newTagIds当做源数据
            tagIds = newTagIds;
        } else {
            // 没有既存的标签、也没有新传进来的newTagIds、把空列表当做源数据
            tagIds = new ArrayList<>();
        }

        // addTagIds,deleteTagIds都为空表示置换、用newTagIds整个替换原来的TagIds
        if (CollectionUtils.isEmpty(addTagIds) && CollectionUtils.isEmpty(deleteTagIds)) {
            // 不为null就表示要去置换、因为存在置空的情况
            if (Objects.nonNull(newTagIds)) {
                tagIds = newTagIds;
            }
        } else {
            // addTagIds,deleteTagIds都有值得话走更新逻辑
            if (CollectionUtils.isNotEmpty(addTagIds)) {
                // 增加标签
                tagIds.addAll(addTagIds);
            }
            if (CollectionUtils.isNotEmpty(deleteTagIds)) {
                // 删除标签
                tagIds.removeAll(deleteTagIds);
            }
        }
        return tagIds.stream().distinct().collect(Collectors.toList());
    }
}
