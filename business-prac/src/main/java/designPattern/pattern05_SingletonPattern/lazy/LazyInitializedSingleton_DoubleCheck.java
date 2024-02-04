package designPattern.pattern05_SingletonPattern.lazy;

public class LazyInitializedSingleton_DoubleCheck {

	private static LazyInitializedSingleton_DoubleCheck instance;

	private LazyInitializedSingleton_DoubleCheck() {
	}

	public static LazyInitializedSingleton_DoubleCheck getInstanceUsingDoubleLocking(){
	    if(instance == null){
	        synchronized (LazyInitializedSingleton_DoubleCheck.class) {
	            if(instance == null){
	                instance = new LazyInitializedSingleton_DoubleCheck();
	            }
	        }
	    }
	    return instance;
	}
}
