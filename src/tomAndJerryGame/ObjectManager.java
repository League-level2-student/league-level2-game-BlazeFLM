package tomAndJerryGame;

import java.awt.Graphics;
import java.util.Random;

public class ObjectManager {
	Random ran = new Random();
	Mouse jerry;
	Cat tom = new Cat(400, 100, 70, 70);
	Cheese cheese = new Cheese(ran.nextInt(430) + 1, ran.nextInt(430) + 1, 25, 25, 0);
	
	int score;
	int health;
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
			cheese = new Cheese(ran.nextInt(430) + 1, ran.nextInt(430) + 1, 25, 25, 0);
		}
		if(jerry.collisionBox.intersects(tom.collisionBox)) {
			health -= 5;
			if(health == 0) {
				jerry.isActive = false;
			}
		}
	}
	
	public int getScore() {
		return score;
	}
}
