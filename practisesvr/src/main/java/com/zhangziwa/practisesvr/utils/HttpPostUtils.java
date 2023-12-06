package com.zhangziwa.practisesvr.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import lombok.Data;
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

import java.io.IOException;
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

        // 构建HttpClient
        CloseableHttpClient client = HttpClients.custom().setRetryHandler(new RetryHandler()).build();

        // 构建请求
        HttpPost httpPost = new HttpPost(uri);
        // 设置请求体
        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        // 设置超时时间
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(5000) // 超5秒还没返回新的可用链接，抛ConnectionPoolTimeoutException。默认值为0，表示无限等待。
                .setConnectTimeout(5000) // 超5秒还没建立链接，抛ConnectTimeoutException。默认值为0，表示无限等待。
                .setSocketTimeout(5000) // 超5秒还没返回数据，抛SocketTimeoutException。默认值为0，表示无限等待。
                .build();
        httpPost.setConfig(config);

        // Response
        CloseableHttpResponse response = null;
        String responseContent = null;
        try {
            response = client.execute(httpPost, HttpClientContext.create());
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                responseContent = EntityUtils.toString(response.getEntity(), Consts.UTF_8.name());
            }
        } finally {
            if (response != null) {
                response.close();
            }
            if (client != null) {
                client.close();
            }
        }
        return responseContent;
    }

    public static List<User> parserJsonToUser() {
        // 模拟返回的Json串
        Map<String, List<String>> map = new HashMap<>();
        map.put("name", Arrays.asList("name1", "name2", "name3"));
        map.put("age", Arrays.asList("11", "23", "23"));
        map.put("num", Arrays.asList("123", "234", "345"));
        String json1 = JsonUtils.toJson(map);
        System.out.println(json1);


        // fastjson
        JSONObject jsonObject = JSON.parseObject(json1, Feature.OrderedField);

        // 返回的属性
        List<String> fields = new ArrayList<>(map.keySet());
        // 几份值
        int size = jsonObject.getJSONArray(fields.get(0)).size();

        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User user1 = new User();
            for (String field : fields) {
                Object value = jsonObject.getJSONArray(field).get(i);
                ReflectUtils.setFieldValue(user1, field, value);
            }
            users.add(user1);
        }

        System.out.println(users);
        return users;
    }

    public static void main(String[] args) {
        parserJsonToUser();
    }

    @Data
    static class User {
        private String name;
        private String age;
        private String num;
    }
}
