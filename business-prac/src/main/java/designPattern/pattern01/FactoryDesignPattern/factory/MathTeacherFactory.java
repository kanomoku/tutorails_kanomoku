package designPattern.pattern01.FactoryDesignPattern.factory;

import designPattern.pattern01.FactoryDesignPattern.bean.basic.ITeacher;
import designPattern.pattern01.FactoryDesignPattern.bean.MathTeacher;
import designPattern.pattern01.FactoryDesignPattern.factory.basic.TeacherFactory;

public class MathTeacherFactory extends TeacherFactory {
    @Override
    protected ITeacher createTeacher() {
        return new MathTeacher();
    }
}
