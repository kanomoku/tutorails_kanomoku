package designPattern.designPatterns22_StrategyDesignPattern;

public class A4_Item {

	private String upcCode;
	private int price;

	public A4_Item(String upc, int cost) {
		this.upcCode = upc;
		this.price = cost;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public int getPrice() {
		return price;
	}

}
