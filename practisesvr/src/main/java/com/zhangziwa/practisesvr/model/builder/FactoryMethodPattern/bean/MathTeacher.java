package com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean;

public class MathTeacher implements ITeacher {

    @Override
    public void build() {
        System.out.println("Build MathTeacher");
    }
}
