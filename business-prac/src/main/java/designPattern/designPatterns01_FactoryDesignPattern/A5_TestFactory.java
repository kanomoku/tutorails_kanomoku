package designPattern.designPatterns01_FactoryDesignPattern;

public class A5_TestFactory {

	public static void main(String[] args) {
		A1_Computer pc = A4_ComputerSimpleFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
		A1_Computer server = A4_ComputerSimpleFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
		System.out.println("Factory PC Config::"+pc);
		System.out.println("Factory Server Config::"+server);
	}

}

