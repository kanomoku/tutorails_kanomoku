package initclass;

public class Son extends Father {
    static {
        System.out.println("子静态代码块");
    }

    public int age = 20;

    {
        System.out.println("子非静态代码块 " + age + " 有值说明确实先初始化变量再执行语句块");
        System.out.println("子非静态代码块");
    }

    public Son() {
        System.out.println("子构造器 " + age + " 子构造函数里查看值");
        System.out.println("子构造器执行完毕");
    }

    public static void main(String[] args) {
        new Son();
    }
}
