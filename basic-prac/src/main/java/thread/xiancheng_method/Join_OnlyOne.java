package thread.xiancheng_method;

public class Join_OnlyOne extends Thread {
    public void run(){
        System.out.println("thread_one start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread_one end");
    }
}