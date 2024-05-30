// DeSilva Nisith
// February 14, 2020
// ICS3U7 Ms. Strelkovska
// Final Project Player Class

// import packages
import java.awt.*;
import java.awt.Rectangle;

public class Player {
	// GamePanel, coordinates, width/height, velocity, booleans for key inputs, rectangle for hitbox
	GamePanel panel;
	int x, y, width, height;
	double xSpeed, ySpeed;
	boolean leftKey, rightKey, upKey, downKey;
	Rectangle hitbox;
	
	// constructor
	public Player(int x, int y, int width, int height, GamePanel panel, double xSpeed, double ySpeed) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		
		leftKey = false;
		rightKey = false;
		upKey = false;
		downKey = false;
		
		hitbox = new Rectangle(x, y, width, height);
	}
	
	// draw method
	public void myDraw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}
	
	// key input response
	public void myMove() {
		if (leftKey && rightKey || !leftKey && !rightKey) {
			xSpeed*=0.8;
		}
		else if(leftKey && !rightKey) {
			xSpeed--;
		}
		else if(rightKey && !leftKey) {
			xSpeed++;
		}
		
		if (xSpeed > 0 && xSpeed < 0.75) {
			xSpeed = 0;
		}
		if (xSpeed < 0 && xSpeed > -0.75) {
			xSpeed = 0;
		}
		
		if (xSpeed > 10) {
			xSpeed = 10;
		}
		if (xSpeed < -10) {
			xSpeed = -10;
		}
		
		// only allow player to jump if they are on top of a platform (no mid air jumping)
		if (upKey) {
			hitbox.y++;
			
			for(Wall wall: panel.walls) {
				if(wall.hitbox.intersects(hitbox)) {
					if (panel.level == 5) {
						ySpeed = -12;
					}
					else {
						ySpeed = -17;
					}
				}
			}
			for (MovingPlatform mp: panel.mplatforms) {
				if(mp.hitbox.intersects(hitbox)) {
					ySpeed = -17;
				}
			}
			hitbox.y--;
		}
		
		ySpeed += 1;
		
		// Horizontal Collisions
		hitbox.x += xSpeed;
		for(Wall wall: panel.walls) {
			if(hitbox.intersects(wall.hitbox)) {
				hitbox.x -= xSpeed;
				while(!wall.hitbox.intersects(hitbox)) {
					hitbox.x += xSpeed / Math.abs(xSpeed);
				}
				hitbox.x -= xSpeed / Math.abs(xSpeed);
				xSpeed = 0;
				x = hitbox.x;
			}
		}
		
		for(MovingPlatform mp: panel.mplatforms) {
			if(hitbox.intersects(mp.hitbox)) {
				hitbox.x -= xSpeed;
				while(!mp.hitbox.intersects(hitbox)) {
					hitbox.x += xSpeed / Math.abs(xSpeed);
				}
				hitbox.x -= xSpeed / Math.abs(xSpeed);
				xSpeed = 0;
				x += mp.xSpeed;
				x = hitbox.x;
			}
		}
		
		for(Enemy enemy: panel.enemies) {
			if(hitbox.intersects(enemy.hitbox)) {
				hitbox.x -= xSpeed;
				while(!enemy.hitbox.intersects(hitbox)) {
					hitbox.x += xSpeed / Math.abs(xSpeed);
				}
				if (panel.level == 4) {
					x = 700;
					y = 50;
					xSpeed = 0;
					ySpeed = 0;
				}
				if (panel.level == 5) {
					x = 100;
					y = 50;
					xSpeed = 0;
					ySpeed = 0;
				}
			}
		}
		
		// Vertical Collisions
		hitbox.y += ySpeed;
		for(Wall wall: panel.walls) {
			if(hitbox.intersects(wall.hitbox)) {
				hitbox.y -= ySpeed;
				while(!wall.hitbox.intersects(hitbox)) {
					hitbox.y += ySpeed / Math.abs(ySpeed);
				}
				hitbox.y -= ySpeed / Math.abs(ySpeed);
				ySpeed = 0;
				y = hitbox.y;
			}
		}
		
		for(MovingPlatform mp: panel.mplatforms) {
			if(hitbox.intersects(mp.hitbox)) {
				hitbox.y -= ySpeed;
				while(!mp.hitbox.intersects(hitbox)) {
					hitbox.y += ySpeed / Math.abs(ySpeed);
				}
				hitbox.y -= ySpeed / Math.abs(ySpeed);
				ySpeed = 0;
				x += mp.xSpeed;
				y = hitbox.y;
			}
		}
		
		for(Enemy enemy: panel.enemies) {
			if(hitbox.intersects(enemy.hitbox)) {
				hitbox.y -= ySpeed;
				while(!enemy.hitbox.intersects(hitbox)) {
					hitbox.y += ySpeed / Math.abs(ySpeed);
				}
				if (panel.level == 4) {
					x = 700;
					y = 50;
					xSpeed = 0;
					ySpeed = 0;
				}
				if (panel.level == 5) {
					x = 100;
					y = 50;
					xSpeed = 0;
					ySpeed = 0;
				}
			}
		}
		
		// reset positions for each level if the player falls into the pit
		if (panel.level == 1 && y > 800) {
			x = 50;
			y = 400;
			xSpeed = 0;
			ySpeed = 0;
		}
		if (panel.level == 2 && y > 800) {
			x = 80;
			y = 50;
			xSpeed = 0;
			ySpeed = 0;
		}
		if (panel.level== 3 && y > 800) {
			x = 50;
			y = 400;
			xSpeed = 0;
			ySpeed = 0;
		}
		if (panel.level == 4 && y > 800) {
			x = 700;
			y = 50;
			xSpeed = 0;
			ySpeed = 0;
		}
		if (panel.level == 5 && y > 800) {
			x = 100;
			y = 50;
			xSpeed = 0;
			ySpeed = 0;
		}
		
		this.x += xSpeed;
		this.y += ySpeed;
		
		hitbox.x = x;
		hitbox.y = y;
	}
	
	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
