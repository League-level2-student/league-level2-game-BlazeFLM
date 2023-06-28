package tomAndJerryGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Cheese extends GameObject {
	Random ran = new Random();
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public Cheese(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, 0);
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("Cheese Sprite.png");
		}
	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.YELLOW);
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
