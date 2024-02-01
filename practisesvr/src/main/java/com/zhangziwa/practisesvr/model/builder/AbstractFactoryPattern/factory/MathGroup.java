package com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.factory;

import com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.bean.ITutor;
import com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.bean.MathTutor;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ITeacher;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.MathTeacher;

public class MathGroup extends Group {

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
