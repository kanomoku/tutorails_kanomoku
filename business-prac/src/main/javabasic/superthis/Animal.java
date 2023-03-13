package superthis;

public class Animal {
    public String name = "animal";

    Animal() {
        System.out.println("Animal 无参数构造方法");
    }

    Animal(String name) {
        System.out.println("Animal 有参数构造方法");
    }

    public void eat() {
        this.sleep();
        System.out.println("animal eat");
    }

    public void sleep() {
        System.out.println("animal sleep");
    }
}