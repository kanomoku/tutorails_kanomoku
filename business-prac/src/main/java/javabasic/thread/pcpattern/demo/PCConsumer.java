package javabasic.thread.pcpattern.demo;

import lombok.SneakyThrows;

/**
 * 消费者,一直从仓库里拿
 */
public class PCConsumer extends Thread {
    private PCWarehouse warehouse;
    private int count = 1;

    public PCConsumer(PCWarehouse warehouse, String name) {
        this.warehouse = warehouse;
        super.setName(name);
    }

    @SneakyThrows
    public void run() {
        while (true) {
            warehouse.get();
            System.out.println(Thread.currentThread().getName() + " 第 " + count++ + " 次拿货物");
            Thread.sleep(300);
        }
    }
}