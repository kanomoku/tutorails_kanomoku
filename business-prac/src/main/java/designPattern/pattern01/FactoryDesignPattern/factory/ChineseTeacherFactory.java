package designPattern.pattern01.FactoryDesignPattern.factory;

import designPattern.pattern01.FactoryDesignPattern.bean.ChineseTeacher;
import designPattern.pattern01.FactoryDesignPattern.bean.basic.ITeacher;
import designPattern.pattern01.FactoryDesignPattern.factory.basic.TeacherFactory;

public class ChineseTeacherFactory extends TeacherFactory {
    @Override
    protected ITeacher createTeacher() {
        return new ChineseTeacher();
    }
}
