package othello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class GameManager {

	/**
	 * @param args
	 */
	
	public static MainGui mainGui;
	public static ButtonController buttonController;
	JPanel jPanel;
	JLabel jLabel;
	JProgressBar jProgressBar;
	Font font;
	public GameManager() {
		// TODO Auto-generated constructor stub
		JWindow jWindow = new JWindow();
		jPanel = new JPanel(new BorderLayout());
		jLabel = new JLabel();
		jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL,0,100);
		font = new Font("Times new roman", Font.BOLD, 50);
		BorderLayout borderLayout = new BorderLayout();
		jWindow.setSize(540, 480);
		jWindow.setLocationRelativeTo(null);
		jWindow.setLayout(borderLayout);
		
		jPanel.setSize(540, 480);
		jPanel.setOpaque(true);
		jLabel.setIcon(new ImageIcon("Image/othello_top.jpg"));
		jLabel.setFont(font);
		jLabel.setForeground(Color.RED);
		jProgressBar.setBackground(Color.black);
		jPanel.add(jLabel,BorderLayout.WEST);
		jPanel.add(jProgressBar, BorderLayout.SOUTH);
		jWindow.add(jPanel,BorderLayout.CENTER);
		jWindow.setVisible(true);
		try {
			for (int i = 0; i <100; i++) {
				jProgressBar.setValue(i);
				Thread.sleep(50);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		jWindow.setVisible(false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameManager();
		mainGui = new MainGui();
		buttonController = new ButtonController();
		mainGui.displayLabel.setText("Player One Your Turn...");
		mainGui.displayColor.setVisible(true);
		buttonController.createValidMove(3,3);
		buttonController.createValidMove(4,4);
	}

}
