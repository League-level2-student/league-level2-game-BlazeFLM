package tomAndJerryGame;

import javax.swing.JFrame;

public class GameRunner {
	JFrame frame = new JFrame();
	GamePanel panel = new GamePanel();
	
	public static final int theSize = 500;
	
	GameRunner(){
		this.frame = new JFrame();
		this.panel = new GamePanel();
	}
	
	void setup() {
		frame.add(panel);
		frame.setSize(theSize,theSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		GameRunner newFrame = new GameRunner();
		newFrame.setup();
	}
}
