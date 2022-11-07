package thread.threadDemo;

public class A_extends_ProducerConsumer_MainTest {
    public static void main(String[] args) {
        A_extends_ProducerConsumer_Warehouse warehouse = new A_extends_ProducerConsumer_Warehouse();
        A_extends_ProducerConsumer_Producer producer = new A_extends_ProducerConsumer_Producer(warehouse, "Producer");
        A_extends_ProducerConsumer_Consumer consumer1 = new A_extends_ProducerConsumer_Consumer(warehouse, "Con1");
        A_extends_ProducerConsumer_Consumer consumer2 = new A_extends_ProducerConsumer_Consumer(warehouse, "Con2");
//        producer.setPriority(10);
        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
