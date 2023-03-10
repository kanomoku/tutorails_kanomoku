package designPattern.designPatterns11_FlyweightDesignPattern;

import java.awt.Color;
import java.awt.Graphics;

public class A3_Oval implements A1_Shape {
	
	//intrinsic property
	private boolean fill;
	
	public A3_Oval(boolean f){
		this.fill=f;
		System.out.println("Creating Oval object with fill="+f);
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
		if(fill){
			circle.fillOval(x, y, width, height);
		}
	}
}
