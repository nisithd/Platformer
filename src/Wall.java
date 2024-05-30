// DeSilva Nisith
// February 14, 2020
// ICS3U7 Ms. Strelkovska
// Final Project Wall/Platform Class

// import packages
import java.awt.*;
import java.awt.Rectangle;

public class Wall {
	// coordinates, width/height, rectangle for hitbox
	int x, y, width , height;
	Rectangle hitbox;
	
	public Wall(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitbox = new Rectangle(x, y, width, height);
	}
	
	// draw method
	public void myDraw(Graphics g) {
		g.setColor(Color.gray);
		g.drawRect(x, y, width, height);
		g.setColor(Color.lightGray);
		g.fillRect(x+1, y+1, width-1, height-1);
		
	}
	
}
