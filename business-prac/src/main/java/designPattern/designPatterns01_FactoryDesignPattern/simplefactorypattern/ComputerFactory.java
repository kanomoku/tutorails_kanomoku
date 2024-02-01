package designPattern.designPatterns01_FactoryDesignPattern.simplefactorypattern;

import designPattern.designPatterns01_FactoryDesignPattern.simplefactorypattern.bean.basic.Computer;
import designPattern.designPatterns01_FactoryDesignPattern.simplefactorypattern.bean.PC;
import designPattern.designPatterns01_FactoryDesignPattern.simplefactorypattern.bean.Server;

public class ComputerFactory {

	public static Computer getComputer(String type, String ram, String hdd, String cpu) {

		if ("PC".equalsIgnoreCase(type))
			return new PC(ram, hdd, cpu);
		else if ("Server".equalsIgnoreCase(type))
			return new Server(ram, hdd, cpu);

		return null;
	}
}
