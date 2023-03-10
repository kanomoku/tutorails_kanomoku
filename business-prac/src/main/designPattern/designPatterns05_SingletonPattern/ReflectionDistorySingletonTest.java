package designPattern.designPatterns05_SingletonPattern;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class ReflectionDistorySingletonTest {

    @Test
    public void test1() {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    @Test
    public void test2() {
        StaticBlockInitializationSingleton instanceOne = StaticBlockInitializationSingleton.getInstance();
        StaticBlockInitializationSingleton instanceTwo = null;
        try {
            Constructor[] constructors = StaticBlockInitializationSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (StaticBlockInitializationSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    @Test
    public void test3() {
        LazyInitializedSingleton instanceOne = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = LazyInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (LazyInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    @Test
    public void test4() {
        LazyInitializedSingletonThreadSafe instanceOne = LazyInitializedSingletonThreadSafe.getInstance();
        LazyInitializedSingletonThreadSafe instanceTwo = null;
        try {
            Constructor[] constructors = LazyInitializedSingletonThreadSafe.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (LazyInitializedSingletonThreadSafe) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    @Test
    public void test5() {
        BillPughSingleton instanceOne = BillPughSingleton.getInstance();
        BillPughSingleton instanceTwo = null;
        try {
            Constructor[] constructors = BillPughSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (BillPughSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    @Test
    public void test5_2() {
        BillPughSingletonProtectFromReflect instanceOne = BillPughSingletonProtectFromReflect.getInstance();
        BillPughSingletonProtectFromReflect instanceTwo = null;
        try {
            Constructor[] constructors = BillPughSingletonProtectFromReflect.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (BillPughSingletonProtectFromReflect) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    @Test
    public void test6() {
        EnumSingleton instanceOne = EnumSingleton.INSTANCE;
        System.out.println(instanceOne.hashCode());

        EnumSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EnumSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EnumSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceTwo.hashCode());

    }

    @Test
    public void test7() {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        SerializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = SerializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (SerializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    @Test
    public void test8() {
        SerializedSingletonReadResolve instanceOne = SerializedSingletonReadResolve.getInstance();

        SerializedSingletonReadResolve instanceTwo = null;
        try {
            Constructor[] constructors = SerializedSingletonReadResolve.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (SerializedSingletonReadResolve) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
