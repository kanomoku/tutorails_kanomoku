package designPattern.pattern01.FactoryDesignPattern.bean;

import designPattern.pattern01.FactoryDesignPattern.bean.basic.ITeacher;

public class ChineseTeacher implements ITeacher {

    @Override
    public void build() {
        System.out.println("Build ChineseTeacher");

    }
}
