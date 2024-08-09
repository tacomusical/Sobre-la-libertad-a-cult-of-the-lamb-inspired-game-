package Levels;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Managers.EffectsManager;
import Managers.SoundManager;
import screens.PlayerVsComputerGameSetupScreen;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YouWinScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YouWinScreen frame = new YouWinScreen();
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
	public YouWinScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		setTitle("!!!");
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(0, 0, 0));
		//setting the frame//
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		EffectsManager.OpeningLeftToRightScreenEffect(contentPane);
		
		JLabel YouLoseLabel = new JLabel("YOU WIN!!!!!!");
		YouLoseLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
		YouLoseLabel.setForeground(new Color(255, 255, 0));
		YouLoseLabel.setBounds(462, 322, 661, 300);
		contentPane.add(YouLoseLabel);
		
		JButton ReturnButton = new JButton("Return");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.StopMusic();
				dispose();
				screens.StoryModeGameSetupScreen.main();
			}
		});
		ReturnButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ReturnButton.setBounds(728, 706, 103, 31);
		contentPane.add(ReturnButton);
	}
}
