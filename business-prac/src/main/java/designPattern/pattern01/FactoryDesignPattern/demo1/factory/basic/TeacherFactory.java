package designPattern.pattern01.FactoryDesignPattern.demo1.factory.basic;

import designPattern.pattern01.FactoryDesignPattern.demo1.bean.basic.ITeacher;

public abstract class TeacherFactory {
    public ITeacher create() {
        ITeacher teacher = createTeacher();
        teacher.build();
        return teacher;
    }
    protected abstract ITeacher createTeacher();
}
