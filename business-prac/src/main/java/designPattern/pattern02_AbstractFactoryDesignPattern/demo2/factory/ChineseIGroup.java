package designPattern.pattern02_AbstractFactoryDesignPattern.demo2.factory;

import designPattern.pattern01.FactoryDesignPattern.demo1.bean.ChineseTeacher;
import designPattern.pattern01.FactoryDesignPattern.demo1.bean.basic.ITeacher;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo2.bean.ChineseTutor;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo2.bean.basic.ITutor;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo2.factory.basic.IGroup;

public class ChineseIGroup implements IGroup {

    @Override
    public ITutor createTutor() {
        ChineseTutor chineseTutor = new ChineseTutor();
        chineseTutor.build();
        return chineseTutor;
    }

    @Override
    public ITeacher createTeacher() {
        ChineseTeacher chineseTeacher = new ChineseTeacher();
        chineseTeacher.build();
        return chineseTeacher;
    }
}
