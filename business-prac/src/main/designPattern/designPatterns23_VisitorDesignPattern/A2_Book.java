package designPattern.designPatterns23_VisitorDesignPattern;

public class A2_Book implements A1_ItemElement {
	private int price;
	private String isbnNumber;
	public A2_Book(int cost, String isbn){
		this.price=cost;
		this.isbnNumber=isbn;
	}
	public int getPrice() {
		return price;
	}
	public String getIsbnNumber() {
		return isbnNumber;
	}

	@Override
	public int accept(A4_ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}

