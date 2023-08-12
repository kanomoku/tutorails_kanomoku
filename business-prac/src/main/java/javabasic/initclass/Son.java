package javabasic.initclass;

public class Son extends Father {
    public static Integer SON_NUM = 1;

    static {
        System.out.println("子 → static {}, SON_NUM = " + SON_NUM);
    }

    public int age = 0;

    {
        System.out.println("子 → {}, son age : " + age);
    }

    public Son(int age) {
        super(age + 20);
        this.age = age;
        System.out.println("子 → 构造方法, son age : " + age);
    }

    public static void main(String[] args) {
        new Son(18);
    }
}
