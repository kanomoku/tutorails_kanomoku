package generic.genericmethod;

/**
 * 泛型方法 && 泛型类 并存
 */
public class MyClass4<T> {
    public void testMethod1(T t) {
        System.out.println(t);
    }

    public <T> T testMethod2(T t) {
        return t;
    }

    public static void main(String[] args) {
        MyClass4<String> myClass4 = new MyClass4<>();
        myClass4.testMethod1("Hello World"); // Hello World

        Integer integer = myClass4.testMethod2(500);
        System.out.println(integer); // 500
    }
}
