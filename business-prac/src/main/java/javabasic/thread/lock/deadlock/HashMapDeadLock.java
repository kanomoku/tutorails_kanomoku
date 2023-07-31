package thread.lock.deadlock;

import java.util.HashMap;

// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public class HashMapDeadLock {
    private final HashMap<String, String> map = new HashMap<>();

    public void add(String key, String value) {
        this.map.put(key, value);
    }

    public static void main(String[] args) {
        final HashMapDeadLock hmdl = new HashMapDeadLock();
        for (int x = 0; x < 2; x++)
            new Thread(() -> {
                for (int i = 1; i < Integer.MAX_VALUE; i++) {
                    hmdl.add(String.valueOf(i), String.valueOf(i));
                }
            }).start();
    }
}