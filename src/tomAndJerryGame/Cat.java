package tomAndJerryGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Cat extends GameObject {
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	int xSpeed;
	int ySpeed;
	Random ran = new Random();

	public Cat(int x, int y, int width, int height) {
		super(x, y, width, height, 0);
		// TODO Auto-generated constructor stub
		xSpeed = ran.nextInt(10) + 1;
		ySpeed = ran.nextInt(10) + 1;
		if (ran.nextBoolean()) {
			xSpeed *= -1;
		}
		if (ran.nextBoolean()) {
			ySpeed *= -1;
		}
	}

	void move() {
		x += xSpeed;
		y += ySpeed;
		if (x <= 0) {
			xSpeed *= -1;
			xSpeed *= ran.nextInt(3) - 1;
		}
		if (x >= GameRunner.theSize - 50) {
			xSpeed *= -1;
			xSpeed *= ran.nextInt(3) - 1;
		}
		if (y <= 0) {
			ySpeed *= -1;
			ySpeed *= ran.nextInt(3) - 1;
		}
		if (y >= GameRunner.theSize - 50) {
			ySpeed *= -1;
			ySpeed *= ran.nextInt(3) - 1;
		}
		if (xSpeed > 10) {
			xSpeed -= 6;
		}
		if (ySpeed > 10) {
			ySpeed -= 6;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
	}
}
