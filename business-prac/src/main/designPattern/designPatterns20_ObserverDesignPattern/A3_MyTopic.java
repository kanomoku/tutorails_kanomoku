package designPattern.designPatterns20_ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class A3_MyTopic implements A1_Subject {

	private List<A2_Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX = new Object();

	public A3_MyTopic() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void register(A2_Observer obj) {
		if (obj == null)
			throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
			if (!observers.contains(obj))
				observers.add(obj);
		}
	}

	@Override
	public void unregister(A2_Observer obj) {
		synchronized (MUTEX) {
			observers.remove(obj);
		}
	}

	@Override
	public Object getUpdate(A2_Observer obj) {
		return this.message;
	}

	// method to post message to the topic
	public void postMessage(String msg) {
		System.out.println("Message Posted to Topic:" + msg);
		this.message = msg;
		this.changed = true;
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		List<A2_Observer> observersLocal = null;
		// synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed) {
				return;
			}
			observersLocal = new ArrayList<>(this.observers);
			this.changed = false;
		}
		for (A2_Observer obj : observersLocal) {
			obj.update();
		}
	}
}
