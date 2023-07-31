package designPattern.designPatterns18_MediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class A04_ChatMediatorImpl implements A03_ChatMediator {

	private List<A01_User> users;
	
	public A04_ChatMediatorImpl(){
		this.users=new ArrayList<>();
	}
	
	@Override
	public void addUser(A01_User user){
		this.users.add(user);
	}
	
	@Override
	public void sendMessage(String msg, A01_User user) {
		for(A01_User u : this.users){
			//message should not be received by the user sending it
			if(u != user){
				u.receive(msg);
			}
		}
	}
}
