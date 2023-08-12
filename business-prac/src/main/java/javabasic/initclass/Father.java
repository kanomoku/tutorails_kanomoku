package javabasic.initclass;

public class Father {
    public static Integer FATHER_NUM = 1;

    static {
        System.out.println("父 → static {}, FATHER_NUM = " + FATHER_NUM);
    }

    public int age = 0;

    {
        System.out.println("父 → {}, father age : " + age);
    }

    public Father(int age) {
        this.age = age;
        System.out.println("父 → 构造方法, father age : " + age);
    }
}
