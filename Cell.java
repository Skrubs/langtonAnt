package application;

import javafx.geometry.Rectangle2D;

public class Cell {
	
	private int x;
	private int y;
	private int height;
	private int width;
	private int state;
	private int centerX = (x + (width/2));
	private int centerY = (y + (height/2));
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 32;
		this.height = 32;
		state = 0;
	}
	
	public Rectangle2D boundary() {
		return new Rectangle2D(x+5, y+5, width-10, height-10);
	}
	
	public boolean collision(Ant a) {
		return this.boundary().intersects(a.getBoundary());
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		if(state == 0 || state == 1) {
			this.state = state;
		}else {
			state = 0;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getCenterX() {
		return centerX;
	}
	
	public int getCenterY() {
		return centerY;
	}
	
	

}
