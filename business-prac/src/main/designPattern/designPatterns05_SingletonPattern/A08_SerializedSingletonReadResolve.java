package designPattern.designPatterns05_SingletonPattern;

import java.io.Serializable;

//Sometimes in distributed systems,
//we need to implement Serializable interface in Singleton class 
//so that we can store its state in the file system and retrieve it at a later point of time

//The problem with serialized singleton class is that 
//whenever we deserialize it, it will create a new instance of the class
public class A08_SerializedSingletonReadResolve implements Serializable {

	private static final long serialVersionUID = -7604766932017737115L;

	private A08_SerializedSingletonReadResolve() {
	}

	private static class SingletonHelper {
		private static final A08_SerializedSingletonReadResolve instance = new A08_SerializedSingletonReadResolve();
	}

	public static A08_SerializedSingletonReadResolve getInstance() {
		return SingletonHelper.instance;
	}

	protected Object readResolve() {
	    return getInstance();
	}
}
