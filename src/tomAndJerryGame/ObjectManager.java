package tomAndJerryGame;

import java.awt.Graphics;
import java.util.Random;

public class ObjectManager {
	Random ran = new Random();
	Mouse jerry;
	Cat tom = new Cat(400, 100, 70, 70);
	Cheese cheese = new Cheese(ran.nextInt(430) + 1, ran.nextInt(430) + 1, 25, 25, 0);
	
	int score = 0;
	public ObjectManager(Mouse jerry) {
		this.jerry = jerry;
	}
	
	void draw(Graphics g) {
		jerry.draw(g);
		tom.draw(g);
		cheese.draw(g);
	}
	void update() {
		jerry.move();
		tom.move();
		if(jerry.isActive == true) {
			checkCollision();
		}
	}
	void checkCollision() {
		if(jerry.collisionBox.intersects(cheese.collisionBox)) {
			score++;
			cheese.x = ran.nextInt(430) + 1;
			cheese.y = ran.nextInt(430) + 1;
		}
		
	}
	
	//public int getScore() {
	//	return score;
	//}
}
