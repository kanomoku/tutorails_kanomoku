package designPattern.designPatterns20_ObserverDesignPattern;

public interface A1_Subject {

	//methods to register and unregister observers  可以被谁观察
	public void register(A2_Observer obj);
	public void unregister(A2_Observer obj);
	
	//method to get updates from subject  可以随时被观察者查看状态
	public Object getUpdate(A2_Observer obj);
	
	//method to notify observers of change  去通知观察者
	public void notifyObservers();
}
