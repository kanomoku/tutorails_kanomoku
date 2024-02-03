package designPattern.pattern01.FactoryDesignPattern.demo2.factory;

import designPattern.pattern01.FactoryDesignPattern.demo2.bean.basic.Computer;
import designPattern.pattern01.FactoryDesignPattern.demo2.bean.Server;

public class ServerFactory implements IComputerFactory {


	@Override
	public Computer createComputer(String ram, String hdd, String cpu) {
		return new Server(ram,hdd,cpu);
	}

}

