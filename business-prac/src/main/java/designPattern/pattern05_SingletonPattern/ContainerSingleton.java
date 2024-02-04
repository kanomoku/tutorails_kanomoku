package designPattern.pattern05_SingletonPattern;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static final Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }

    private static final ConcurrentHashMap<String, Object> beanCache = new ConcurrentHashMap<>();

    public static Object getBean1(String className) {
        // 使用try-with-resources来自动处理可能抛出的异常
        try {
            return beanCache.computeIfAbsent(className, k -> {
                try {
                    return Class.forName(k).newInstance();
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    log.error("Failed to instantiate bean: " + k);
                    return null;
                }
            });
        } catch (Exception e) {
            log.error("Error while retrieving bean: " + className);
            return null;
        }
    }
}
