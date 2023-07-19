package generic.genericclass;

/**
 * 泛型类
 */
class MyClass2<T, E> {
    private T value1;
    private E value2;

    public void printAppendMessage(T t, E e) {
        System.out.println("append: " + t + "→" + e);
    }

    public static void main(String[] args) {
        MyClass2<String, Integer> myClass2 = new MyClass2<>();
        myClass2.printAppendMessage("age", 18); // append: age→18
    }
}