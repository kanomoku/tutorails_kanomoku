package designPattern.designPatterns11_FlyweightDesignPattern;

import java.awt.Color;
import java.awt.Graphics;

public class A2_Line implements A1_Shape {

	public A2_Line(){
		System.out.println("Creating Line object");
		//adding time delay
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void draw(Graphics line, Color color, int x1, int y1, int x2, int y2) {
		line.setColor(color);
		line.drawLine(x1, y1, x2, y2);
	}
}
