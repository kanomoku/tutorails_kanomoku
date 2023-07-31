package generic.genericmethod;

/**
 * 泛型方法 && 泛型类 并存
 */
public class MyClass4<T> {
    public void printInput(T t) {
        System.out.println(t);
    }

    public <T> T handleInput(T t) {
        return t;
    }

    public <E> E handleInput2(E t) {
        return t;
    }

    public static void main(String[] args) {
        MyClass4<String> myClass4 = new MyClass4<>();
        myClass4.printInput("Hello World"); // Hello World

        Integer integer = myClass4.handleInput(500);
        System.out.println(integer); // 500

        Boolean aBoolean = myClass4.handleInput2(true);
        System.out.println(aBoolean); // true
    }
}
