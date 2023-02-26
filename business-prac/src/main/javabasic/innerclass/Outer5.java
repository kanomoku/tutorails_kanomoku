package innerclass;

interface Inner {
    public abstract void show();
}

class Outer5 {
    public void method() {
        new Inner() {
            public void show() {
                System.out.println("HelloWorld");
            }
        }.show();
    }

    public static void main(String[] args) {
        Outer5 o = new Outer5();
        o.method();
    }
}