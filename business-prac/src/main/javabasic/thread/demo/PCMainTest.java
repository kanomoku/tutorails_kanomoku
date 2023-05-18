package thread.demo;

public class PCMainTest {
    public static void main(String[] args) {
        PCWarehouse warehouse = new PCWarehouse();

        PCProducer producer = new PCProducer(warehouse, "生产者");
        PCConsumer consumer1 = new PCConsumer(warehouse, "消费者A");
        PCConsumer consumer2 = new PCConsumer(warehouse, "消费者B");
        producer.setPriority(10);

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
