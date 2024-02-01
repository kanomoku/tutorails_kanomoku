package com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.factory;

import com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.bean.ITutor;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ITeacher;

public abstract class Group {
    public abstract ITutor createTutor();

    public abstract ITeacher createTeacher();
}
