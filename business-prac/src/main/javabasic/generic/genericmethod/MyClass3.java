package generic.genericmethod;

/**
 * 泛型方法
 */
class MyClass3 {
    public <T> void printInput(T t) {
        System.out.println(t);
    }

    public <T> T handleInput(T t) {
        return t;
    }

    public <T> String addPrefix(T t) {
        return "addPrefix" + t;
    }

    public <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println("泛型测试 t is " + t);
        }
    }

    public static void main(String[] args) {
        MyClass3 myClass3 = new MyClass3();
        myClass3.printInput("hello 泛型类");  // hello 泛型类

        Integer integer = myClass3.handleInput(55);
        System.out.println(integer); // 55

        String str = myClass3.addPrefix(55);
        System.out.println(str); // addPrefix55

        myClass3.printMsg("name", "葫芦娃", "age", 100);
        // 泛型测试 t is name
        // 泛型测试 t is 葫芦娃
        // 泛型测试 t is age
        // 泛型测试 t is 100
    }
}
