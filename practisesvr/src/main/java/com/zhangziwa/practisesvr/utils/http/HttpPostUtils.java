package com.zhangziwa.practisesvr.utils.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.zhangziwa.practisesvr.model.User;
import com.zhangziwa.practisesvr.utils.JsonUtils;
import com.zhangziwa.practisesvr.utils.reflect.ReflectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class HttpPostUtils {
    /**
     * @param uri  the request address
     * @param json the request data that must be a JSON string
     * @throws IOException    if HTTP connection can not opened or closed successfully
     * @throws ParseException if response data can not be parsed successfully
     */
    public String retryPostJson(String uri, String json) throws IOException, ParseException {
        if (StringUtils.isAnyBlank(uri, json)) {
            return null;
        }

        // 第一步:构建HttpClient客户端
        CloseableHttpClient client = HttpClients.custom()
                                                .setRetryHandler(new RetryHandler()) // 失败重试机制
                                                .build();

        // 第2步:构建请求
        HttpPost httpPost = new HttpPost(uri);
        // 构建请求: 设置请求体
        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        // 构建请求: 设置超时时间
        RequestConfig config = RequestConfig.custom()
                                            .setConnectionRequestTimeout(5000) // 超5秒还没返回新的可用链接，抛ConnectionPoolTimeoutException。默认值为0，表示无限等待。
                                            .setConnectTimeout(5000) // 超5秒还没建立链接，抛ConnectTimeoutException。默认值为0，表示无限等待。
                                            .setSocketTimeout(5000) // 超5秒还没返回数据，抛SocketTimeoutException。默认值为0，表示无限等待。
                                            .build();
        httpPost.setConfig(config);

        // 第3步: 客户端HttpClient 执行 请求HttpPost
        CloseableHttpResponse response = null;
        String responseContent = null;
        try {
            response = client.execute(httpPost, HttpClientContext.create());

            // 第4步: 解析返回的结果
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                responseContent = EntityUtils.toString(response.getEntity(), Consts.UTF_8.name());
            }
        } finally {
            // 第5步: 关闭资源
            if (response != null) {
                response.close();
            }
            if (client != null) {
                client.close();
            }
        }
        return responseContent;
    }

    private static List<User> getResJsonToUsers2(String resJson) {
        // fastjson
        JSONObject jsonObject = JSON.parseObject(resJson, Feature.OrderedField);
        // 返回的属性
        List<String> fields = new ArrayList<>(jsonObject.keySet());
        // 属性有几个值
        int size = jsonObject.getJSONArray(fields.get(0)).size();

        List<User> res = new ArrayList<>();
        PropertyDescriptor[] properties;
        try {
            properties = Introspector.getBeanInfo(User.class, Object.class).getPropertyDescriptors();

            for (int i = 0; i < size; i++) {
                User tempUser = new User();
                for (PropertyDescriptor property : properties) {
                    String propertyName = property.getName();
                    if ("serialVersionUID".equals(propertyName)) {
                        continue;
                    }
                    if (!fields.contains(propertyName)) {
                        continue;
                    }
                    Method writeMethod = property.getWriteMethod();
                    Object value = jsonObject.getJSONArray(propertyName).get(i);
                    writeMethod.invoke(tempUser, value);
                }
                res.add(tempUser);
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private static List<User> getResJsonToUsers(String resJson) {
        // fastjson
        JSONObject jsonObject = JSON.parseObject(resJson, Feature.OrderedField);
        // 返回的属性
        List<String> fields = new ArrayList<>(jsonObject.keySet());
        // 属性有几个值
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

    public static void parserJsonToUser() {
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

        System.out.println(users);
        // [User(name=name1, age=11, num=123), User(name=name2, age=23, num=234), User(name=name3, age=23, num=345)]
        System.out.println(users2);
        // [User(name=name1, age=11, num=123), User(name=name2, age=23, num=234), User(name=name3, age=23, num=345)]
    }

    public static void main(String[] args) {
        parserJsonToUser();
    }
}
