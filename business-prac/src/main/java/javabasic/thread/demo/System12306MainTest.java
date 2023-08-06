package javabasic.thread.demo;

public class System12306MainTest {
    public static void main(String[] args) {
        System12306Windows w1 = new System12306Windows("北京北站");
        System12306Windows w2 = new System12306Windows("北京南站");
        System12306Windows w3 = new System12306Windows("北京西站");
        w1.start();
        w2.start();
        w3.start();
    }
}