package designPattern.pattern05_SingletonPattern.reflect;

import designPattern.pattern05_SingletonPattern.billpugh.BillPughSingleton;
import designPattern.pattern05_SingletonPattern.billpugh.BillPughSingleton_ProtectFromReflect;
import designPattern.pattern05_SingletonPattern.eager.EagerInitializationSingleton_StaticBlock;
import designPattern.pattern05_SingletonPattern.eager.EagerInitializedSingleton;
import designPattern.pattern05_SingletonPattern.enums.EnumSingleton;
import designPattern.pattern05_SingletonPattern.enums.EnumSingleton_customErrMsg;
import designPattern.pattern05_SingletonPattern.lazy.LazyInitializedSingleton;
import designPattern.pattern05_SingletonPattern.lazy.LazyInitializedSingleton_DoubleCheck_Volatile;
import designPattern.pattern05_SingletonPattern.lazy.LazyInitializedSingleton_ThreadSafe;
import designPattern.pattern05_SingletonPattern.serialize.SerializedSingleton;
import designPattern.pattern05_SingletonPattern.serialize.SerializedSingleton_ReadResolve;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class Main_ReflectionDistorySingleton {

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
        EagerInitializationSingleton_StaticBlock instanceOne = EagerInitializationSingleton_StaticBlock.getInstance();
        EagerInitializationSingleton_StaticBlock instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializationSingleton_StaticBlock.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializationSingleton_StaticBlock) constructor.newInstance();
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
        LazyInitializedSingleton_ThreadSafe instanceOne = LazyInitializedSingleton_ThreadSafe.getInstance();
        LazyInitializedSingleton_ThreadSafe instanceTwo = null;
        try {
            Constructor[] constructors = LazyInitializedSingleton_ThreadSafe.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (LazyInitializedSingleton_ThreadSafe) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    @Test
    public void test4_1() {
        LazyInitializedSingleton_DoubleCheck_Volatile instanceOne = LazyInitializedSingleton_DoubleCheck_Volatile.getInstance();
        LazyInitializedSingleton_DoubleCheck_Volatile instanceTwo = null;
        try {
            Constructor[] constructors = LazyInitializedSingleton_DoubleCheck_Volatile.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (LazyInitializedSingleton_DoubleCheck_Volatile) constructor.newInstance();
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
        BillPughSingleton_ProtectFromReflect instanceOne = BillPughSingleton_ProtectFromReflect.getInstance();
        BillPughSingleton_ProtectFromReflect instanceTwo = null;
        try {
            Constructor[] constructors = BillPughSingleton_ProtectFromReflect.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (BillPughSingleton_ProtectFromReflect) constructor.newInstance();
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
    public void test6_2() {
        EnumSingleton_customErrMsg instanceOne = EnumSingleton_customErrMsg.INSTANCE;
        System.out.println(instanceOne.hashCode());

        EnumSingleton_customErrMsg instanceTwo = null;
        try {
            Constructor[] constructors = EnumSingleton_customErrMsg.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EnumSingleton_customErrMsg) constructor.newInstance();
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
        SerializedSingleton_ReadResolve instanceOne = SerializedSingleton_ReadResolve.getInstance();

        SerializedSingleton_ReadResolve instanceTwo = null;
        try {
            Constructor[] constructors = SerializedSingleton_ReadResolve.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (SerializedSingleton_ReadResolve) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
