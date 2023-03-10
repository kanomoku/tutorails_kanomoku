package designPattern.designPatterns22_StrategyDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class A6_ShoppingCart {

	List<A4_Item> items;
	A5_Context context;

	public A6_ShoppingCart() {
		this.items = new ArrayList<A4_Item>();
	}

	public void addItem(A4_Item item) {
		this.items.add(item);
	}

	public void removeItem(A4_Item item) {
		this.items.remove(item);
	}

	public int calculateTotal() {
		int sum = 0;
		for (A4_Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}

	public void setPaymentStrategy(A1_PaymentStrategy paymentMethod) {
		context = new A5_Context(paymentMethod);
	}

	public void pay(int amount) {
		context.algorithm(amount);
	}
}