package designPattern.designPatterns05_SingletonPattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class A13_ContainerSingleton {

	private A13_ContainerSingleton() {
	}

	private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

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
}
