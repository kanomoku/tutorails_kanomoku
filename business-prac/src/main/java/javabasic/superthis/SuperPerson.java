package superthis;

public class SuperPerson extends Person {
    public SuperPerson() {
        System.out.println("SuperPerson 无参数构造方法");
    }

    public SuperPerson(String name) {
        System.out.println("SuperPerson 有参数构造方法");
    }

    public void eat() {
        this.sleep();
        System.out.println("SuperPerson eat");
    }

    public void sleep() {
        System.out.println("SuperPerson sleep");
    }
}