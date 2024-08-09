package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Managers.EffectsManager;
import Managers.SoundManager;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class PlayerVsPlayerGameSetupScreen extends JFrame {

	private JPanel contentPane;
	private JTextField Player1NameTextField;
	private JTextField Player2NameTextField;
	
	public static String Player1Name;
	public static String Player2Name;
	
	public static String GetPlayer1() {
		return Player1Name;
	}
	
	public static String GetPlayer2() {
		return Player2Name;
	}
	

	//launch the screen//
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerVsPlayerGameSetupScreen frame = new PlayerVsPlayerGameSetupScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//create the frame//
	public PlayerVsPlayerGameSetupScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		//setting the frame//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Addind the buttons and visual elements//
		JPanel TitleContainerPanel = new JPanel();
		TitleContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		TitleContainerPanel.setBounds(476, 30, 561, 96);
		contentPane.add(TitleContainerPanel);
		TitleContainerPanel.setLayout(null);
		
		JLabel TitleLabel = new JLabel("");
		TitleLabel.setBounds(0, 0, 561, 96);
		EffectsManager.SetImageLabel(TitleLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsPlayerScreen\\PlayerVsPlayerTitle.png");
		TitleContainerPanel.add(TitleLabel);
		
		JPanel Player1SettingsContainerPanel = new JPanel();
		Player1SettingsContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Player1SettingsContainerPanel.setBounds(252, 316, 364, 89);
		contentPane.add(Player1SettingsContainerPanel);
		Player1SettingsContainerPanel.setLayout(null);
		
		JLabel Player1NameLabel = new JLabel("Insert name");
		Player1NameLabel.setForeground(new Color(0, 0, 0));
		Player1NameLabel.setFont(new Font("MingLiU_HKSCS-ExtB", Font.PLAIN, 27));
		Player1NameLabel.setBounds(20, 9, 160, 50);
		Player1SettingsContainerPanel.add(Player1NameLabel);
		
		Player1NameTextField = new JTextField();
		Player1NameTextField.setBackground(new Color(255, 255, 0));
		Player1NameTextField.setBounds(200, 22, 150, 30);
		Player1SettingsContainerPanel.add(Player1NameTextField);
		Player1NameTextField.setColumns(10);
		
		JLabel Player1Container = new JLabel("");
		Player1Container.setBounds(0, 0, 364, 89);
		EffectsManager.SetImageLabel(Player1Container, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsPlayerScreen\\PlayerContainerBackground.png");
		Player1SettingsContainerPanel.add(Player1Container);
		
		JPanel Player2SettingsContainerPanel = new JPanel();
		Player2SettingsContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Player2SettingsContainerPanel.setBounds(910, 316, 409, 89);
		contentPane.add(Player2SettingsContainerPanel);
		Player2SettingsContainerPanel.setLayout(null);
		
		JLabel Player2NameLabel = new JLabel("Insert name");
		Player2NameLabel.setFont(new Font("MingLiU_HKSCS-ExtB", Font.PLAIN, 27));
		Player2NameLabel.setBounds(20, 9, 155, 60);
		Player2SettingsContainerPanel.add(Player2NameLabel);
		
		Player2NameTextField = new JTextField();
		Player2NameTextField.setBackground(new Color(255, 255, 0));
		Player2NameTextField.setBounds(200, 22, 150, 30);
		Player2SettingsContainerPanel.add(Player2NameTextField);
		Player2NameTextField.setColumns(10);
		
		JLabel Player2Container = new JLabel("");
		Player2Container.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Player2Container.setBounds(0, 0, 409, 89);
		EffectsManager.SetImageLabel(Player2Container, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsPlayerScreen\\PlayerContainerBackground.png");
		Player2SettingsContainerPanel.add(Player2Container);
		
		JPanel StartButtonContainerPanel = new JPanel();
		StartButtonContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		StartButtonContainerPanel.setBounds(660, 549, 235, 75);
		contentPane.add(StartButtonContainerPanel);
		StartButtonContainerPanel.setLayout(null);
		
		JPanel ReturnButtonContainerPanel = new JPanel();
		ReturnButtonContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ReturnButtonContainerPanel.setBounds(10, 10, 161, 58);
		contentPane.add(ReturnButtonContainerPanel);
		
		JButton ReturnButton = new JButton();
		ReturnButton.setBorderPainted(false);
		ReturnButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(ReturnButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\ReturnButtonMouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(ReturnButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\ReturnButton.png");
			}
		});
		ReturnButton.setBounds(0, 0, 161, 58);
		EffectsManager.SetImageButton(ReturnButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\ReturnButton.png");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				GameSetupScreen.main();
				dispose();
			}
		});
		ReturnButtonContainerPanel.setLayout(null);
		ReturnButtonContainerPanel.add(ReturnButton);
		
		JLabel BackgroundContainerLabel = new JLabel("");
		BackgroundContainerLabel.setForeground(new Color(128, 0, 0));
		BackgroundContainerLabel.setBounds(0, 0, 1540, 845);
		EffectsManager.SetImageLabel(BackgroundContainerLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\BasicScreenBackground.png");
		contentPane.add(BackgroundContainerLabel);
		
		JButton StartButton = new JButton("");
		StartButton.setBounds(660, 549, 235, 75);
		contentPane.add(StartButton);
		StartButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(StartButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsPlayerScreen\\StartMatchButtonMouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(StartButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsPlayerScreen\\StartMatchButton.png");
			}
		});
		StartButton.setBorderPainted(false);
		EffectsManager.SetImageButton(StartButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsPlayerScreen\\StartMatchButton.png");
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				Player1Name = Player1NameTextField.getText();
				Player2Name = Player2NameTextField.getText();
				PlayerVsPlayerScreen.main();
				dispose();
			}
		});
	}
}
