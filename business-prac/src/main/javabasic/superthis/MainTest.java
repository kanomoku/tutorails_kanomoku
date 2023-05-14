package superthis;

import org.junit.Test;

public class MainTest {
    public static void main(String[] args) {
//        SuperPerson p = new SuperPerson();

//        SuperPerson p1 = new SuperPerson("孙悟空");

//        SuperPerson p3 = new SuperPerson("aa");
//        p3.eat();
    }

    @Test
    public void test() {
        Person person = new Person();
        System.out.println(person.name);
        person.eat();
    }
}
