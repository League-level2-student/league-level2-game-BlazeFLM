package tomAndJerryGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.Customizer;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Timer frameDraw;
	Font titleFont = new Font("Arial", Font.PLAIN, 24);
	Font regularFont = new Font("Arial", Font.PLAIN, 14);
	Font deathFont = new Font("Serif", Font.BOLD, 50);
	Color beige = new Color(245, 245, 220);
	Random ran = new Random();

	Mouse jerry = new Mouse(100, 250, 50, 50, 5);
	ObjectManager karen = new ObjectManager(jerry);
	
	public GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {
		karen.score = 0;
		karen.health = 100;
	}

	void updateGameState() {
		karen.update();
		if (jerry.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(beige);
		g.fillRect(0, 0, GameRunner.theSize, GameRunner.theSize);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString("Tom and Jerry's Cheese Chase!", 75, 100);
		g.setFont(regularFont);
		g.drawString("Move your character with the arrows and collect cheese! Dodge Jerry!", 15, 200);
		g.drawString("Press ENTER to start", 175, 300);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, GameRunner.theSize, GameRunner.theSize);
		g.setColor(Color.black);
		g.setFont(regularFont);
		g.drawString("Score: " + karen.score, 5, 30);
		g.drawString("Health: "  + karen.health, 5, 60);
		g.setColor(new Color(255, 255, 255, 150));
		g.setColor(Color.black);
		((Graphics2D) g).setStroke(new BasicStroke(5));
		g.drawRect(0, 0, GameRunner.theSize, GameRunner.theSize);
		karen.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, GameRunner.theSize, GameRunner.theSize);
		g.setColor(Color.red.darker());
		g.setFont(deathFont);
		g.drawString("YOU DIED", 120, 100);
		g.setColor(Color.red.brighter());
		g.setFont(regularFont);
		g.drawString("Tom caught you. You had " + karen.getScore() + " cheese banked", 100, 200);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		jerry.up = false;
		jerry.down = false;
		jerry.left = false;
		jerry.right = false;
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (currentState == GAME) {
			if (arg0.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UP");
				jerry.up = true;
			}

			if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
				jerry.down = true;

			}
			if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
				jerry.left = true;

			}
			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
				jerry.right = true;

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
	}
}
