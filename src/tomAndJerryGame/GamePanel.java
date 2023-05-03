package tomAndJerryGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;

	Font titleFont = new Font("Arial", Font.PLAIN, 24);
	Font regularFont = new Font("Arial", Font.PLAIN, 14);
	Color beige = new Color(245,245,220);

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
	}

	void updateGameState() {
		
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
		g.drawRect(0, 0, 100, 75);
		g.setFont(regularFont);
		g.drawString("Score: ", 10, 10);
		g.setColor(new Color(255,255,255,150)); 
		g.drawRect(5, 5, GameRunner.theSize - 5, GameRunner.theSize - 5);
		
	}

	void drawEndState(Graphics g) {
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

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

	}
}
