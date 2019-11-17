package snakegame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	final static int boardWidth = 400;
	final static int boardHeight = 400;
	final static int dotSize = 10;
	final static int allDots = Board.boardWidth / dotSize * Board.boardHeight / dotSize;
	
	private final int delay = 70;

	public Timer timer;

	public static boolean inPause = false;
	public boolean inGame = true;
	
	private Snake s;
	private Food f;
	
	public Board() {
		setPreferredSize(new Dimension(boardWidth, boardHeight));
		setBackground(Color.BLACK);
		setFocusable(true);
		
		s = new Snake();
		f = new Food(s);
		
		initBoard();
	}

	public void newGame() {
		inGame = true;
		s.set();
		initGame();
	}
	
	public void initBoard() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_LEFT && !s.getRightDir()) {
					s.setLeftDir(true);
					s.setUpDir(false);
					s.setDownDir(false);
				}

				if (key == KeyEvent.VK_RIGHT && !s.getLeftDir()) {
					s.setRightDir(true);
					s.setUpDir(false);
					s.setDownDir(false);
				}

				if (key == KeyEvent.VK_UP && !s.getDownDir()) {
					s.setUpDir(true);
					s.setLeftDir(false);
					s.setRightDir(false);
				}

				if (key == KeyEvent.VK_DOWN && !s.getUpDir()) {
					s.setDownDir(true);
					s.setLeftDir(false);
					s.setRightDir(false);
				}
				
				if(inGame && key == KeyEvent.VK_P) {
					inPause = true;
					timer.stop();
				} else if(inGame && key == KeyEvent.VK_S) {
					inPause = false;
					timer.start();
				}

				if (!inGame && key == KeyEvent.VK_ENTER) {
					newGame();
				}
			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				inPause = true;
				timer.stop();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				inPause = false;
				timer.start();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (inGame && e.getButton() == MouseEvent.BUTTON1) {
					s.addDots(2);
				}
			}
		});
		
		initGame();
	}

	public void initGame() {
		f.locateApple();

		timer = new Timer(delay, this);
		timer.start();
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}

	public void doDrawing(Graphics g) {
		if (inGame) {

			g.drawImage(f.getApple(), f.getAppleX(), f.getAppleY(), this);

			for (int i = 0; i < s.getDots(); i++) {
				if (i == 0) {
					g.drawImage(s.getHead(), s.getX()[i], s.getY()[i], this);
				} else {
					g.drawImage(s.getBall(), s.getX()[i], s.getY()[i], this);
				}
			}
		} else {
			gameOver(g);
		}
	}

	public void gameOver(Graphics g) {
		timer.stop();
		
		String msg = "Game Over";
		String restart = "If you want to play again press ENTER";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (boardWidth - metr.stringWidth(msg)) / 2, boardHeight / 2 - 10);
		g.drawString(restart, (boardWidth - metr.stringWidth(restart)) / 2, boardHeight / 2 + 10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (inGame) {
			if(s.eat(f.getAppleX(), f.getAppleY())) {
				s.addDots(1);
				f.locateApple();
			}
			
			if(s.checkCollision()) {
				this.inGame = false;
			}
			
			s.move();
		}

		repaint();
	}

}
