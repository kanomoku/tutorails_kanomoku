package com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.factory;

import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ITeacher;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.MathTeacher;

public class MathTeacherFactory extends TeacherFactory {
    @Override
    protected ITeacher createTeacher() {
        return new MathTeacher();
    }
}
