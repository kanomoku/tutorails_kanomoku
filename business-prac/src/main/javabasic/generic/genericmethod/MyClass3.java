package generic.genericmethod;

/**
 * 泛型方法
 */
class MyClass3 {
    public <T> void testMethod1(T t) {
        System.out.println(t);
    }

    public <T> T testMethod2(T t) {
        return t;
    }

    public <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println("泛型测试 t is " + t);
        }
    }

    public static void main(String[] args) {
        MyClass3 myClass3 = new MyClass3();
        myClass3.testMethod1("hello 泛型类");  // hello 泛型类

        Integer integer = myClass3.testMethod2(55);
        System.out.println(integer); // 55

        myClass3.printMsg("name", "葫芦娃", "age", 100);
        // 泛型测试 t is name
        // 泛型测试 t is 葫芦娃
        // 泛型测试 t is age
        // 泛型测试 t is 100
    }
}
