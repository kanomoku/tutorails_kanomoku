package designPattern.pattern01.simplefactorypattern;

import designPattern.pattern01.simplefactorypattern.bean.Server;
import designPattern.pattern01.simplefactorypattern.bean.basic.Computer;
import designPattern.pattern01.simplefactorypattern.bean.PC;

public class ComputerFactory {

	public static Computer getComputer(String type, String ram, String hdd, String cpu) {

		if ("PC".equalsIgnoreCase(type))
			return new PC(ram, hdd, cpu);
		else if ("Server".equalsIgnoreCase(type))
			return new Server(ram, hdd, cpu);

		return null;
	}
}
