package designPattern.pattern02.AbstractFactoryDesignPattern.demo2;

import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.bean.ChineseTutor;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.bean.MathTutor;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.factory.ChineseIGroup;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.factory.basic.IGroup;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.factory.MathIGroup;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ChineseTeacher;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.MathTeacher;

public class Main {
    public static void main(String[] args) {
        IGroup chineseGroup = new ChineseIGroup();
        ChineseTeacher chineseTeacher = (ChineseTeacher) chineseGroup.createTeacher();
        System.out.println(chineseTeacher.getClass());
        ChineseTutor chineseTutor = (ChineseTutor) chineseGroup.createTutor();
        System.out.println(chineseTutor.getClass());

        IGroup mathGroup = new MathIGroup();
        MathTeacher mathTeacher = (MathTeacher) mathGroup.createTeacher();
        System.out.println(mathTeacher.getClass());

        MathTutor mathTutor = (MathTutor) mathGroup.createTutor();
        System.out.println(mathTutor.getClass());
    }
}
