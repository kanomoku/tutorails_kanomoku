package designPattern.designPatterns18_MediatorDesignPattern;

public class A02_UserImpl extends A01_User {

	public A02_UserImpl(A03_ChatMediator med, String name) {
		super(med, name);
	}

	@Override
	public void send(String msg){
		System.out.println(this.name+": Sending Message="+msg);
		mediator.sendMessage(msg, this);
	}
	@Override
	public void receive(String msg) {
		System.out.println(this.name+": Received Message:"+msg);
	}
}
