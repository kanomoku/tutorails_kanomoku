package designPattern.pattern05_SingletonPattern.lazy;

public class LazyInitializedSingleton_ThreadSafe {

	private static LazyInitializedSingleton_ThreadSafe instance;

	private LazyInitializedSingleton_ThreadSafe() {
	}

	public static synchronized LazyInitializedSingleton_ThreadSafe getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton_ThreadSafe();
		}
		return instance;
	}
	
	//To avoid this extra overhead every time, double checked locking principle is used
	public static LazyInitializedSingleton_ThreadSafe getInstanceUsingDoubleLocking(){
	    if(instance == null){
	        synchronized (LazyInitializedSingleton_ThreadSafe.class) {
	            if(instance == null){
	                instance = new LazyInitializedSingleton_ThreadSafe();
	            }
	        }
	    }
	    return instance;
	}
}
