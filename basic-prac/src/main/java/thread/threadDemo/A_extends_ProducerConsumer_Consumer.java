package thread.threadDemo;

// 消费者
public class A_extends_ProducerConsumer_Consumer extends Thread {
    // 消费者的方法 一直从仓库里拿
    private A_extends_ProducerConsumer_Warehouse warehouse;
    private int count = 1;

    public A_extends_ProducerConsumer_Consumer(A_extends_ProducerConsumer_Warehouse warehouse, String name) {
        this.warehouse = warehouse;
        super.setName(name);
    }

    public void run() {
        while (true) {
            warehouse.get();
            System.out.println(Thread.currentThread().getName() + " 消费者" +
                    Thread.currentThread().getName() + "第"
                    + count++ + "次拿货物");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}