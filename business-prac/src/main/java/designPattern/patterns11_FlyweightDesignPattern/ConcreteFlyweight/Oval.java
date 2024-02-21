package designPattern.patterns11_FlyweightDesignPattern.ConcreteFlyweight;

import designPattern.patterns11_FlyweightDesignPattern.IFlyweight.IShape;

import java.awt.*;

public class Oval implements IShape {

    //intrinsic property
    private final boolean fill;

    public Oval(boolean f) {
        this.fill = f;
        System.out.println("Creating Oval object with fill=" + f);
        //adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics circle, Color color, int x, int y, int width, int height) {
        circle.setColor(color);
        circle.drawOval(x, y, width, height);
        if (fill) {
            circle.fillOval(x, y, width, height);
        }
    }
}
