package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Managers.EffectsManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class PlayerVSPlayerResultScreen extends JFrame {

	private JPanel contentPane;
	String Winner;
	String Loser;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerVSPlayerResultScreen frame = new PlayerVSPlayerResultScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayerVSPlayerResultScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		//setting the frame//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		EffectsManager.OpeningLeftToRightScreenEffect(contentPane);
		
		//get who is loser and winner//
		Winner = PlayerVsPlayerScreen.Winner;
		Loser = PlayerVsPlayerScreen.Loser;
		
		//setting the buttons and visual stuff//
		JPanel WinnerBarPanel = new JPanel();
		WinnerBarPanel.setBackground(new Color(255, 255, 0));
		WinnerBarPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		WinnerBarPanel.setBounds(785, 277, 688, 558);
		contentPane.add(WinnerBarPanel);
		
		JPanel LoserBarPanel = new JPanel();
		LoserBarPanel.setBackground(new Color(255, 0, 0));
		LoserBarPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		LoserBarPanel.setBounds(50, 571, 639, 264);
		contentPane.add(LoserBarPanel);
		
		JLabel ShowLoserLabel = new JLabel(Loser);
		ShowLoserLabel.setForeground(new Color(255, 0, 0));
		ShowLoserLabel.setBackground(new Color(255, 0, 0));
		ShowLoserLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
		ShowLoserLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ShowLoserLabel.setBounds(50, 375, 639, 167);
		contentPane.add(ShowLoserLabel);
		
		JLabel ShowWinnerLabel = new JLabel(Winner);
		ShowWinnerLabel.setForeground(new Color(255, 255, 0));
		ShowWinnerLabel.setBackground(new Color(255, 255, 0));
		ShowWinnerLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
		ShowWinnerLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ShowWinnerLabel.setBounds(785, 37, 688, 167);
		contentPane.add(ShowWinnerLabel);
	}
}
