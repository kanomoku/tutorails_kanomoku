package designPattern.designPatterns01_FactoryDesignPattern;

public class A4_ComputerSimpleFactory {

	public static A1_Computer getComputer(String type, String ram, String hdd, String cpu) {

		if ("PC".equalsIgnoreCase(type))
			return new A2_PC(ram, hdd, cpu);
		else if ("Server".equalsIgnoreCase(type))
			return new A3_Server(ram, hdd, cpu);

		return null;
	}
}
