package innerclass;

class Outer3 {
    int age = 10;
    static int age2 = 20;

    public Outer3() {
    }

    static class Inner {
        public void method() {
//            System.out.println(age); //报错
            System.out.println(age2);//正确
        }
    }

    public static void main(String[] args) {
        Outer3.Inner inner = new Outer3.Inner();
        inner.method();
    }
}
