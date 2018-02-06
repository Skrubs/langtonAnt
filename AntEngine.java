package application;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class AntEngine extends AnimationTimer {

	private Ant ant = new Ant((Main.WINDOW_WIDTH / 2) + 5, (Main.WINDOW_HEIGHT / 2));
	private Cell[][] cells = new Cell[40][40];
	private long startTime = System.nanoTime();
	private double timer = 0;
	private double lastTime = 0;
	private double time;
	private Cell tempCell = new Cell(0,0);

	public AntEngine() {

	}

	public void init() {

		for (int x = 0; x < 40; x++) {
			for (int y = 0; y < 40; y++) {
				cells[x][y] = new Cell(x * 32, y * 32);
			}
		}

	}

	public void handle(long now) {

		timer = (now - startTime) / 1000000000;

		Main.getGC().setFill(Color.WHITE);
		Main.getGC().fillRect(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);

		for (Cell[] cell : cells) {
			for (Cell c : cell) {

				if (!tempCell.equals(c)) {
					if (c.getState() == 0) {
						if (c.collision(ant)) {

							ant.turnRight();

							c.setState(1);
							
							if(ant.getPosX() <= Main.WINDOW_WIDTH && ant.getPosX() >= 0 &&
									ant.getPosY() >= 0 && ant.getPosY() <= Main.WINDOW_HEIGHT) {
							ant.move();
							}

							tempCell = c;
						}
					} else if (c.getState() == 1) {
						if (c.collision(ant)) {

							ant.turnLeft();

							c.setState(0);
							 
							if(ant.getPosX() <= Main.WINDOW_WIDTH && ant.getPosX() >= 0 &&
									ant.getPosY() >= 0 && ant.getPosY() <= Main.WINDOW_HEIGHT) {
							ant.move();
							}
							tempCell = c;

						}
					}
					
				}else if(tempCell.equals(c)) ant.move();

				if (c.getState() == 1) {
					Main.getGC().setFill(Color.BLACK);
				} else if (c.getState() == 0) {
					Main.getGC().setFill(Color.WHITE);
				}

				Main.getGC().fillRect(c.getX(), c.getY(), c.getWidth(), c.getHeight());
				Main.getGC().strokeRect(c.getX(), c.getY(), c.getWidth(), c.getHeight());

			}
		}
		
		

		Main.getGC().drawImage(ant.getAnt(), ant.getPosX(), ant.getPosY());

	}

}
