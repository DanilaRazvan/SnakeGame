package snakegame;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Food {
	
	private int apple_x;
	private int apple_y;
	
	private Image apple;
	
	private Snake s;
	
	public Food(Snake s) {
		this.s = s;
		initFood();
	}

	private void initFood() {
		ImageIcon iia = new ImageIcon("src/resources/apple.png");
		apple = iia.getImage();
	}
	
	public int getAppleX() {
		return this.apple_x;
	}
	
	public int getAppleY() {
		return this.apple_y;
	}
	
	public Image getApple() {
		return this.apple;
	}
	
	public void locateApple() {

		Random rand = new Random();

		do {
			int r = (rand.nextInt(Board.boardWidth / 10 - 1));
			apple_x = (int) Math.ceil(r * Board.dotSize);

			r = rand.nextInt(Board.boardHeight / 10 - 1);
			apple_y = (int) Math.ceil(r * Board.dotSize);
		} while (!checkLocation());
	}

	private boolean checkLocation() {
		for(int i = 0; i < s.getDots(); i++) {
			if(apple_x == s.getX()[i] && apple_y == s.getY()[i]) {
				return false;
			}
		}

		return true;
	}
}
