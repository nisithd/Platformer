// DeSilva Nisith
// February 14, 2020
// ICS3U7 Ms. Strelkovska
// Final Project Moving Platform Class

// import packages
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MovingPlatform{
	// hitbox, velocity, coordinates, width/height, bounds
	Rectangle hitbox;
	double xSpeed;
	int x, y, width, height, startingPoint, endingPoint;
	public MovingPlatform(int x, int y, int width, int height, int startingPoint, int endingPoint, int xSpeed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.endingPoint = endingPoint;
		this.startingPoint = startingPoint;
		
		this.xSpeed = xSpeed;
		
		hitbox = new Rectangle(x, y, width, height);
	}
	// draw method
	public void myDraw(Graphics g) {
		g.setColor(Color.gray);
		g.drawRect(x, y, width, height);
		g.setColor(Color.lightGray);
		g.fillRect(x+1, y+1, width-1, height-1);
	}
	// move method (similar to player but not dependent on key presses)
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
