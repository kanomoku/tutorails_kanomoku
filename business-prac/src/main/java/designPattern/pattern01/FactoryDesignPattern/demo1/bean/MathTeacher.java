package designPattern.pattern01.FactoryDesignPattern.demo1.bean;

import designPattern.pattern01.FactoryDesignPattern.demo1.bean.basic.ITeacher;

public class MathTeacher implements ITeacher {

    @Override
    public void build() {
        System.out.println("Build MathTeacher");
    }
}
