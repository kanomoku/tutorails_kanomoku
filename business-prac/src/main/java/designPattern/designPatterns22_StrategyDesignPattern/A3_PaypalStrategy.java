package designPattern.designPatterns22_StrategyDesignPattern;

public class A3_PaypalStrategy implements A1_PaymentStrategy {

	private String emailId;
	private String password;

	public A3_PaypalStrategy(String email, String pwd) {
		this.emailId = email;
		this.password = pwd;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using Paypal.");
	}
}