package designPattern.designPatterns14_TemplateMethodDesignPattern;

public class A3_GlassHouse extends A1_HouseTemplate {

	@Override
	public void buildWalls() {
		System.out.println("Building Glass Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with glass coating");
	}
}

