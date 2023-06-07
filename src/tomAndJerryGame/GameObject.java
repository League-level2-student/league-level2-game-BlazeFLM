package tomAndJerryGame;
import java.awt.Rectangle;
public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;
	Rectangle collisionBox;
	public GameObject(int x, int y, int width, int height, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	void update() {
	}
}
