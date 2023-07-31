package designPattern.designPatterns14_TemplateMethodDesignPattern;

public class A2_WoodenHouse extends A1_HouseTemplate {

	@Override
	public void buildWalls() {
		System.out.println("Building Wooden Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with Wood coating");
	}
}
