package innerclass;

/**
 * 局部内部类
 */
class Outer4 {
    private int age = 20;

    public void method() {
        final int age2 = 30;
        class Inner {
            public void show() {
                System.out.println(age); // 20
                //从内部类中访问方法内变量age2，需要将变量声明为final类型
                System.out.println(age2); // 30
            }
        }

        System.out.println("外部类输出1");
        Inner inner = new Inner();
        inner.show();
        System.out.println("外部类输出2");
    }

    public static void main(String[] args) {
        Outer4 inner = new Outer4();
        inner.method();
    }
}