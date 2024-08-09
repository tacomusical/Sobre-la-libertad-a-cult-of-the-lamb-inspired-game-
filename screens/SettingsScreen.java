package screens;

import java.awt.Dimension;
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

public class SettingsScreen extends JFrame {

	//Declaration of contentPane//
	private JPanel contentPane;
	
	//Declaration of Screens//
	

	//Launch the application//
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingsScreen frame = new SettingsScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//create the frame//
	public SettingsScreen() {
		//setting the frame//
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel SettingsContainerPanel = new JPanel();
		SettingsContainerPanel.setBounds(10, 151, 1512, 623);
		SettingsContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(SettingsContainerPanel);
		SettingsContainerPanel.setLayout(null);
		
		JLabel SettingsLabel = new JLabel("");
		SettingsLabel.setBounds(31, 6, 1460, 589);
		EffectsManager.SetImageLabel(SettingsLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\SettingsScreen\\Settings.png");
		SettingsContainerPanel.add(SettingsLabel);
		
		JPanel ReturnButtonContainerPanel = new JPanel();
		ReturnButtonContainerPanel.setBounds(10, 10, 128, 38);
		ReturnButtonContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
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
		ReturnButton.setBounds(0, 0, 128, 38);
		EffectsManager.SetImageButton(ReturnButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\ReturnButton.png");
		ReturnButtonContainerPanel.add(ReturnButton);
		
		JLabel SettingsTitleLabel = new JLabel();
		SettingsTitleLabel.setBounds(600, 10, 334, 108);
		EffectsManager.SetImageLabel(SettingsTitleLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\SettingsScreen\\SettingsTitle.png");
		contentPane.add(SettingsTitleLabel);
		
		JLabel BackgroundContainerLabel = new JLabel("");
		BackgroundContainerLabel.setBounds(0, 0, 1540, 845);
		EffectsManager.SetImageLabel(BackgroundContainerLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\BasicScreenBackground.png");
		contentPane.add(BackgroundContainerLabel);
		
	}

}
