package designPattern.pattern05_SingletonPattern.enums;

//To overcome this situation with Reflection

// the use of Enum to implement Singleton design pattern 
// as Java ensures that any enum value is instantiated only once in a Java program
public enum EnumSingleton_customErrMsg {
    INSTANCE;

    EnumSingleton_customErrMsg() {
        System.out.println("INSTANCE will be initialized immediately");
    }

    //The drawback is that the enum type is somewhat inflexible;
    //for example, it does not allow lazy initialization
    public static void doSomething() {
        // do something
    }
}
