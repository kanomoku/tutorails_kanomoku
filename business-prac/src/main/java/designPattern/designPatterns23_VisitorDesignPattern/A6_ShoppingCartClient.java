package designPattern.designPatterns23_VisitorDesignPattern;

public class A6_ShoppingCartClient {

	public static void main(String[] args) {
		A1_ItemElement[] items = new A1_ItemElement[] { new A2_Book(20, "1234"), new A2_Book(100, "5678"),
				new A3_Fruit(10, 2, "Banana"), new A3_Fruit(5, 5, "Apple") };

		A4_ShoppingCartVisitor visitor = new A5_ShoppingCartVisitorImpl();
		// calculate Price
		int sum = 0;
		for (A1_ItemElement item : items) {
			sum = sum + item.accept(visitor);
		}
		System.out.println("Total Cost = " + sum);
	}
}
