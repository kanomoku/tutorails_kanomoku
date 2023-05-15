package generic.genericclass;

/**
 * 泛型类
 */
class MyClass2<T, E> {
    private T value1;
    private E value2;

    public void testMethod1(T t, E e) {
        System.out.println(t + "→" + e);
    }

    public static void main(String[] args) {
        MyClass2<String, Integer> myClass2 = new MyClass2<>();
        myClass2.testMethod1("age", 18); // age→18
    }
}