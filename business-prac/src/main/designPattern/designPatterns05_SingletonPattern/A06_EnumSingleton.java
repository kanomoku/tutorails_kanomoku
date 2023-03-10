package designPattern.designPatterns05_SingletonPattern;

//To overcome this situation with Reflection

// the use of Enum to implement Singleton design pattern 
//as Java ensures that any enum value is instantiated only once in a Java program
public enum A06_EnumSingleton {

	INSTANCE;

	//The drawback is that the enum type is somewhat inflexible; 
	//for example, it does not allow lazy initialization
	public static void doSomething() {
		// do something
	}
}
