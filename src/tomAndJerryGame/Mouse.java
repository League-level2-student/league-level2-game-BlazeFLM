package tomAndJerryGame;

import java.awt.Color;
import java.awt.Graphics;

public class Mouse extends GameObject {

	public Mouse(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
}
