package generic.genericclass;

/**
 * 泛型类
 */
class MyClass<T> {
    private T message;

    public void printInput(T t) {
        System.out.println(t);
    }

    public String appendPrefix(T t) {
        return "appendPrefix → " + t;
    }


    public static void main(String[] args) {
        MyClass<String> myClass1 = new MyClass<>();
        myClass1.printInput("Hello World"); // Hello World
        String hello_world = myClass1.appendPrefix("Hello World");
        System.out.println(hello_world); // appendPrefix → Hello World


        MyClass<Integer> myClass2 = new MyClass<>();
        myClass2.printInput(100); // 100
        String hello_world2 = myClass2.appendPrefix(100);
        System.out.println(hello_world2); //appendPrefix → 100
    }
}