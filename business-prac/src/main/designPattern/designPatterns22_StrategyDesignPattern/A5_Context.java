package designPattern.designPatterns22_StrategyDesignPattern;

public class A5_Context {

	A1_PaymentStrategy paymentStrategy ;

	public A5_Context(A1_PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public void algorithm(int amount) {
		this.paymentStrategy.pay(amount);
	}
}