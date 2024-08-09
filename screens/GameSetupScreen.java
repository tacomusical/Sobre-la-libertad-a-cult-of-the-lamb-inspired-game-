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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameSetupScreen extends JFrame {

	private JPanel contentPane;

	//launch the screen//
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSetupScreen frame = new GameSetupScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//create the frame//
	public GameSetupScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		//setting the farme//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//addings componets and actions to buttons//
		JPanel StoryModeButtonContainerPanel = new JPanel();
		StoryModeButtonContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		StoryModeButtonContainerPanel.setBounds(556, 99, 391, 86);
		contentPane.add(StoryModeButtonContainerPanel);
		StoryModeButtonContainerPanel.setLayout(null);
		
		JButton StoryModeButton = new JButton("");
		StoryModeButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(StoryModeButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\GameSetup\\CampaignButtonMouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(StoryModeButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\GameSetup\\CampaignButton.png");
			}
		});
		StoryModeButton.setBorderPainted(false);
		StoryModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				StoryModeGameSetupScreen.main();
				dispose();
			}
		});
		StoryModeButton.setBounds(0, 0, 391, 86);
		EffectsManager.SetImageButton(StoryModeButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\GameSetup\\CampaignButton.png");
		StoryModeButtonContainerPanel.add(StoryModeButton);
		
		JPanel PlayerVsComputerButtonContainerPanel = new JPanel();
		PlayerVsComputerButtonContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlayerVsComputerButtonContainerPanel.setBounds(556, 346, 392, 86);
		contentPane.add(PlayerVsComputerButtonContainerPanel);
		PlayerVsComputerButtonContainerPanel.setLayout(null);
		
		JButton PlayerVsComputerButton = new JButton("");
		PlayerVsComputerButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(PlayerVsComputerButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\GameSetup\\PlayerVsAIButtonMouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(PlayerVsComputerButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\GameSetup\\PlayerVsAIButton.png");
			}
		});
		PlayerVsComputerButton.setBorderPainted(false);
		PlayerVsComputerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				PlayerVsComputerGameSetupScreen.main();
				dispose();
			}
		});
		PlayerVsComputerButton.setBounds(0, 0, 392, 86);
		EffectsManager.SetImageButton(PlayerVsComputerButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\GameSetup\\PlayerVsAIButton.png");
		PlayerVsComputerButtonContainerPanel.add(PlayerVsComputerButton);
		
		JPanel PlayerVsPlayerButtonContainerPanel = new JPanel();
		PlayerVsPlayerButtonContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlayerVsPlayerButtonContainerPanel.setBounds(556, 593, 391, 86);
		contentPane.add(PlayerVsPlayerButtonContainerPanel);
		PlayerVsPlayerButtonContainerPanel.setLayout(null);
		
		JButton PlayerVsPlayerButton = new JButton("");
		PlayerVsPlayerButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(PlayerVsPlayerButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\GameSetup\\PlayerVsPlayerMouseEvent.png");
			}
			public void mouseExited(MouseEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffectMouseEvent);
				EffectsManager.SetImageButton(PlayerVsPlayerButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\GameSetup\\PlayerVsPlayerButton.png");
			}
		});
		PlayerVsPlayerButton.setBorderPainted(false);
		PlayerVsPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				PlayerVsPlayerGameSetupScreen.main();
				dispose();
			}
		});
		PlayerVsPlayerButton.setBounds(0, 0, 391, 86);
		EffectsManager.SetImageButton(PlayerVsPlayerButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\GameSetup\\PlayerVsPlayerButton.png");
		PlayerVsPlayerButtonContainerPanel.add(PlayerVsPlayerButton);
		
		JPanel ReturnButtonContainerPanel = new JPanel();
		ReturnButtonContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ReturnButtonContainerPanel.setBounds(10, 10, 96, 29);
		contentPane.add(ReturnButtonContainerPanel);
		ReturnButtonContainerPanel.setLayout(null);
		
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
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundManager.ReproduceSoundEffect(SoundManager.ButtonSoundEffect);
				MenuScreen.main();
				dispose();
			}
		});
		ReturnButton.setBounds(0, 0, 96, 29);
		EffectsManager.SetImageButton(ReturnButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\ReturnButton.png");
		ReturnButtonContainerPanel.add(ReturnButton);
		
		JLabel BackgroundContainerLabel = new JLabel("");
		BackgroundContainerLabel.setBounds(0, 0, 1540, 845);
		EffectsManager.SetImageLabel(BackgroundContainerLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\BasicScreenBackground.png");
		contentPane.add(BackgroundContainerLabel);
	}
}
