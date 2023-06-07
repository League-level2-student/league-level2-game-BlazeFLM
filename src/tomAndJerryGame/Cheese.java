package tomAndJerryGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Cheese extends GameObject {
	Random ran = new Random();

	public Cheese(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, 0);
		// TODO Auto-generated constructor stub
	}

	void update() {
	}

	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
	}
}
