package thread.threadDemo;

// 生产者
public class A_extends_ProducerConsumer_Producer extends Thread {
    private A_extends_ProducerConsumer_Warehouse warehouse;
    private int count = 1;

    public A_extends_ProducerConsumer_Producer(A_extends_ProducerConsumer_Warehouse warehouse, String name) {
        this.warehouse = warehouse;
        super.setName(name);
    }

    // 一直向仓库添加元素
    public void run() {
        while (true) {
            warehouse.add();
            System.out.println(Thread.currentThread().getName() + " 生存者" +
                    Thread.currentThread().getName() + "第"
                    + count++ + "次生产货物");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}