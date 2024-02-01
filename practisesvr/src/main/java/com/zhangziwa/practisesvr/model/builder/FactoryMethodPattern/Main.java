package com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern;

import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ChineseTeacher;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.MathTeacher;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.factory.ChineseTeacherFactory;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.factory.MathTeacherFactory;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.factory.TeacherFactory;

public class Main {
    public static void main(String[] args) {
        TeacherFactory chineseTeacherFactory = new ChineseTeacherFactory();
        ChineseTeacher iTeacher = (ChineseTeacher) chineseTeacherFactory.create();
        System.out.println(iTeacher.getClass());

        TeacherFactory mathTeacherFactory = new MathTeacherFactory();
        MathTeacher iTeacher1 = (MathTeacher) mathTeacherFactory.create();
        System.out.println(iTeacher1.getClass());
    }
}
