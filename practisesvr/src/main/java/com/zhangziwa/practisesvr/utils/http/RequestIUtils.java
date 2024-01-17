package com.zhangziwa.practisesvr.utils.http;

import com.zhangziwa.practisesvr.utils.JsonUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;

public class RequestIUtils {
    /**
     * 从当前请求上下文中获取并解析请求体数据，将其转换为Map类型对象.
     *
     * @return 如果成功获取到请求体数据并转换成功，则返回一个包含请求体内容的Map对象；
     * 若RequestAttributes不存在或请求体数据为空，则返回一个新的空HashMap对象。
     */
    public static Map<String, Object> getRequestBodyBody() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return new HashMap<>();
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        Object requestBody = request.getAttribute("requestBodyData");
        if (requestBody == null) {
            return new HashMap<>();
        }
        return JsonUtils.jsonToT(requestBody.toString(), Map.class);
    }
}