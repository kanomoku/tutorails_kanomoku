package thread.pcpattern.single;

import java.util.concurrent.TimeUnit;

// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public class EventClient {
    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();
        new Thread(() -> {
            for (; ; ) {
                eventQueue.offer(new EventQueue.Event());
            }
        }, "Producer").start();

        new Thread(() -> {
            for (; ; ) {
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();
    }
}
