package tomAndJerryGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Mouse extends GameObject {
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public Mouse(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("Jerry Sprite - Left.png");
		}
	}

	public void move() {
		super.update();
		if (up && y > 0) {
			y -= speed;
		}
		if (down && y < GameRunner.theSize - 85) {
			y += speed;
		}
		if (left && x > 0) {
			x -= speed;
		}
		if (right && x < GameRunner.theSize - 50) {
			x += speed;
		}
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.ORANGE);
			g.fillRect(x, y, width, height);
		}
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
