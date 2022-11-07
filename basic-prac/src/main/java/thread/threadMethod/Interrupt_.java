package thread.threadMethod;


public class Interrupt_ extends Thread {
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            try {
                //1. 这里模拟正常测处理业务逻辑
                sleep(10);
                System.out.println("1");
                Thread.currentThread().interrupt(); //重新设置中断标志
                System.out.println("2");//只是给线程设置一个中断标志，线程仍会继续运行。
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //重新设置中断标志
            }
        }
        if (Thread.currentThread().isInterrupted()) {
                //2. 处理线程结束前必要的一些资源释放和清理工作；比如：释放锁，存储数据到持久层，发出异常通知
                System.out.println("3");
        }
    }

    public static void main(String[] args) {
        Interrupt_ interrupt = new Interrupt_();
        interrupt.run();
    }
}
