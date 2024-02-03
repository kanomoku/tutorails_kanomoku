package designPattern.pattern02_AbstractFactoryDesignPattern.demo2.bean;

import designPattern.pattern02_AbstractFactoryDesignPattern.demo2.bean.basic.ITutor;

public class ChineseTutor implements ITutor {

    @Override
    public void build() {
        System.out.println("Build ChineseTutor");
    }
}
