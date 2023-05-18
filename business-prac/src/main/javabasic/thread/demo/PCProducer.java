package thread.demo;

import lombok.SneakyThrows;

/**
 * 生产者，一直向仓库添加元素
 */
public class PCProducer extends Thread {
    private PCWarehouse warehouse;
    private int count = 1;

    public PCProducer(PCWarehouse warehouse, String name) {
        this.warehouse = warehouse;
        super.setName(name);
    }

    @SneakyThrows
    public void run() {
        while (true) {
            warehouse.add();
            System.out.println(Thread.currentThread().getName() + " 第 " + count++ + " 次生产货物");
            Thread.sleep(500);
        }
    }
}