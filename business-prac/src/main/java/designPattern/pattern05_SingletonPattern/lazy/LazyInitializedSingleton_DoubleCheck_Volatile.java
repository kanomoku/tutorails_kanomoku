package designPattern.pattern05_SingletonPattern.lazy;

public class LazyInitializedSingleton_DoubleCheck_Volatile {

    private volatile static LazyInitializedSingleton_DoubleCheck_Volatile instance;

    private LazyInitializedSingleton_DoubleCheck_Volatile() {
    }

    public static LazyInitializedSingleton_DoubleCheck_Volatile getInstance() {
        if (instance == null) {
            synchronized (LazyInitializedSingleton_DoubleCheck_Volatile.class) {
                if (instance == null) {
                    instance = new LazyInitializedSingleton_DoubleCheck_Volatile();
                }
            }
        }
        return instance;
    }
}
