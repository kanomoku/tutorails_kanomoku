package designPattern.designPatterns05_SingletonPattern;

public class LazyInitializedSingletonThreadSafe {

	private static LazyInitializedSingletonThreadSafe instance;

	private LazyInitializedSingletonThreadSafe() {
	}

	public static synchronized LazyInitializedSingletonThreadSafe getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingletonThreadSafe();
		}
		return instance;
	}
	
	//To avoid this extra overhead every time, double checked locking principle is used
	public static LazyInitializedSingletonThreadSafe getInstanceUsingDoubleLocking(){
	    if(instance == null){
	        synchronized (LazyInitializedSingletonThreadSafe.class) {
	            if(instance == null){
	                instance = new LazyInitializedSingletonThreadSafe();
	            }
	        }
	    }
	    return instance;
	}
}
