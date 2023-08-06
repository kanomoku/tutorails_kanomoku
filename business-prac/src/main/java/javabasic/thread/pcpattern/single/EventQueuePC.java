package javabasic.thread.pcpattern.single;

import java.util.LinkedList;

import static java.lang.Thread.currentThread;

// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public class EventQueuePC {
    private final int max;

    static class Event {
    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();
    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueuePC() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueuePC(int max) {
        this.max = max;
    }

    private void console(String message) {
        System.out.printf("%s：%s\n", currentThread().getName(), message);
    }

    public void offerSafe(Event event) {
        synchronized (eventQueue) {
            while (eventQueue.size() >= max) {
                try {
                    console(" the queue is full.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console(" the new event is submitted");
            eventQueue.addLast(event);
            eventQueue.notifyAll();
        }
    }

    public Event takeSafe() {
        synchronized (eventQueue) {
            while (eventQueue.isEmpty()) {
                try {
                    console(" the queue is empty.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notifyAll();
            console(" the event " + event + " is handled.");
            return event;
        }
    }
}