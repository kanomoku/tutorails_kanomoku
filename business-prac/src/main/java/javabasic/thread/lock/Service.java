package thread.lock;

public class Service {
    private String lock = new String();

    private static void extracted() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "  代码快开始  " + System.currentTimeMillis());
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + "  →  " + i);
            Thread.sleep(1000);
        }
        System.out.println(Thread.currentThread().getName() + "  代码快结束  " + System.currentTimeMillis());
    }

    // 私有锁
    public void method_pri_lock() {
        try {
            System.out.println(Thread.currentThread().getName() + "  方法开始");
            synchronized (lock) {
                extracted();
            }
            System.out.println(Thread.currentThread().getName() + "  方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 局部私有锁
    public void method_loc_lock() {
        try {
            System.out.println(Thread.currentThread().getName() + "  方法开始");
            String lock = new String();
            synchronized (lock) {
                extracted();
            }
            System.out.println(Thread.currentThread().getName() + "  方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 对象锁 synchronized
    public synchronized void method_syn() {
        try {
            System.out.println(Thread.currentThread().getName() + "  方法开始");
            extracted();
            System.out.println(Thread.currentThread().getName() + "  方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 对象锁 this
    public void method_this() {
        try {
            System.out.println(Thread.currentThread().getName() + "  方法开始");
            synchronized (this) {
                extracted();
            }
            System.out.println(Thread.currentThread().getName() + "  方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 类锁 class
    public void method_class() {
        try {
            System.out.println(Thread.currentThread().getName() + "  方法开始");
            synchronized (Service.class) {
                extracted();
            }
            System.out.println(Thread.currentThread().getName() + "  方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 类锁 static syn
    public static synchronized void method_syn_static() {
        try {
            System.out.println(Thread.currentThread().getName() + "  方法开始");
            extracted();
            System.out.println(Thread.currentThread().getName() + "  方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}