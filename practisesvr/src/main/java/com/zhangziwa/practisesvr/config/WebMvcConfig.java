package com.zhangziwa.practisesvr.config;

import com.zhangziwa.practisesvr.interceptor.ResponsePostInterceptor;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private ResponsePostInterceptor responsePostInterceptor;

    /**
     * 为拦截器注册表添加拦截器
     *
     * @param registry 拦截器注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 在Spring MVC配置中注册一个名为responsePostInterceptor的拦截器，使其能够对匹配路径“/**”（即对应用程序中的所有路径）的请求进行拦截
        registry.addInterceptor(responsePostInterceptor).addPathPatterns("/**");
    }

    /**
     * 向控制器注册表中添加视图控制器
     *
     * @param registry 控制器注册表
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //对于index.html的请求,设置返回的视图为index.htl
        registry.addViewController("/index.html").setViewName("/index.htl");
        //所有以.do结尾的请求重定向到/index.html请求
        registry.addRedirectViewController("/*.do", "/index.html");
    }

    /**
     * 用于添加资源处理器
     *
     * @param registry 资源处理器注册表
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/static/resources/")
                .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
    }

    /**
     * 配置视图解析器（ViewResolver）,用于在Spring应用程序中自定义如何解析视图
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 创建 InternalResourceViewResolver 对象
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // 设置视图资源的前缀为 "/WEB-INF/views/"
        resolver.setPrefix("/WEB-INF/views/");
        // 设置视图资源的后缀为 ".jsp"
        resolver.setSuffix(".jsp");
        // 注册视图解析器
        registry.viewResolver(resolver);
    }

    /**
     * 用于自定义配置HTTP消息转换器列表
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // StringHttpMessageConverter主要用于处理HTTP请求和响应中的字符串类型数据
        converters.add(new StringHttpMessageConverter());
    }

    /**
     * 为跨域访问添加映射
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许所有跨域访问
        registry.addMapping ("/**");

        // 更为精细的控制
        // 仅仅允许来自 domain2.com 的跨域访问，并且限定访问路径为api 、方法是 POST 或者 GET 。
        registry.addMapping("/api/**")
                .allowedOrigins("http://domain2.com")
                .allowedMethods("POST", "GET");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //注册一个日期格式转换器
        registry.addConverter(String.class, Date.class, DateUtils::parseDate);
    }
}
