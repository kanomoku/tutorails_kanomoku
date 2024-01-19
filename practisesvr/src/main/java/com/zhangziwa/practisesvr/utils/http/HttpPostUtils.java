package com.zhangziwa.practisesvr.utils.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.zhangziwa.practisesvr.model.User;
import com.zhangziwa.practisesvr.utils.JsonUtils;
import com.zhangziwa.practisesvr.utils.reflect.ReflectUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Slf4j
public class HttpPostUtils {
    /**
     * 该方法用于发送一个HTTP POST请求，并附带JSON格式的请求数据。它包含了重试机制来应对可能的网络问题。
     *
     * @param uri  请求地址，不能为空字符串
     * @param json 请求体，必须是格式正确的JSON字符串，同样不能为空字符串
     * @return 如果HTTP响应状态码为200 OK，则返回服务器返回的数据（已解码为UTF-8格式的字符串）；否则抛出异常
     * @throws IOException    当无法成功打开或关闭HTTP连接时抛出此异常
     * @throws ParseException 如果服务器返回的数据无法被正确解析时抛出此异常
     */
    public String executeWithRetryHttpPostJson(String uri, String json) throws IOException, ParseException {
        if (StringUtils.isAnyBlank(uri, json)) {
            throw new IllegalArgumentException("URI or JSON data is blank.");
        }

        // 第1步:构建HttpClient客户端，设置重试处理器
        MyCustomRetryHandler myCustomRetryHandler = new MyCustomRetryHandler(3);
        CloseableHttpClient client = HttpClients.custom().setRetryHandler(myCustomRetryHandler).build();

        // 第2步:构建请求
        // 构建请求: 设置请求URI
        HttpPost httpPost = new HttpPost(uri);

        // 构建请求: 设置请求体
        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);

        // 构建请求: 设置超时时间
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(5000) // 超5秒还没返回新的可用链接，抛ConnectionPoolTimeoutException。默认值为0，表示无限等待。
                .setConnectTimeout(5000) // 超5秒还没建立链接，抛ConnectTimeoutException。默认值为0，表示无限等待。
                .setSocketTimeout(5000) // 超5秒还没返回数据，抛SocketTimeoutException。默认值为0，表示无限等待。
                .build();
        httpPost.setConfig(config);

        // 第3步: 客户端HttpClient 执行 请求HttpPost
        try (CloseableHttpResponse response = client.execute(httpPost, HttpClientContext.create())) {
            // 第4步: 解析返回的结果
            // 检查响应状态
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                // 处理非200状态码的情况
                throw new ParseException("Unexpected response status: " + response.getStatusLine().getStatusCode());
            }

            HttpEntity responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity, Consts.UTF_8.name());
        } catch (IOException | ParseException e) {
            log.error("Error occurred during HTTP request", e);
            throw e; // 重新抛出异常，提供更多上下文信息
        } finally {
            // 第5步: 关闭资源，处理异常
            client.close();
        }
    }

    private static List<User> getResJsonToUsers2(String resJson) {
        // 使用fastjson解析JSON字符串
        JSONObject jsonObject = JSON.parseObject(resJson, Feature.OrderedField);

        // 直接检查JSON对象是否为空，避免调用isEmpty()方法
        if (jsonObject == null || jsonObject.isEmpty()) {
            return new ArrayList<>();
        }

        // 热死JSON结构如下:{"num":["123","234","345"],"name":["name1","name2","name3"],"age":["11","23","23"]}
        // 获取JSONObject中数组字段的数量，这里假设所有数组长度一致
        List<String> fields = new ArrayList<>(jsonObject.keySet());
        int size = jsonObject.getJSONArray(fields.get(0)).size();

        List<User> res = new ArrayList<>(size);
        try {
            // 初始化PropertyDescriptor一次，避免多次调用Introspector.getBeanInfo()
            PropertyDescriptor[] properties = getPropertyDescriptors(User.class);

            for (int i = 0; i < size; i++) {
                User tempUser = new User();
                for (PropertyDescriptor property : properties) {
                    String propertyName = property.getName();
                    if ("serialVersionUID".equals(propertyName)) {
                        continue;
                    }
                    if (!jsonObject.containsKey(propertyName)) {
                        continue;
                    }
                    Method writeMethod = property.getWriteMethod();
                    Object value = jsonObject.getJSONArray(propertyName).get(i);
                    writeMethod.invoke(tempUser, value);
                }
                res.add(tempUser);
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Failed to parse JSON to User objects", e);
        }
        return res;
    }

    // 提取类的所有属性描述符并缓存，减少反射开销
    private static Map<Class<?>, PropertyDescriptor[]> cachedDescriptors = new HashMap<>();

    private static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) throws IntrospectionException {
        synchronized (cachedDescriptors) {
            if (!cachedDescriptors.containsKey(clazz)) {
                cachedDescriptors.put(clazz, Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors());
            }
            return cachedDescriptors.get(clazz);
        }
    }

    private static List<User> getResJsonToUsers(String resJson) {
        // 使用fastjson解析JSON字符串
        JSONObject jsonObject = JSON.parseObject(resJson, Feature.OrderedField);

        // 直接检查JSON对象是否为空，避免调用isEmpty()方法
        if (jsonObject == null || jsonObject.isEmpty()) {
            return new ArrayList<>();
        }

        // 热死JSON结构如下:{"num":["123","234","345"],"name":["name1","name2","name3"],"age":["11","23","23"]}
        // 获取JSONObject中数组字段的数量，这里假设所有数组长度一致
        List<String> fields = new ArrayList<>(jsonObject.keySet());
        int size = jsonObject.getJSONArray(fields.get(0)).size();

        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User tempUser = new User();
            for (String field : fields) {
                Object value = jsonObject.getJSONArray(field).get(i);
                ReflectUtils.setFieldValue(tempUser, field, value);
            }
            users.add(tempUser);
        }
        return users;
    }

    private static List<User> getResJsonToUsers3(String resJson) {
        // 使用fastjson解析JSON字符串
        JSONObject jsonObject = JSON.parseObject(resJson, Feature.OrderedField);

        // 直接检查JSON对象是否为空，避免调用isEmpty()方法
        if (jsonObject == null || jsonObject.isEmpty()) {
            return new ArrayList<>();
        }

        // 热死JSON结构如下:{"num":["123","234","345"],"name":["name1","name2","name3"],"age":["11","23","23"]}
        // 获取JSONObject中数组字段的数量，这里假设所有数组长度一致
        List<String> fields = new ArrayList<>(jsonObject.keySet());
        int size = jsonObject.getJSONArray(fields.get(0)).size();

        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User tempUser = new User();
            for (String field : fields) {
                try {
                    Object value = jsonObject.getJSONArray(field).get(i);
                    // 使用反射设置字段值，如果存在更好的方法，可以替换掉这一部分,此实现不推荐使用，仅了解
                    Field fieldObj = tempUser.getClass().getDeclaredField(field);
                    fieldObj.setAccessible(true);
                    fieldObj.set(tempUser, value);
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    throw new RuntimeException("Failed to parse JSON to User objects", e);
                }
            }
            users.add(tempUser);
        }
        return users;
    }

    public static void main(String[] args) {
        // 模拟返回的Json串
        Map<String, List<String>> map = new HashMap<>();
        map.put("name", Arrays.asList("name1", "name2", "name3"));
        map.put("age", Arrays.asList("11", "23", "23"));
        map.put("num", Arrays.asList("123", "234", "345"));
        String resJson = JsonUtils.toJson(map);
        System.out.println(resJson);
        // {"num":["123","234","345"],"name":["name1","name2","name3"],"age":["11","23","23"]}

        List<User> users = getResJsonToUsers(resJson);
        List<User> users2 = getResJsonToUsers2(resJson);
        List<User> users3 = getResJsonToUsers3(resJson);

        System.out.println(users);
        // [User(name=name1, age=11, num=123), User(name=name2, age=23, num=234), User(name=name3, age=23, num=345)]
        System.out.println(users2);
        // [User(name=name1, age=11, num=123), User(name=name2, age=23, num=234), User(name=name3, age=23, num=345)]
        System.out.println(users3);
        // [User(name=name1, age=11, num=123), User(name=name2, age=23, num=234), User(name=name3, age=23, num=345)]
    }
}
