package designPattern.designPatterns05_SingletonPattern;

public class StaticBlockInitializationSingleton {

    private static StaticBlockInitializationSingleton instance;

    private StaticBlockInitializationSingleton() {
    }

    // Static block initialization implementation is similar to eager initialization,
    // except that instance of class is created in the static block that provides option for exception handling.
    static {
        try {
            instance = new StaticBlockInitializationSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static StaticBlockInitializationSingleton getInstance() {
        return instance;
    }
}