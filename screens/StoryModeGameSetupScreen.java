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
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StoryModeGameSetupScreen extends JFrame {

	private JPanel contentPane;

	//launcg the screen//
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoryModeGameSetupScreen frame = new StoryModeGameSetupScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//create the frame//
	public StoryModeGameSetupScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		SoundManager.ReproduceMusicInLoop(SoundManager.MainMenuTheme);
		
		
		JPanel TitleContainerPanel = new JPanel();
		TitleContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		TitleContainerPanel.setBounds(213, 42, 1141, 100);
		contentPane.add(TitleContainerPanel);
		TitleContainerPanel.setLayout(null);
		
		JLabel TitleLabel = new JLabel("");
		TitleLabel.setBounds(0, 0, 1141, 100);
		EffectsManager.SetImageLabel(TitleLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\CampaignTitle.png");
		TitleContainerPanel.add(TitleLabel);
		
		JPanel ReturnButtonContainerLabel = new JPanel();
		ReturnButtonContainerLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ReturnButtonContainerLabel.setBounds(10, 10, 107, 50);
		contentPane.add(ReturnButtonContainerLabel);
		
		JButton ReturnButton = new JButton("");
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
		ReturnButton.setBorderPainted(false);
		ReturnButton.setBounds(0, 0, 107, 50);
		EffectsManager.SetImageButton(ReturnButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\ReturnButton.png");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				GameSetupScreen.main();
				dispose();
			}
		});
		ReturnButtonContainerLabel.setLayout(null);
		ReturnButtonContainerLabel.add(ReturnButton);
		
		JButton Chapter1Button = new JButton("");
		Chapter1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				Levels.Chapter1Cinematic.main();
				dispose();
			}
		});
		Chapter1Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Chapter1Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter1MouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Chapter1Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter1.png");
			}
		});
		Chapter1Button.setBorderPainted(false);
		Chapter1Button.setBounds(64, 243, 250, 300);
		EffectsManager.SetImageButton(Chapter1Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter1.png");
		contentPane.add(Chapter1Button);
		
		JButton Chapter2Button = new JButton("");
		Chapter2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				Levels.Chapter2Cinematic.main();
				dispose();
			}
		});
		Chapter2Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Chapter2Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter2MouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Chapter2Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter2.png");
			}
		});
		Chapter2Button.setBorderPainted(false);
		Chapter2Button.setBounds(368, 243, 250, 300);
		EffectsManager.SetImageButton(Chapter2Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter2.png");
		contentPane.add(Chapter2Button);
		
		JButton Chapter3Button = new JButton("");
		Chapter3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				Levels.Chapter3Cinematic.main();
				dispose();
			}
		});
		Chapter3Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Chapter3Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter3MouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Chapter3Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter3.png");
			}
		});
		Chapter3Button.setBorderPainted(false);
		Chapter3Button.setBounds(665, 243, 250, 300);
		EffectsManager.SetImageButton(Chapter3Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter3.png");
		contentPane.add(Chapter3Button);
		
		JButton Chapter4Button = new JButton("");
		Chapter4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				Levels.Chapter4Cinematic.main();
				dispose();
			}
		});
		Chapter4Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Chapter4Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter4MouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Chapter4Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter4.png");
			}
		});
		Chapter4Button.setBorderPainted(false);
		Chapter4Button.setBounds(964, 243, 250, 300);
		EffectsManager.SetImageButton(Chapter4Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter4.png");
		contentPane.add(Chapter4Button);
		
		JButton Chapter5Button = new JButton("");
		Chapter5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				Levels.Chapter5Cinematic.main();
				dispose();
			}
		});
		Chapter5Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Chapter5Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter5MouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(Chapter5Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter5.png");
			}
		});
		Chapter5Button.setBorderPainted(false);
		Chapter5Button.setBounds(1253, 243, 250, 300);
		EffectsManager.SetImageButton(Chapter5Button, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CampaignChapterScreen\\Chapter5.png");
		contentPane.add(Chapter5Button);
		
		JLabel BackgroundContainerLabel = new JLabel("");
		BackgroundContainerLabel.setBounds(0, 0, 1540, 845);
		EffectsManager.SetImageLabel(BackgroundContainerLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\BasicScreenBackground.png");
		contentPane.add(BackgroundContainerLabel);
		
	}
}
