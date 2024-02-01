package com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.bean;

public class MathTutor implements ITutor {

    @Override
    public void build() {
        System.out.println("Build MathTutor");
    }
}
