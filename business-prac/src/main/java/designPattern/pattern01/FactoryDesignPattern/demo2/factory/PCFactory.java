package designPattern.pattern01.FactoryDesignPattern.demo2.factory;

import designPattern.pattern01.FactoryDesignPattern.demo2.bean.PC;
import designPattern.pattern01.FactoryDesignPattern.demo2.bean.basic.Computer;

public class PCFactory implements IComputerFactory {

	@Override
	public Computer createComputer(String ram, String hdd, String cpu) {
		return new PC(ram,hdd,cpu);
	}

}

