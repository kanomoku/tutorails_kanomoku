package designPattern.designPatterns20_ObserverDesignPattern;

public interface A2_Observer {
	//attach with subject to observe  告诉观察者去观察谁
	public void setSubject(A1_Subject sub);
	
	//method to update the observer, used by subject  观察者作出响应
	public void update();
}

