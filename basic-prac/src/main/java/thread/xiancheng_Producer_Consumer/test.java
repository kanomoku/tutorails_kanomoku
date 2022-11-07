package thread.xiancheng_Producer_Consumer;

public class test {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Producer producer = new Producer(warehouse, "生产者");
        Consumer consumer1 = new Consumer(warehouse, "消费者1");
        Consumer consumer2 = new Consumer(warehouse, "消费者2");
        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
