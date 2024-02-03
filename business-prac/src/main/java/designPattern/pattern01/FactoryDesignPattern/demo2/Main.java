package designPattern.pattern01.FactoryDesignPattern.demo2;

import designPattern.pattern01.FactoryDesignPattern.demo2.factory.ServerFactory;
import designPattern.pattern01.FactoryDesignPattern.demo2.bean.basic.Computer;
import designPattern.pattern01.FactoryDesignPattern.demo2.factory.PCFactory;

public class Main {

    public static void main(String[] args) {
        PCFactory pcFactory = new PCFactory();
        Computer computer = pcFactory.createComputer("2 GB", "500 GB", "2.4 GHz");

        ServerFactory sbFactory = new ServerFactory();
        Computer server = sbFactory.createComputer("16 GB", "1 TB", "2.9 GHz");

        System.out.println("AbstractFactory PC Config::" + computer.toString());
        System.out.println("AbstractFactory Server Config::" + server.toString());
    }
}
