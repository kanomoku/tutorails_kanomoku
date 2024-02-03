package designPattern.pattern01.FactoryDesignPattern.demo2.factory;

import designPattern.pattern01.FactoryDesignPattern.demo2.bean.basic.Computer;

public interface IComputerFactory {

	Computer createComputer(String ram, String hdd, String cpu);

}


