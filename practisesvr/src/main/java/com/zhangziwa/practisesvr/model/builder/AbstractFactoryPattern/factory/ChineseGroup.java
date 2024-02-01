package com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.factory;

import com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.bean.ChineseTutor;
import com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.bean.ITutor;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ChineseTeacher;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ITeacher;

public class ChineseGroup extends Group {

    @Override
    public ITutor createTutor() {
        ChineseTutor chineseTutor = new ChineseTutor();
        chineseTutor.build();
        return chineseTutor;
    }

    @Override
    public ITeacher createTeacher() {
        ChineseTeacher chineseTeacher = new ChineseTeacher();
        chineseTeacher.build();
        return chineseTeacher;
    }
}
