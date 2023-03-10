package designPattern.designPatterns22_StrategyDesignPattern;

public class A7_ShoppingCartTest {

	public static void main(String[] args) {
		
		A6_ShoppingCart cart = new A6_ShoppingCart();

		A4_Item item1 = new A4_Item("1234", 10);
		A4_Item item2 = new A4_Item("5678", 40);

		cart.addItem(item1);
		cart.addItem(item2);

		// pay by paypal
		cart.setPaymentStrategy(new A3_PaypalStrategy("myemail@example.com", "mypwd"));
		cart.pay(cart.calculateTotal());
		
		// pay by credit card
		cart.pay(cart.calculateTotal());
		cart.setPaymentStrategy(new A2_CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786", "12/15"));
	}
}
