package com.zhangziwa.practisesvr.model.builder.AbstractFactoryPattern.bean;

public class ChineseTutor implements ITutor {

    @Override
    public void build() {
        System.out.println("Build ChineseTutor");
    }
}
