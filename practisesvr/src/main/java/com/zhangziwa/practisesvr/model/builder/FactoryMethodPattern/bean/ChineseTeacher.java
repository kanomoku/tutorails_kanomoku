package com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean;

public class ChineseTeacher implements ITeacher {

    @Override
    public void build() {
        System.out.println("Build ChineseTeacher");
    }
}
