package designPattern.designPatterns23_VisitorDesignPattern;

public class A3_Fruit implements A1_ItemElement {
	
	private int pricePerKg;
	private int weight;
	private String name;
	
	public A3_Fruit(int priceKg, int wt, String nm){
		this.pricePerKg=priceKg;
		this.weight=wt;
		this.name = nm;
	}
	public int getPricePerKg() {
		return pricePerKg;
	}
	public int getWeight() {
		return weight;
	}
	public String getName(){
		return this.name;
	}
	
	@Override
	public int accept(A4_ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}

