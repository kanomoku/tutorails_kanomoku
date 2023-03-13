package superthis;

public class MainTest {
    public static void main(String[] args) {
        SuperPerson p = new SuperPerson();
        System.out.println();

        SuperPerson p1 = new SuperPerson("aa");
        System.out.println();

        Person p2 = new Person();
        System.out.println(p2.name);
        p2.eat();
        System.out.println();

        SuperPerson p3 = new SuperPerson("aa");
        p3.eat();
    }
}
