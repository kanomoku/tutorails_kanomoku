package designPattern.pattern01.FactoryDesignPattern.demo1;

import designPattern.pattern01.FactoryDesignPattern.demo1.factory.ChineseTeacherFactory;
import designPattern.pattern01.FactoryDesignPattern.demo1.factory.MathTeacherFactory;
import designPattern.pattern01.FactoryDesignPattern.demo1.factory.basic.TeacherFactory;
import designPattern.pattern01.FactoryDesignPattern.demo1.bean.ChineseTeacher;
import designPattern.pattern01.FactoryDesignPattern.demo1.bean.MathTeacher;

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
