package jvm;

public class Xss {
    private static int count;

    private static void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        } catch (Throwable e) {
            System.out.println("调用最大深度：" + count);
            e.printStackTrace();
        }
    }
}
