package com.zhangziwa.practisesvr.utils.interceptor;

import com.github.pagehelper.page.PageMethod;
import com.zhangziwa.practisesvr.utils.response.ResponseContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ResponsePostInterceptor implements HandlerInterceptor {

    //在Controller执行之前调用，如果返回false，controller不执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("***ResponsePostInterceptor.preHandle***");
        return true;
    }

    //controller执行之后，且页面渲染之前调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("***ResponsePostInterceptor.postHandle***");
    }

    //页面渲染之后调用，一般用于资源清理操作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("***ResponsePostInterceptor.afterCompletion***");
        ResponseContext.clear(); // 清除业务层分页信息上下文
        PageMethod.clearPage(); // 清除PageHelper的分页信息上下文
    }
}
