package designPattern.designPatterns20_ObserverDesignPattern;

public class A5_ObserverPatternTest {

	public static void main(String[] args) {
		//create subject 被观察者
		A3_MyTopic topic = new A3_MyTopic();
		
		//create observers  观察者
		A2_Observer obj1 = new A4_MyTopicSubscriber("Obj1");
		A2_Observer obj2 = new A4_MyTopicSubscriber("Obj2");
		A2_Observer obj3 = new A4_MyTopicSubscriber("Obj3");
		
		//register observers to the subject  告诉被观察者 都被谁观察了  为了通知时候不落下人
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		//attach observer to subject  告诉观察者去观察谁， 为了可以随时去获取被观察的状态
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		//check if any update is available  观察者随时去查看被观察者的信息
		obj1.update();
		
		//now send message to subject  被观察者随时可以发布信息给观察者
		topic.postMessage("New Message");   
	}
}
