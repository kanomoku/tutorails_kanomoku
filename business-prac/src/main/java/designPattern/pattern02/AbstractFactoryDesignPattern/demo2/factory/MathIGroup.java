package designPattern.pattern02.AbstractFactoryDesignPattern.demo2.factory;

import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.bean.basic.ITutor;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.bean.MathTutor;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ITeacher;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.MathTeacher;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.factory.basic.IGroup;

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
