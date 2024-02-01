package com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.factory;

import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ITeacher;

public abstract class TeacherFactory {
    public ITeacher create() {
        ITeacher teacher = createTeacher();
        teacher.build();
        return teacher;
    }
    protected abstract ITeacher createTeacher();
}
