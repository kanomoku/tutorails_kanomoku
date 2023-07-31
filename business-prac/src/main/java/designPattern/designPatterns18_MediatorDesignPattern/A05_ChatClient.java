package designPattern.designPatterns18_MediatorDesignPattern;

public class A05_ChatClient {

	public static void main(String[] args) {
		A03_ChatMediator mediator = new A04_ChatMediatorImpl();
		A01_User user1 = new A02_UserImpl(mediator, "Pankaj");
		A01_User user2 = new A02_UserImpl(mediator, "Lisa");
		A01_User user3 = new A02_UserImpl(mediator, "Saurabh");
		A01_User user4 = new A02_UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		
		user1.send("Hi All");
	}
}

