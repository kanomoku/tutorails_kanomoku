package initclass;

public class Father {
    static {
        System.out.println("父静态代码块");
    }

    public int age = 10;

    {
        System.out.println("父非静态代码块 " + age + " 有值说明确实先初始化变量再执行语句块");
        System.out.println("父非静态代码块");
    }

    public Father() {
        System.out.println("父构造器 " + age + " 父构造函数里查看值");
        System.out.println("父构造器执行完毕");
    }
}
