package snakegame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Snake{
	
	private final int[] x = new int[Board.allDots];
	private final int[] y = new int[Board.allDots];
	
	private boolean leftDir = false;
	private boolean rightDir = true;
	private boolean upDir = false;
	private boolean downDir = false;
	
	private int dots;
	
	private Image ball;
	private Image head;
	
	public Snake() {
		initSnake();
	}
	
	public boolean getLeftDir() {
		return this.leftDir;
	}
	
	public boolean getRightDir() {
		return this.rightDir;
	}
	
	public boolean getUpDir() {
		return this.upDir;
	}
	
	public boolean getDownDir() {
		return this.downDir;
	}
	
	public void setLeftDir(boolean left) {
		this.leftDir = left;
	}
	
	public void setRightDir(boolean right) {
		this.rightDir = right;
	}
	
	public void setUpDir(boolean up) {
		this.upDir = up;
	}
	
	public void setDownDir(boolean down) {
		this.downDir = down;
	}
	
	public int getDots() {
		return this.dots;
	}
	
	public void addDots(int var) {
		this.dots += var;
	}
	
	public Image getHead() {
		return this.head;
	}
	
	public Image getBall() {
		return this.ball;
	}
	
	public int[] getX() {
		return this.x;
	}
	
	public int[] getY() {
		return this.y;
	}
	
	private void initSnake() {
		ImageIcon iid = new ImageIcon("src/resources/dot.png");
		this.ball = iid.getImage();
		
		ImageIcon iih = new ImageIcon("src/resources/head.png");
		this.head = iih.getImage();
		
		this.dots = 5;

		for (int i = 0; i < this.dots; i++) {
			this.x[i] = 100 - i * 10;
			this.y[i] = 100 - i * 10;
		}
	}
	
	public void set() {
		this.dots = 5;

		leftDir = false;
		rightDir = true;
		upDir = false;
		downDir = false;
		
		for (int i = 0; i < this.dots; i++) {
			this.x[i] = 100 - i * 10;
			this.y[i] = 100 - i * 10;
		}
	}
	
	public void move() {
		for (int i = this.dots; i > 0; i--) {
			this.x[i] = this.x[i - 1];
			this.y[i] = this.y[i - 1];
		}

		if (this.leftDir) {
			this.x[0] -= Board.dotSize;
		} else if (rightDir) {
			this.x[0] += Board.dotSize;
		} else if (upDir) {
			this.y[0] -= Board.dotSize;
		} else if (downDir) {
			this.y[0] += Board.dotSize;
		}

		if (this.x[0] < 0) {
			this.x[0] = Board.boardWidth;
		} else if (x[0] >= Board.boardWidth) {
			this.x[0] = 0;
		} else if (this.y[0] < 0) {
			this.y[0] = Board.boardHeight;
		} else if (y[0] >= Board.boardHeight) {
			this.y[0] = 0;
		}
	}
	
	public boolean eat(int x, int y) {
		if (this.x[0] == x && this.y[0] == y) {
			return true;
		}
		
		return false;
	}
	
	public boolean checkCollision() {
		for (int i = this.dots; i > 3; i--) {
			if (this.x[0] == this.x[i] && this.y[0] == this.y[i]) {
				return true;
			}
		}
		/*
		 * if (y[0] >= boardHeight) { inGame = false; }
		 * 
		 * if (y[0] < 0) { inGame = false; }
		 * 
		 * if (x[0] >= boardWidth) { inGame = false; }
		 * 
		 * if (x[0] < 0) { inGame = false; }
		 */
		return false;
	}

}
