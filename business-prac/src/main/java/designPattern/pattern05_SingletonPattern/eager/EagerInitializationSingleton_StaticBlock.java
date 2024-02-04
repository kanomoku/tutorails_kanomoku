package designPattern.pattern05_SingletonPattern.eager;

public class EagerInitializationSingleton_StaticBlock {

    private static final EagerInitializationSingleton_StaticBlock instance;

    private EagerInitializationSingleton_StaticBlock() {
    }

    // Static block initialization implementation is similar to eager initialization,
    // except that instance of class is created in the static block that provides option for exception handling.
    static {
        try {
            instance = new EagerInitializationSingleton_StaticBlock();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static EagerInitializationSingleton_StaticBlock getInstance() {
        return instance;
    }
}