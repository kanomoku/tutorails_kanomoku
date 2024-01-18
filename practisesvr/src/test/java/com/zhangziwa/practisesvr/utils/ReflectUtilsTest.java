package com.zhangziwa.practisesvr.utils;

import com.zhangziwa.practisesvr.model.User;
import com.zhangziwa.practisesvr.utils.reflect.ReflectUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ReflectUtilsTest {
    @Test
    public void testGetChangeNoChange() {
        User user1 = new User();
        user1.setName("user2");
        user1.setAge("19");
        user1.setNum("123456");

        User user2 = new User();
        user2.setName("user2");
        user2.setAge("19");
        user2.setNum("123456");

        Map<String, Map<String, Object>> change = ReflectUtils.getChange(user1, user2);
        Assert.assertEquals("{}", change.toString());
        Map<String, List<Object>> change2 = ReflectUtils.getChange2(user1, user2);
        Assert.assertEquals("{}", change2.toString());
    }

    @Test
    public void testGetChangeWithChange() {
        User user1 = new User();
        user1.setName("user1");
        user1.setAge("19");
        user1.setNum("123456");

        User user2 = new User();
        user2.setName("user2");
        user2.setAge("18");
        user2.setNum("123457");

        Map<String, Map<String, Object>> change = ReflectUtils.getChange(user1, user2);
        Assert.assertEquals("{num={new=123457, origin=123456}, name={new=user2, origin=user1}, age={new=18, origin=19}}", change.toString());
        Map<String, List<Object>> change2 = ReflectUtils.getChange2(user1, user2);
        Assert.assertEquals("{num=[123456, 123457], name=[user1, user2], age=[19, 18]}", change2.toString());
    }

    @Test
    public void testGetFieldValue() {
        User user1 = new User();
        user1.setName("user1");
        user1.setAge("19");
        user1.setNum("123456");
        Assert.assertEquals("user1", ReflectUtils.getFieldValue(user1, "name"));
        Assert.assertEquals("19", ReflectUtils.getFieldValue(user1, "age"));
        Assert.assertEquals("123456", ReflectUtils.getFieldValue(user1, "num"));
    }

    @Test
    public void testSetFieldValue() {
        User user = new User();
        ReflectUtils.setFieldValue(user, "name", "user1");
        ReflectUtils.setFieldValue(user, "age", "19");
        ReflectUtils.setFieldValue(user, "num", "123456");
        Assert.assertEquals("user1", user.getName());
        Assert.assertEquals("19", user.getAge());
        Assert.assertEquals("123456", user.getNum());

        Map<String, List<String>> map = new HashMap<>();
        map.put("name", Arrays.asList("name1", "name2", "name3"));
        map.put("age", Arrays.asList("11", "23", "23"));
        map.put("num", Arrays.asList("123", "234", "345"));
    }

    @Test
    public void testGetFieldValue2() {
        User user1 = new User();
        user1.setName("user1");
        user1.setAge("19");
        user1.setNum("123456");

        List<String> strings = Arrays.asList("name", "age", "num");
        List<Object> collect = strings.stream().map(a -> ReflectUtils.getFieldValue(user1, a)).toList();
        System.out.println(collect);

    }

    @Test
    public void testSetFieldValue2() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("name", Arrays.asList("name1", "name2", "name3"));
        map.put("age", Arrays.asList("11", "23", "23"));
        map.put("num", Arrays.asList("123", "234", "345"));

        List<User> users = new ArrayList<>();
        List<String> fields = new ArrayList<>(map.keySet());
        int size = map.get(fields.get(0)).size();
        for (int i = 0; i < size; i++) {
            User user1 = new User();
            for (String field : fields) {
                String value = map.get(field).get(i);
                ReflectUtils.setFieldValue(user1, field, value);
            }
            users.add(user1);
        }
        System.out.println(users);
    }
}