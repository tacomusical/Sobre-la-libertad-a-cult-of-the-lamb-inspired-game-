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

public class YouLoseScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YouLoseScreen frame = new YouLoseScreen();
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
	public YouLoseScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		setTitle("...");
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
		
		JLabel YouLoseLabel = new JLabel("YOU LOSE");
		YouLoseLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
		YouLoseLabel.setForeground(new Color(255, 0, 0));
		YouLoseLabel.setBounds(638, 392, 533, 230);
		contentPane.add(YouLoseLabel);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.StopMusic();
				dispose();
				screens.StoryModeGameSetupScreen.main();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(790, 650, 108, 31);
		contentPane.add(btnNewButton);
	}
}
