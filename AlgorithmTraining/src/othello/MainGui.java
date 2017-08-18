package othello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGui extends JFrame implements ActionListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton  jButton[][] = new JButton[8][8];
	JButton displayColor;
	JPanel row [] = new JPanel[9];
	JPanel columnPanel;
	JLabel displayLabel,playerOneScore,playerTwoScore;

	public MainGui() {
		// TODO Auto-generated constructor stub
		super("Othello");
		this.setSize(540, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(9, 9,1,1));
		this.setResizable(false);
		Font font1 = new Font("Times new Roman", Font.BOLD, 24);
		Font font2 = new Font("Times new Roman", Font.BOLD, 12);
		displayLabel = new JLabel("Welcome to Othello....");
		playerOneScore = new JLabel("Player One Score: 2");
		playerTwoScore = new JLabel("Player Two Score: 2");
		displayColor = new JButton();
		columnPanel = new JPanel();
		displayLabel.setFont(font1);
		playerOneScore.setFont(font2);
		playerTwoScore.setFont(font2);
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				jButton[i][j] = new JButton();
				jButton[i][j].setPreferredSize(new Dimension(60, 40));
				jButton[i][j].addActionListener(this);
				jButton[i][j].setActionCommand(i+","+j);
				jButton[i][j].setEnabled(false);
			}
		}
		displayColor.setEnabled(false);
		displayColor.setPreferredSize(new Dimension(20,20));
		displayColor.setBackground(Color.BLUE);
		displayColor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		jButton[3][3].setBackground(Color.BLUE);
		jButton[3][4].setBackground(Color.BLACK);
		jButton[4][3].setBackground(Color.BLACK);
		jButton[4][4].setBackground(Color.BLUE);
		columnPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		for (int i = 0; i < 9; i++) {
			row[i] = new JPanel();
			row[i].setLayout(new FlowLayout(FlowLayout.LEFT));
		}
		row[0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		row[0].add(displayLabel);
		row[0].add(displayColor);
		row[0].add(playerOneScore, FlowLayout.RIGHT);
		row[0].add(playerTwoScore);
		displayColor.setVisible(false);
		//Adding the buttons to Jpanel
		for (int i = 1; i < 9; i++) {
			for (int j = 0; j < 8; j++) {
				int k = i-1;
				row[i].add(jButton[k][j]);
			}
		}
		
		//Adding Jpanels to the JFrame
		for (int i = 0; i < 9; i++) {
			
			add(row[i]);
		}
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String getPostion = null;
		int getRow = 0,getColumn = 0;
		int scoreOne = 2, scoreTwo = 2;
		boolean checkForGreen = false,checkForGame = true;
		getPostion = e.getActionCommand().toString();
		getRow = ((getPostion.charAt(0)) - '0');
		getColumn = ((getPostion.charAt(2)) - '0');
		
		//reset Color of green colored button as well as disable them 
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if(jButton[row][column].getBackground() == Color.GREEN){
					jButton[row][column].setBackground(null);
					jButton[row][column].setEnabled(false);
				}
			}
			
		}
		
		if(displayColor.getBackground().equals(Color.BLUE)){
			System.out.println(getPostion+"	"+getRow+"	"+getColumn);
			GameManager.buttonController.paintTheButtons(getRow, getColumn,1);
			displayColor.setBackground(Color.BLACK);
			displayLabel.setText("Player Two your turn...");
			
			//create Valid moves for player 2 
			for (int row = 0; row < 8; row++) {
				for (int column = 0; column < 8; column++) {
					if(jButton[row][column].getBackground() == Color.BLACK){
						System.out.print("\n"+row+" , "+column);
						GameManager.buttonController.createValidMove(row, column);
					}
				}
			}
			//if there is no green button than there is no valid move for Player two
			for (int row = 0; row < 8; row++) {
				for (int column = 0; column < 8; column++) {
					if(jButton[row][column].getBackground() == Color.GREEN){
						checkForGreen = true;
						break;
					}
				}
			}
			
			if(!checkForGreen){
				try {
					displayColor.setBackground(Color.BLACK);
					displayLabel.setText("There is no Move for player two...");
					Thread.sleep(100);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				displayColor.setBackground(Color.BLUE);
				displayLabel.setText("Player One your turn...");
				for (int row = 0; row < 8; row++) {
					for (int column = 0; column < 8; column++) {
						if(jButton[row][column].getBackground() == Color.BLUE){
							System.out.print("\n"+row+" , "+column);
							GameManager.buttonController.createValidMove(row, column);
						}
					}
				}
			}
		}
		else {
			System.out.println(getPostion+"	"+getRow+"	"+getColumn);
			GameManager.buttonController.paintTheButtons(getRow, getColumn,2);
			displayColor.setBackground(Color.BLUE);
			displayLabel.setText("Player one your turn...");
			//create Valid moves for player 1 
			for (int row = 0; row < 8; row++) {
				for (int column = 0; column < 8; column++) {
					if(jButton[row][column].getBackground() == Color.BLUE){
						System.out.print("\n"+row+" , "+column);
						GameManager.buttonController.createValidMove(row, column);
					}
				}
			}
			
			//if there is no green button than there is no valid move for Player one
			for (int row = 0; row < 8; row++) {
				for (int column = 0; column < 8; column++) {
					if(jButton[row][column].getBackground() == Color.GREEN){
						checkForGreen = true;
						break;
					}
				}
				
			}
			
			if(!checkForGreen){
				try {
					displayColor.setBackground(Color.BLUE);
					displayLabel.setText("There is no Move for player One...");
					Thread.sleep(100);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				displayColor.setBackground(Color.BLACK);
				displayLabel.setText("Player Two your turn...");
				for (int row = 0; row < 8; row++) {
					for (int column = 0; column < 8; column++) {
						if(jButton[row][column].getBackground() == Color.BLACK){
							System.out.print("\n"+row+" , "+column);
							GameManager.buttonController.createValidMove(row, column);
						}
					}
				}
			}	
		}
		
		//Count Scores
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if(GameManager.buttonController.array[row][column] == 1){
					scoreOne++;
				}
				else {
					scoreTwo++;
				}
			}
		}
		
		playerOneScore.setText("Player One Score:"+scoreOne);
		playerTwoScore.setText("Player Two Score:"+scoreTwo);
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if(GameManager.buttonController.array[row][column] == 0){
					checkForGame = false;
					break;
				}
			}
		}
		if(checkForGame){
			GameManager.buttonController.countScore();
		}
	}
}
