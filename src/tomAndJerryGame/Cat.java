package tomAndJerryGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Cat extends GameObject {
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	int xSpeed;
	int ySpeed;
	Random ran = new Random();

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

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
		if (needImage) {
			loadImage("Tom Sprite.png");
		}
	}

	void move() {
		super.update();
		x += xSpeed;
		System.out.println(xSpeed);
		y += ySpeed;
		System.out.println(ySpeed);
		if (x <= 0) {
			xSpeed *= -1;
			int randomY = ran.nextInt(1 - -1 + 1) - 1;
			if (randomY != 0) {
				ySpeed = 5;
			}
			ySpeed *= randomY;
		}
		if (x >= GameRunner.theSize - 50) {
			xSpeed *= -1;
			int randomY = ran.nextInt(1 - -1 + 1) - 1;
			if (randomY != 0) {
				ySpeed = 5;
			}
			ySpeed *= randomY;
		}
		if (y <= 0) {
			ySpeed *= -1;
			int randomX = ran.nextInt(1 - -1 + 1) - 1;
			if (randomX != 0) {
				xSpeed = 5;
			}
			xSpeed *= randomX;
		}
		if (y >= GameRunner.theSize - 50) {
			ySpeed *= -1;
			int randomX = ran.nextInt(1 - -1 + 1) - 1;
			if (randomX != 0) {
				xSpeed = 5;
			}
			xSpeed *= randomX;
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

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
