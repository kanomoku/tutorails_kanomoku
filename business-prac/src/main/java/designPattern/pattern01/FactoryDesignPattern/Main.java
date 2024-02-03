package designPattern.pattern01.FactoryDesignPattern;

import designPattern.pattern01.FactoryDesignPattern.factory.ChineseTeacherFactory;
import designPattern.pattern01.FactoryDesignPattern.factory.MathTeacherFactory;
import designPattern.pattern01.FactoryDesignPattern.factory.basic.TeacherFactory;
import designPattern.pattern01.FactoryDesignPattern.bean.ChineseTeacher;
import designPattern.pattern01.FactoryDesignPattern.bean.MathTeacher;

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
