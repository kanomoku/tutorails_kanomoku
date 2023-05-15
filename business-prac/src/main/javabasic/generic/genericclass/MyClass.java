package generic.genericclass;

/**
 * 泛型类
 */
class MyClass<T> {
    private T message;

    public void testMethod1(T t) {
        System.out.println(t);
    }


    public static void main(String[] args) {
        MyClass<String> myClass1 = new MyClass<String>();
        myClass1.testMethod1("Hello World"); // Hello World
    }
}