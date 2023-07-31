package designPattern.designPatterns18_MediatorDesignPattern;

public abstract class A01_User {
	protected A03_ChatMediator mediator;
	protected String name;
	
	public A01_User(A03_ChatMediator med, String name){
		this.mediator=med;
		this.name=name;
	}
	
	public abstract void send(String msg);
	
	public abstract void receive(String msg);
}
