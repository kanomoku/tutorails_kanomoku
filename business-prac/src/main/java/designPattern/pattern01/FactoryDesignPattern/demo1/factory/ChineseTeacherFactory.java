package designPattern.pattern01.FactoryDesignPattern.demo1.factory;

import designPattern.pattern01.FactoryDesignPattern.demo1.bean.ChineseTeacher;
import designPattern.pattern01.FactoryDesignPattern.demo1.bean.basic.ITeacher;
import designPattern.pattern01.FactoryDesignPattern.demo1.factory.basic.TeacherFactory;

public class ChineseTeacherFactory extends TeacherFactory {
    @Override
    protected ITeacher createTeacher() {
        return new ChineseTeacher();
    }
}
