package thread.xiancheng_method;

public class Join_OnlyTwo_In_One extends Thread {
    public void run() {
        System.out.println("thread_one start");
        Join_OnlyTwo two = new Join_OnlyTwo();
        two.start();
        System.out.println("thread_one End");
    }
}
//以上这样肯定保证two在one后面执行