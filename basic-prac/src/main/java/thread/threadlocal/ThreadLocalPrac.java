package thread.threadlocal;

public class ThreadLocalPrac {
    public static void main(String[] args) {
        //		1. 线程容器,给线程绑定一个Object 内容,后只要线程不变,可以随时取出.
        //			1.1 改变线程,无法取出内容.
        final ThreadLocal<String> threadlocal = new ThreadLocal<>();
        threadlocal.set("测试");

        String result = threadlocal.get();
        System.out.println(result);

        new Thread() {
            @Override public void run() {
                String result = threadlocal.get();
                System.out.println(result);
            }

        }.start();
    }
}