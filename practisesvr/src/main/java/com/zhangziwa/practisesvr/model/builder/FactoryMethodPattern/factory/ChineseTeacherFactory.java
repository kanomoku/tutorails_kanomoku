package com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.factory;

import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ChineseTeacher;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ITeacher;

public class ChineseTeacherFactory extends TeacherFactory {
    @Override
    protected ITeacher createTeacher() {
        return new ChineseTeacher();
    }
}
