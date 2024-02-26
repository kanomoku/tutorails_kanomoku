package designPattern.patterns14_TemplateMethodDesignPattern.ConcreteClasses;

import designPattern.patterns14_TemplateMethodDesignPattern.AbstractClass.HouseTemplate;

public class GlassHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with glass coating");
    }
}

