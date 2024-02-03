package designPattern.pattern02_AbstractFactoryDesignPattern.demo2.factory.basic;

import designPattern.pattern01.FactoryDesignPattern.demo1.bean.basic.ITeacher;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo2.bean.basic.ITutor;

public interface IGroup {
    ITutor createTutor();
    ITeacher createTeacher();
}
