package screens;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Managers.EffectsManager;
import Managers.SoundManager;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuScreen extends JFrame {
	
	//Declaratation of contentPane//
	private JPanel contentPane;
	
	//Declaration of managers//
	//static SoundManager SoundManager = new SoundManager();
	
	
	//launch the application//
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuScreen frame = new MenuScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	//create all the screen//
	public MenuScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		setTitle("Sobre la libertad");
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
		
		//Adding the music//
		SoundManager.ReproduceMusicInLoop(SoundManager.MainMenuTheme);
		
		
		
		JButton StartButton = new JButton("");
		StartButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(StartButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\MenuResources\\StartButtonMouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(StartButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\MenuResources\\StartButton.png");
			}
		});
		StartButton.setBorderPainted(false);
		StartButton.setBounds(620, 372, 300, 100);
		EffectsManager.SetImageButton(StartButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\MenuResources\\StartButton.png");
		contentPane.add(StartButton);
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				screens.GameSetupScreen.main();
				dispose();
			}
		});
		
		JButton SettingsButton = new JButton("");
		SettingsButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(SettingsButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\MenuResources\\SettingsButtonMouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(SettingsButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\MenuResources\\SettingsButton.png");
			}
		});
		SettingsButton.setBorderPainted(false);
		SettingsButton.setBounds(620, 497, 300, 100);
		EffectsManager.SetImageButton(SettingsButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\MenuResources\\SettingsButton.png");
		contentPane.add(SettingsButton);
		SettingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				screens.SettingsScreen.main();
				dispose();
			}
		});
		
		JButton CreditsButton = new JButton("");
		CreditsButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(CreditsButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\MenuResources\\CreditsButtonMouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(CreditsButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\MenuResources\\CreditsButton.png");
			}
		});
		CreditsButton.setBorderPainted(false);
		CreditsButton.setBounds(620, 629, 300, 100);
		EffectsManager.SetImageButton(CreditsButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\MenuResources\\CreditsButton.png");
		contentPane.add(CreditsButton);
		CreditsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				screens.CreditScreen.main();
				dispose();
			}
		});
		
		JLabel BackgroundContainerLabel = new JLabel("");
		BackgroundContainerLabel.setBounds(10, 10, 1520, 825);
		EffectsManager.SetImageLabel(BackgroundContainerLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\MenuResources\\MenuImage.png");
		contentPane.add(BackgroundContainerLabel);
	}
}
