package designPattern.patterns11_FlyweightDesignPattern.IFlyweight;

import java.awt.*;

public interface IShape {
	public void draw(Graphics g, Color color, int x, int y, int width, int height);
}

