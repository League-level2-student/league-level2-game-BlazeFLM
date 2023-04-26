package tomAndJerryGame;

import javax.swing.JFrame;

public class TomAndJerryGameRunner {
	JFrame frame = new JFrame();
	GamePanel panel = new GamePanel();
	
	public static final int frameSize = 500;
	
	TomAndJerryGameRunner(){
		this.frame = new JFrame();
		this.panel = new GamePanel();
	}
	
	
	void setup() {
		frame.add(panel);
		frame.setSize(frameSize,frameSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		TomAndJerryGameRunner newFrame = new TomAndJerryGameRunner();
		newFrame.setup();
	}
}
