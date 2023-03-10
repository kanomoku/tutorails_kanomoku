package designPattern.designPatterns03_BuilderDesignPattern;

public class A1_Computer_TestBuilderPattern {

	public static void main(String[] args) {
		//Using builder to get the object in a single line of code and 
		//without any inconsistent state or arguments management issues		
		A1_Computer comp = new A1_Computer.ComputerBuilder("500 GB", "2 GB")
									.setBluetoothEnabled(true)
									.setGraphicsCardEnabled(true)
									.build();
		System.out.println(comp);
	}

}
