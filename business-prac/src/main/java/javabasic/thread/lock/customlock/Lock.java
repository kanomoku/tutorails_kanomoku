package thread.lock.customlock;

import java.util.List;
import java.util.concurrent.TimeoutException;

// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public interface Lock {
    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();
}