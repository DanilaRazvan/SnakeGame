package snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Info extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final int infoWidth = 300;
	private static final int infoHeight = 400;

	private JPanel titleP = new JPanel();
	private JLabel titleL = new JLabel();

	private JPanel userP = new JPanel();
	private JLabel userL = new JLabel("User:");
	private JTextField user = new JTextField();

	private JPanel passwordP = new JPanel();
	private JLabel passwordL = new JLabel("Password:");
	private JTextField password = new JTextField();

	private JPanel scoreP = new JPanel();
	private JLabel scoreL = new JLabel("Score:");
	private JLabel score = new JLabel();

	private JPanel buttonsP = new JPanel();
	private JButton start = new JButton("Start Game");
	private JButton newUser = new JButton("New User");
	
	Board b;

	public Info(Board b) {
		setPreferredSize(new Dimension(infoWidth, infoHeight));
		setBackground(Color.BLACK);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		start.addActionListener(new startButtonListener());
		newUser.addActionListener(new newUserButtonListener());

		this.b = b;
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
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		setDesign();
	}

	private void setDesign() {
		
		// TITLE
		titleL.setText("SNAKE");
		titleL.setForeground(Color.GREEN);

		titleP.setBackground(Color.BLACK);
		titleP.add(titleL);

		this.add(titleP);

		// USER
		userL.setForeground(Color.GREEN);

		user.setPreferredSize(new Dimension(200, 20));
		
		userP.setBackground(Color.BLACK);
		userP.add(userL);
		userP.add(user);

		this.add(userP);

		// PASSWORD
		passwordL.setForeground(Color.GREEN);

		password.setPreferredSize(new Dimension(200, 20));
		
		passwordP.setBackground(Color.BLACK);
		passwordP.add(passwordL);
		passwordP.add(password);

		this.add(passwordP);

		// SCORE
		scoreL.setForeground(Color.GREEN);

		score.setPreferredSize(new Dimension(200, 20));

		scoreP.setBackground(Color.BLACK);
		scoreP.add(scoreL);
		scoreP.add(score);

		this.add(scoreP);

		// BUTTONS
		buttonsP.setLayout(new GridLayout(2, 2));
		buttonsP.add(start);
		buttonsP.add(newUser);

		this.add(buttonsP);
	}
	
	private class startButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
		}

	}

	private class newUserButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		}

	}

}
