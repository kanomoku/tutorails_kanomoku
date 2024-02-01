package com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern;

import com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.bean.ChineseTutor;
import com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.bean.MathTutor;
import com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.factory.ChineseGroup;
import com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.factory.Group;
import com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.factory.MathGroup;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ChineseTeacher;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.MathTeacher;

public class Main {
    public static void main(String[] args) {
        Group chineseGroup = new ChineseGroup();
        ChineseTeacher chineseTeacher = (ChineseTeacher) chineseGroup.createTeacher();
        System.out.println(chineseTeacher.getClass());
        ChineseTutor chineseTutor = (ChineseTutor) chineseGroup.createTutor();
        System.out.println(chineseTutor.getClass());

        Group mathGroup = new MathGroup();
        MathTeacher mathTeacher = (MathTeacher) mathGroup.createTeacher();
        System.out.println(mathTeacher.getClass());

        MathTutor mathTutor = (MathTutor) mathGroup.createTutor();
        System.out.println(mathTutor.getClass());
    }
}
