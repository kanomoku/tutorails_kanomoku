package designPattern.designPatterns02_AbstractFactoryDesignPattern;

public class A8_TestDesignPatterns {

	public static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		A1_Computer pc = A7_ComputerFactory.getComputer(new A5_PCFactory("2 GB", "500 GB", "2.4 GHz"));
		A1_Computer server = A7_ComputerFactory.getComputer(new A6_ServerFactory("16 GB", "1 TB", "2.9 GHz"));
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::" + server);
	}
}
