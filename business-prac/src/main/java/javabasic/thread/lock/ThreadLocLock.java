package javabasic.thread.lock;

import javabasic.thread.lock.Service;

public class ThreadLocLock extends Thread {
    private Service service;

    public ThreadLocLock(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.method_loc_lock();
    }
}