package snakegame;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Game() {
		initUI();
	}
	
	private void initUI() {
		Board board = new Board();
		Info info = new Info(board);
		
		setLayout(new FlowLayout());
		add(board);
		add(info);
		setResizable(false);
		pack();
		
		setTitle("Snake");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Game snakeGame = new Game();
		snakeGame.setVisible(true);
	}

}
