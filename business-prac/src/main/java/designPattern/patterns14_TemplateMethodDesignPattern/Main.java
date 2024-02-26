package designPattern.patterns14_TemplateMethodDesignPattern;

import designPattern.patterns14_TemplateMethodDesignPattern.AbstractClass.HouseTemplate;
import designPattern.patterns14_TemplateMethodDesignPattern.ConcreteClasses.GlassHouse;
import designPattern.patterns14_TemplateMethodDesignPattern.ConcreteClasses.WoodenHouse;

public class Main {
    public static void main(String[] args) {
        HouseTemplate houseType;

        houseType = new WoodenHouse();
        houseType.buildHouse();

        System.out.println("************");

        houseType = new GlassHouse();
        houseType.buildHouse();
    }
}
