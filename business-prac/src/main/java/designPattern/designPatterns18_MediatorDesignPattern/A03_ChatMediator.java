package designPattern.designPatterns18_MediatorDesignPattern;

public interface A03_ChatMediator {
	public void sendMessage(String msg, A01_User user);
	void addUser(A01_User user);
}

