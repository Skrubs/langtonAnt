package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class Ant {
	
	
	private double posX;
	private double posY;
	private double width;
	private double height;
	private double centerX = (posX + (width/2));
	private double centerY = (posY +(height/2));
	private Direction dir = Direction.up;
	private Image antImage = new Image("Ant.png");
	
	public Ant(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
		width = 16;
		height = 16;
	}
	
	public Direction getDir() {
		return dir;
	}
	
	public void turnRight() {
		if(dir == Direction.up) {
			dir = Direction.right;
		}else if(dir == Direction.right) {
			dir = Direction.down;
		}else if(dir == Direction.down) {
			dir = Direction.left;
		}else if(dir == Direction.left) {
			dir = Direction.up;
		}
	}
	
	public void turnLeft() {
		if(dir == Direction.up) {
			dir = Direction.left;
		}else if(dir == Direction.left) {
			dir = Direction.down;
		}else if(dir == Direction.down) {
			dir = Direction.right;
		}else if(dir == Direction.right) {
			dir = Direction.up;
		}
	}
	
	public Rectangle2D getBoundary() {
		return new Rectangle2D(posX+5, posY+5, width-10, height-10);
	}
	
	public void move() {
		
		if(this.posX > Main.WINDOW_WIDTH) this.posX = Main.WINDOW_WIDTH;
		if(this.posX < 0) this.posX = 0;
		if(this.posY > Main.WINDOW_HEIGHT) this.posY = Main.WINDOW_HEIGHT;
		if(this.posY < 0) this.posY = 0;
		if(dir == Direction.up) {
			posY--;
		}else if(dir == Direction.down) {
			posY++;
		}else if(dir == Direction.right){
			posX++;
		}else if(dir == Direction.left) {
			posX--;
		}else {
			dir = Direction.stop;
		}
			
		
	}
	
	public void moveX() {
		posX++;
	}
	
	public void moveY() {
		posY++;
	}
	
	public Image getAnt() {
		return antImage;
	}
	
	public double getPosX() {
		return posX;
	}
	
	public double getPosY() {
		return posY;
	}
}
