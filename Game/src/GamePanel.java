// DeSilva Nisith
// February 14, 2020
// ICS3U7 Ms. Strelkovska
// Final Project Game Panel Class

// import packages
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	// set timer, level counter, background img, arraylists that contain objects
	ImageIcon bg2;
	Timer timer;
	Player player;
	static int level;
	ArrayList<Wall> walls = new ArrayList<>();
	ArrayList<MovingPlatform> mplatforms = new ArrayList<>();
	ArrayList<Enemy> enemies = new ArrayList<>();
	ArrayList<Enemy> toRemove = new ArrayList<Enemy>();
	
	// constructor
	public GamePanel() {
		
		bg2 = new ImageIcon("menuBackground.png");
		
		player = new Player(50, 400, 40, 60, this, 0, 0);
		
		level = 1;
		
		makeWalls();
		
		timer = new Timer(17, this);
		
		addKeyListener(this);
		this.setFocusable(true);
	}
	
	// add different arrangements of platforms each level
	public void makeWalls() {
		if (level == 1) {
			walls.add(new Wall(0, 700, 350, 80));
			walls.add(new Wall(600, 250, 200, 550));
			walls.add(new Wall(425, 580, 100, 50));
			walls.add(new Wall(-50, 0, 50, 800));
			walls.add(new Wall(0, 100, 150, 50));
			walls.add(new Wall(200, 460, 100, 50));
			walls.add(new Wall(425, 340, 100, 50));
			walls.add(new Wall(200, 220, 100, 50));
		}
		if (level == 2) {
			player = new Player(80, 50, 40, 60, this, 0, 0);
			walls.add(new Wall(-1, 0, 1, 800));
			walls.add(new Wall(50, 200, 100, 650));
			walls.add(new Wall(700, 650, 100, 150));
			walls.add(new Wall(500, -1, 300, 300));
			mplatforms.add(new MovingPlatform(200, 400, 100, 50, 200, 450, 4));
			mplatforms.add(new MovingPlatform(300, 650, 100, 50, 200, 600, 4));
		}
		if (level == 3) {
			player = new Player(50, 400, 40, 60, this, 0, 0);
			walls.add(new Wall(0, 600, 200, 210));
			walls.add(new Wall(-1, 0, 1, 800));
			walls.add(new Wall(600, 475, 150, 50));
			walls.add(new Wall(800, 200, 50, 600));
			walls.add(new Wall(250, 350, 200, 50));
			walls.add(new Wall(0, 225, 150, 50));
			walls.add(new Wall(650, 125, 150, 150));
			mplatforms.add(new MovingPlatform(300, 600, 100, 50, 300, 700, 4));
			mplatforms.add(new MovingPlatform(200, 125, 150, 50, 200, 550, 4));
		}
		if (level == 4) {
			player = new Player(700, 50, 40, 60, this, 0, 0);
			walls.add(new Wall(250, 200, 560, 50));
			walls.add(new Wall(-1, 0, 1, 800));
			walls.add(new Wall(800, 0, 1, 500));
			walls.add(new Wall(550, 650, 260, 160));
			walls.add(new Wall(650, 450, 160, 50));
			walls.add(new Wall(300, 500, 150, 50));
			mplatforms.add(new MovingPlatform(100, 325, 150, 50, 100, 600, 4));
			mplatforms.add(new MovingPlatform(300, 650, 150, 50, 100, 500, 4));
			enemies.add(new Enemy(300, 450, 30, 50, 300, 450));
		}
		if (level == 5) {
			player = new Player(100, 50, 20, 30, this, 0, 0);
			walls.add(new Wall(-10, 100, 610, 25));
			walls.add(new Wall(-1, 0, 1, 800));
			walls.add(new Wall(800, 0, 1, 600));
			walls.add(new Wall(200, 300, 610, 25));
			walls.add(new Wall(300, 240, 75, 25));
			walls.add(new Wall(40, 425, 25, 385));
			walls.add(new Wall(175, 485, 25, 310));
			walls.add(new Wall(325, 475, 325, 25));
			walls.add(new Wall(325, 500, 25, 310));
			walls.add(new Wall(500, 600, 310, 25));
			walls.add(new Wall(585, 570, 75, 15));
			walls.add(new Wall(385, 650, 25, 210));
			walls.add(new Wall(450, 700, 25, 85));
			walls.add(new Wall(725, 700, 85, 110));
			mplatforms.add(new MovingPlatform(675, 200, 75, 25, 500, 750, 3));
			mplatforms.add(new MovingPlatform(50, 175, 75, 25, 50, 250, 3));
			mplatforms.add(new MovingPlatform(525, 700, 75, 15, 525, 700, 2));
			enemies.add(new Enemy(250, 70, 20, 30, 250, 500));
			enemies.add(new Enemy(300, 220, 10, 20, 300, 375));
			enemies.add(new Enemy(585, 550, 10, 20, 585, 660));
			enemies.add(new Enemy(550, 299, 260, 10));
			enemies.add(new Enemy(250, 299, 175, 10));
			enemies.add(new Enemy(550, 599, 150, 10));
		}
		if (level == 6) {
			player = new Player(0, 0, 0, 0, this, 0, 0);
		}
	}
	
	// paint method
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		this.setBackground(Color.lightGray);
		g.drawImage(bg2.getImage(), 0, 0, null);
		if (level == 1) {
			g.setFont(new Font("MonoSpaced", Font.BOLD, 24));
			g.drawString("Welcome to Level 1!", 250, 100);
			g.drawString("(Use arrow keys to move)", 225, 150);
			g.setFont(new Font("MonoSpaced", Font.BOLD, 18));
			g.drawString("Exit here", 650, 200);
			g.drawString("-->", 700, 225);
		}
		if (level == 2) {
			g.setFont(new Font("MonoSpaced", Font.BOLD, 24));
			g.drawString("Level 2", 250, 100);
			g.drawString("(Watch out for", 225, 200);
			g.drawString("moving platforms)", 225, 235);
			g.setFont(new Font("MonoSpaced", Font.BOLD, 18));
			g.drawString("Exit here", 675, 550);
			g.drawString("-->", 725, 600);
		}
		if (level == 3) {
			g.setFont(new Font("MonoSpaced", Font.BOLD, 24));
			g.drawString("Level 3", 325, 75);
			g.setFont(new Font("MonoSpaced", Font.BOLD, 18));
			g.drawString("Exit here", 650, 75);
			g.drawString("-->", 700, 100);
		}
		if (level == 4) {
			g.setFont(new Font("MonoSpaced", Font.BOLD, 24));
			g.drawString("Level 4", 325, 75);
			g.drawString("(Don't touch enemies)", 225, 150);
			g.setFont(new Font("MonoSpaced", Font.BOLD, 18));
			g.drawString("Exit here", 650, 600);
			g.drawString("-->", 700, 625);
		}
		if (level == 5) {
			g.setFont(new Font("MonoSpaced", Font.BOLD, 24));
			g.drawString("Level 5", 325, 50);
			g.drawString("(Avoid enemies and lava)", 225, 400);
			g.setFont(new Font("MonoSpaced", Font.BOLD, 18));
			g.drawString("Exit here", 675, 660);
			g.drawString("-->", 725, 685);
		}
		if (level == 6) {
			g.setFont(new Font("MonoSpaced", Font.BOLD, 36));
			g.drawString("Thanks for playing!", 200, 350);
		}
		
		player.myDraw(g);
		
		for (Wall wall: walls) {
			wall.myDraw(g);
		}
		for (MovingPlatform mp: mplatforms) {
			mp.myDraw(g);
		}
		for (Enemy enemy: enemies) {
			enemy.myDraw(g);
		}
		if (level == 5) {
			g.setColor(Color.lightGray);
			g.drawLine(326, 500, 349, 500);
		}
		
		repaint();
	}
	
	// key inputs for player
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.leftKey = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.rightKey = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.upKey = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.downKey = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.leftKey = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.rightKey = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.upKey = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.downKey = false;
		}
	}
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			player.myMove();
			for (MovingPlatform mp: mplatforms) {
				mp.myMove();
			}
			for (Enemy enemy: enemies) {
				enemy.myMove();
			}
		}
		// once the player reaches the right most side (exit) they move on to the next level
		// all arraylists are reset and objects are re-added
		if (player.x > 780) {
			timer.stop();
			level++;
			walls.clear();
			mplatforms.clear();
			enemies.clear();
			makeWalls();
			timer.restart();
		}
		repaint();
	}
}
