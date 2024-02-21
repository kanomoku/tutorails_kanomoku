package designPattern.patterns11_FlyweightDesignPattern;

import designPattern.patterns11_FlyweightDesignPattern.FlyweightFactory.ShapeFactory;
import designPattern.patterns11_FlyweightDesignPattern.FlyweightFactory.ShapeFactory.ShapeType;
import designPattern.patterns11_FlyweightDesignPattern.IFlyweight.IShape;

import javax.swing.*;
import java.awt.*;

public class DrawingClient extends JFrame {

    private static final long serialVersionUID = -1350200437285282550L;
    private final int WIDTH;
    private final int HEIGHT;

    private static final ShapeType[] shapes = {ShapeType.LINE, ShapeType.OVAL_FILL, ShapeType.OVAL_NOFILL};
    private static final Color[] colors = {Color.RED, Color.GREEN, Color.YELLOW};

    public DrawingClient(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        Container contentPane = getContentPane();

        JButton startButton = new JButton("Draw");
        final JPanel panel = new JPanel();

        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(event -> {
			Graphics graphics = panel.getGraphics();
			for (int i = 0; i < 20; ++i) {
				IShape shape = ShapeFactory.getShape(getRandomShape());
				shape.draw(graphics, getRandomColor(), getRandomX(), getRandomY(), getRandomWidth(), getRandomHeight());
			}
		});
    }

    private ShapeType getRandomShape() {
        return shapes[(int) (Math.random() * shapes.length)];
    }

    private Color getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private int getRandomX() {
        return (int) (Math.random() * WIDTH);
    }

    private int getRandomY() {
        return (int) (Math.random() * HEIGHT);
    }

    private int getRandomWidth() {
        return (int) (Math.random() * (WIDTH / 10));
    }

    private int getRandomHeight() {
        return (int) (Math.random() * (HEIGHT / 10));
    }
}

