package screens;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Managers.EffectsManager;
import Managers.SoundManager;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerVsComputerGameSetupScreen extends JFrame {

	private JPanel contentPane;

	//launch the screen//
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerVsComputerGameSetupScreen frame = new PlayerVsComputerGameSetupScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//create the frame//
	public PlayerVsComputerGameSetupScreen() {
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
		
		JPanel TilteContainerPanel = new JPanel();
		TilteContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		TilteContainerPanel.setBounds(491, 10, 479, 121);
		contentPane.add(TilteContainerPanel);
		TilteContainerPanel.setLayout(null);
		
		//addind components and actions//
		JLabel TitleLabel = new JLabel("");
		TitleLabel.setBounds(0, 0, 479, 121);
		EffectsManager.SetImageLabel(TitleLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\PlayerVsAITitle.png");
		TilteContainerPanel.add(TitleLabel);
		
		JPanel RivalRadioButtonContainerPanel = new JPanel();
		RivalRadioButtonContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		RivalRadioButtonContainerPanel.setBounds(142, 252, 1308, 548);
		contentPane.add(RivalRadioButtonContainerPanel);
		RivalRadioButtonContainerPanel.setLayout(null);
		
		JButton Boss1Button = new JButton("");
		Boss1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				SoundManager.StopMusic();
				dispose();
				Levels.Chapter1.main();
			}
		});
		Boss1Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Boss1Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss1MouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Boss1Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss1.png");
			}
		});
		Boss1Button.setBorderPainted(false);
		Boss1Button.setBounds(10, 10, 270, 300);
		EffectsManager.SetImageButton(Boss1Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss1.png");
		RivalRadioButtonContainerPanel.add(Boss1Button);
		
		JButton Boss2Button = new JButton("");
		Boss2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				SoundManager.StopMusic();
				dispose();
				Levels.Chapter2.main();
			}
		});
		Boss2Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Boss2Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss2MouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Boss2Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss2.png");
			}
		});
		Boss2Button.setBorderPainted(false);
		Boss2Button.setBounds(338, 10, 270, 300);
		EffectsManager.SetImageButton(Boss2Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss2.png");
		RivalRadioButtonContainerPanel.add(Boss2Button);
		
		JButton Boss3Button = new JButton("");
		Boss3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				SoundManager.StopMusic();
				dispose();
				Levels.Chapter3.main();
			}
		});
		Boss3Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Boss3Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss3MouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Boss3Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss3.png");
			}
		});
		Boss3Button.setBorderPainted(false);
		Boss3Button.setBounds(661, 10, 270, 300);
		EffectsManager.SetImageButton(Boss3Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss3.png");
		RivalRadioButtonContainerPanel.add(Boss3Button);
		
		JButton Boss4Button = new JButton("");
		Boss4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				SoundManager.StopMusic();
				dispose();
				Levels.Chapter4.main();
			}
		});
		Boss4Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Boss4Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss4MouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Boss4Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss4.png");
			}
		});
		Boss4Button.setBorderPainted(false);
		Boss4Button.setBounds(965, 10, 270, 300);
		EffectsManager.SetImageButton(Boss4Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss4.png");
		RivalRadioButtonContainerPanel.add(Boss4Button);
		
		JButton Boss5Button = new JButton("");
		Boss5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				SoundManager.StopMusic();
				dispose();
				Levels.Chapter5.main();
			}
		});
		Boss5Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Boss5Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss5MouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Boss5Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss5.png");
			}
		});
		Boss5Button.setBorderPainted(false);
		Boss5Button.setBounds(462, 367, 270, 140);
		EffectsManager.SetImageButton(Boss5Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\Boss5.png");
		RivalRadioButtonContainerPanel.add(Boss5Button);
		
		JLabel BossContainerBackground = new JLabel("");
		BossContainerBackground.setBounds(0, 0, 1308, 548);
		EffectsManager.SetImageLabel(BossContainerBackground, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\PlayerVsAI\\BossesContainer.png");
		RivalRadioButtonContainerPanel.add(BossContainerBackground);
		
		JPanel ReturnButtonContainerPanel = new JPanel();
		ReturnButtonContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ReturnButtonContainerPanel.setBounds(10, 10, 100, 43);
		contentPane.add(ReturnButtonContainerPanel);
		ReturnButtonContainerPanel.setLayout(null);
		
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
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				GameSetupScreen.main();
				dispose();
			}
		});
		ReturnButton.setBounds(0, 0, 100, 43);
		EffectsManager.SetImageButton(ReturnButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\ReturnButton.png");
		ReturnButtonContainerPanel.add(ReturnButton);
		
		JLabel BackgroundContainerLabel = new JLabel("");
		BackgroundContainerLabel.setBounds(0, 0, 1540, 845);
		EffectsManager.SetImageLabel(BackgroundContainerLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\BasicScreenBackground.png");
		contentPane.add(BackgroundContainerLabel);
		
	}
}
