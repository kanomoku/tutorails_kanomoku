package innerclass;

/**
 * 成员内部类
 */
class Outer2 {
    public int age = 18;

    class Inner {
        public int age = 20;

        public void showAge() {
            int age = 25;
            System.out.println(age);//25
            System.out.println(this.age);//20
            System.out.println(Outer2.this.age);//18
        }
    }

    public static void main(String[] args) {
        Outer2.Inner inner = new Outer2().new Inner();
        inner.showAge();
    }
}