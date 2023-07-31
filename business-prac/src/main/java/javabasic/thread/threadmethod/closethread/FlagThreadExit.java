package thread.threadmethod.closethread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public class FlagThreadExit {
    static class MyTask extends Thread {
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("I will start work. → " + new Date());
            while (!closed && !isInterrupted()) {
                //正在运行
            }
            System.out.println("I will be exiting. → " + new Date());
        }

        public void close() {
            this.closed = true;
            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask t = new MyTask();
        t.start();

        TimeUnit.MINUTES.sleep(1);
        System.out.println("System will be shutdown. → " + new Date());
        t.close();
    }
}
