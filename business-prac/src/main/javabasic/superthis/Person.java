package superthis;

public class Person extends Animal {
    public String name = super.name;

    public Person() {
        System.out.println("Person 无参数构造方法");
    }

    public Person(String name) {
        System.out.println("Person 有参数构造方法");
    }

    public void eat() {
        System.out.println("--------------------------------");
        this.sleep();
        System.out.println("--------------------------------");
        super.sleep();
        System.out.println("--------------------------------");
        super.eat();
        System.out.println("--------------------------------");
        System.out.println("Person eat");
        System.out.println("--------------------------------");
    }

    public void sleep() {
        System.out.println("Person sleep");
    }
}