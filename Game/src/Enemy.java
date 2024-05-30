// DeSilva Nisith
// February 14, 2020
// ICS3U7 Ms. Strelkovska
// Final Project Enemy Class

// import packages
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy{
	// essentially the same variables as moving platform
	Rectangle hitbox;
	double xSpeed;
	int x, y, width, height, startingPoint, endingPoint;
	public Enemy(int x, int y, int width, int height, int startingPoint, int endingPoint) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.endingPoint = endingPoint;
		this.startingPoint = startingPoint;
		
		xSpeed = 2;
		
		hitbox = new Rectangle(x, y, width, height);
	}
	// second constructor for enemy that doesn't move (used for lava)
	public Enemy(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		xSpeed = 0;
		
		hitbox = new Rectangle(x, y, width, height);
	}
	// draw method
	public void myDraw(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.drawRect(x, y, width, height);
		g.setColor(Color.red);
		g.fillRect(x+1, y+1, width-1, height-1);
	}
	// exact same move method as moving platform
	public void myMove() {
		this.x += xSpeed;
		if((this.x + this.width) > this.endingPoint) {
			xSpeed *= -1;
		}
		else if (this.x < this.startingPoint){
			this.xSpeed *= -1;
		}
		hitbox.x = x;
		hitbox.y = y;
	}
}
