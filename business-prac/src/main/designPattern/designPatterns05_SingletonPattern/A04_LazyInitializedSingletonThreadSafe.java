package designPattern.designPatterns05_SingletonPattern;

public class A04_LazyInitializedSingletonThreadSafe {

	private static A04_LazyInitializedSingletonThreadSafe instance;

	private A04_LazyInitializedSingletonThreadSafe() {
	}

	public static synchronized A04_LazyInitializedSingletonThreadSafe getInstance() {
		if (instance == null) {
			instance = new A04_LazyInitializedSingletonThreadSafe();
		}
		return instance;
	}
	
	//To avoid this extra overhead every time, double checked locking principle is used
	public static A04_LazyInitializedSingletonThreadSafe getInstanceUsingDoubleLocking(){
	    if(instance == null){
	        synchronized (A04_LazyInitializedSingletonThreadSafe.class) {
	            if(instance == null){
	                instance = new A04_LazyInitializedSingletonThreadSafe();
	            }
	        }
	    }
	    return instance;
	}
}
