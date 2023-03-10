package designPattern.designPatterns14_TemplateMethodDesignPattern;

public class A4_HousingClient {

	public static void main(String[] args) {
		A1_HouseTemplate houseType;

		houseType = new A2_WoodenHouse();
		// using template method
		houseType.buildHouse();
		System.out.println("************");

		houseType = new A3_GlassHouse();
		houseType.buildHouse();
	}
}
