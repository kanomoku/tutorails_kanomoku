package thread.lock;

import org.junit.Test;

public class MainTest {
    public static void main(String[] args) {
//        test_diff_task();

        // 私有锁
//        test_same_privatelock();
//        test_diff_privatelock();

        // 对象锁
//        test_this_this();
//        test_syn_syn();
//        test_syn_this();

        // 对象锁和私有锁比价
//        test_privatelock_syn();
//        test_privatelock_this();

        // 类锁
//        test_synstatic_synstatic();
//        test_class_class();
//        test_synstatic_class();

        // 类锁和对象锁对比
//        test_class_this();
//        test_class_syn();
//        test_synstatic_this();
//        test_synstatic_syn();

        // 类锁和私有锁对比
//        test_privatelock_synstatic();
        test_privatelock_class();
    }

    // 不同线程任务
    public static void test_diff_task() {
        Service service = new Service();
        Service service1 = new Service();
        ThreadPriLock a = new ThreadPriLock(service);
        a.setName("线程A");
        a.start();
        ThreadLocLock b = new ThreadLocLock(service1);
        b.setName("线程B");
        b.start();
    }

    // 相同私有锁
    public static void test_same_privatelock() {
        Service service = new Service();
        ThreadPriLock a = new ThreadPriLock(service);
        a.setName("线程A");
        a.start();
        ThreadPriLock b = new ThreadPriLock(service);
        b.setName("线程B");
        b.start();
    }

    // 不同私有锁
    public static void test_diff_privatelock() {
        Service service = new Service();
        ThreadLocLock a = new ThreadLocLock(service);
        a.setName("线程A");
        a.start();
        ThreadLocLock b = new ThreadLocLock(service);
        b.setName("线程B");
        b.start();
    }

    // 对象锁this 对象锁this
    private static void test_this_this() {
        Service service = new Service();
        ThreadThis a = new ThreadThis(service);
        a.setName("线程A");
        a.start();
        ThreadThis b = new ThreadThis(service);
        b.setName("线程B");
        b.start();
    }

    // 对象锁syn 对象锁syn
    private static void test_syn_syn() {
        Service service = new Service();
        ThreadSyn a = new ThreadSyn(service);
        a.setName("线程A");
        a.start();
        ThreadSyn b = new ThreadSyn(service);
        b.setName("线程B");
        b.start();
    }

    // 对象锁syn 对象锁this
    private static void test_syn_this() {
        Service service = new Service();
        ThreadSyn a = new ThreadSyn(service);
        a.setName("线程A");
        a.start();
        ThreadThis b = new ThreadThis(service);
        b.setName("线程B");
        b.start();
    }


    // 对比 → 私有锁 对象锁syn
    public static void test_privatelock_syn() {
        Service service = new Service();
        ThreadPriLock a = new ThreadPriLock(service);
        a.setName("线程A");
        a.start();
        ThreadSyn b = new ThreadSyn(service);
        b.setName("线程B");
        b.start();
    }

    // 对比 → 私有锁 对象锁this
    public static void test_privatelock_this() {
        Service service = new Service();
        ThreadPriLock a = new ThreadPriLock(service);
        a.setName("线程A");
        a.start();
        ThreadThis b = new ThreadThis(service);
        b.setName("线程B");
        b.start();
    }

    // 类锁syn static 类锁syn static
    public static void test_synstatic_synstatic() {
        Service service = new Service();
        ThreadSynStatic a = new ThreadSynStatic(service);
        a.setName("线程A");
        a.start();
        ThreadSynStatic b = new ThreadSynStatic(service);
        b.setName("线程B");
        b.start();
    }

    // 类锁 class 类锁 class
    public static void test_class_class() {
        Service service = new Service();
        ThreadClass a = new ThreadClass(service);
        a.setName("线程A");
        a.start();
        ThreadClass b = new ThreadClass(service);
        b.setName("线程B");
        b.start();
    }

    // 类锁syn static 类锁 class
    public static void test_synstatic_class() {
        Service service = new Service();
        ThreadSynStatic a = new ThreadSynStatic(service);
        a.setName("线程A");
        a.start();
        ThreadClass b = new ThreadClass(service);
        b.setName("线程B");
        b.start();
    }

    // 对比 → 类锁 class 对象锁this
    public static void test_class_this() {
        Service service = new Service();
        ThreadClass a = new ThreadClass(service);
        a.setName("线程A");
        a.start();
        ThreadThis b = new ThreadThis(service);
        b.setName("线程B");
        b.start();
    }

    // 对比 → 类锁 class 对象锁syn
    public static void test_class_syn() {
        Service service = new Service();
        ThreadClass a = new ThreadClass(service);
        a.setName("线程A");
        a.start();
        ThreadSyn b = new ThreadSyn(service);
        b.setName("线程B");
        b.start();
    }

    // 对比 → 类锁syn static 对象锁this
    public static void test_synstatic_this() {
        Service service = new Service();
        ThreadSynStatic a = new ThreadSynStatic(service);
        a.setName("线程A");
        a.start();
        ThreadThis b = new ThreadThis(service);
        b.setName("线程B");
        b.start();
    }

    // 对比 → 类锁syn static 对象锁syn
    public static void test_synstatic_syn() {
        Service service = new Service();
        ThreadSynStatic a = new ThreadSynStatic(service);
        a.setName("线程A");
        a.start();
        ThreadSyn b = new ThreadSyn(service);
        b.setName("线程B");
        b.start();
    }

    // 对比 → 私有锁 类锁syn static
    public static void test_privatelock_synstatic() {
        Service service = new Service();
        ThreadPriLock a = new ThreadPriLock(service);
        a.setName("线程A");
        a.start();
        ThreadSynStatic b = new ThreadSynStatic(service);
        b.setName("线程B");
        b.start();
    }

    // 对比 → 私有锁 类锁 class
    public static void test_privatelock_class() {
        Service service = new Service();
        ThreadPriLock a = new ThreadPriLock(service);
        a.setName("线程A");
        a.start();
        ThreadClass b = new ThreadClass(service);
        b.setName("线程B");
        b.start();
    }
}