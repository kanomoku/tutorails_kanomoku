package innerclass;

interface Inner {
    void show();
}

/**
 * 匿名内部类
 */
class Outer5 {
    public void method() {
        new Inner() {
            @Override
            public void show() {
                System.out.println("HelloWorld");
            }
        }.show();
    }

    public void method2() {
        ((Inner) () -> System.out.println("HelloWorld2")).show();
    }

    public static void main(String[] args) {
        Outer5 o = new Outer5();
        o.method();
        o.method2();
    }
}