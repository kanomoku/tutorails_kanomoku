package designPattern.pattern02_AbstractFactoryDesignPattern.demo2.factory;

import designPattern.pattern01.FactoryDesignPattern.demo1.bean.MathTeacher;
import designPattern.pattern01.FactoryDesignPattern.demo1.bean.basic.ITeacher;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo2.bean.MathTutor;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo2.bean.basic.ITutor;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo2.factory.basic.IGroup;

public class MathIGroup implements IGroup {

    @Override
    public ITutor createTutor() {
        MathTutor mathTutor = new MathTutor();
        mathTutor.build();
        return mathTutor;
    }

    @Override
    public ITeacher createTeacher() {
        MathTeacher mathTeacher = new MathTeacher();
        mathTeacher.build();
        return mathTeacher;
    }
}
