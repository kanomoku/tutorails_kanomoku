package thread.pcpattern.demo;

import lombok.SneakyThrows;

import java.util.ArrayList;

/**
 * 仓库
 */
public class PCWarehouse {
    private ArrayList<String> list = new ArrayList<>();


    public void add1() {
        if (list.size() < 20) {
            list.add("a");
            System.out.println(Thread.currentThread().getName() + " 生产1件货物以后，仓库有 " + list.size() + " 件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + " 仓库有 " + list.size() + " 件货物，所以不生产了");
            return;
        }
    }


    public void get1() {
        if (list.size() > 0) {
            list.remove(0);
            System.out.println(Thread.currentThread().getName() + " 取走 1 件货物以后，仓库有 " + list.size() + " 件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + " 仓库有 " + list.size() + " 件货物，所以不取了");
            return;
        }
    }


    public synchronized void add2() {
        if (list.size() < 20) {
            list.add("a");
            System.out.println(Thread.currentThread().getName() + " 生产1件货物以后，仓库有 " + list.size() + " 件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + " 仓库有 " + list.size() + " 件货物，所以不生产了");
            return;
        }
    }

    public synchronized void get2() {
        if (list.size() > 0) {
            list.remove(0);
            System.out.println(Thread.currentThread().getName() + " 取走 1 件货物以后，仓库有 " + list.size() + " 件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + " 仓库有 " + list.size() + " 件货物，所以不取了");
            return;
        }
    }

    @SneakyThrows
    public synchronized void add() {
        if (list.size() < 5) {
            list.add("a");
            System.out.println(Thread.currentThread().getName() + " 生产1件货物以后，仓库有 " + list.size() + " 件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + " 仓库有 " + list.size() + " 件货物，所以不生产了");
            this.wait();
        }
    }

    @SneakyThrows
    public synchronized void get() {
        if (list.size() > 0) {
            list.remove(0);
            System.out.println(Thread.currentThread().getName() + " 取走 1 件货物以后，仓库有 " + list.size() + " 件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + " 仓库有 " + list.size() + " 件货物，所以不取了");
            this.wait();
        }
    }

    @SneakyThrows
    public synchronized void add4() {
        if (list.size() < 5) {
            list.add("a");
            System.out.println(Thread.currentThread().getName() + " 生产1件货物以后，仓库有 " + list.size() + " 件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + " 仓库有 " + list.size() + " 件货物，所以不生产了");
            this.notifyAll();
            this.wait();
        }
    }

    @SneakyThrows
    public synchronized void get4() {
        if (list.size() > 0) {
            list.remove(0);
            System.out.println(Thread.currentThread().getName() + " 取走 1 件货物以后，仓库有 " + list.size() + " 件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + " 仓库有 " + list.size() + " 件货物，所以不取了");
            this.notifyAll();
            this.wait();
        }
    }

    @SneakyThrows
    public void add5() {
        if (list.size() < 5) {
            list.add("a");
            System.out.println(Thread.currentThread().getName() + " 生产 1 件货物以后，仓库有 " + list.size() + " 件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + " 仓库有 " + list.size() + " 件货物，所以不生产了");
            this.notifyAll();
            this.wait();
        }
    }

    @SneakyThrows
    public void get5() {
        if (list.size() > 0) {
            list.remove(0);
            System.out.println(Thread.currentThread().getName() + " 取走 1 件货物以后，仓库有 " + list.size() + " 件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + " 仓库有 " + list.size() + " 件货物，所以不取了");
            this.notifyAll();
            this.wait();
        }
    }
}
