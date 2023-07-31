package designPattern.designPatterns20_ObserverDesignPattern;

public class A4_MyTopicSubscriber implements A2_Observer {
	
	private String name;
	private A1_Subject topic;
	
	public A4_MyTopicSubscriber(String nm){
		this.name = nm;
	}

	@Override
	public void setSubject(A1_Subject sub) {
		this.topic = sub;
	}
	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if (msg == null) {
			System.out.println(name + ":: No new message");
		} else {
			System.out.println(name + ":: Consuming message::" + msg);
		}
	}
}

