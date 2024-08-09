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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class CreditScreen extends JFrame {

	private JPanel contentPane;

	//lauch the screen//
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditScreen frame = new CreditScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//create frame//
	public CreditScreen() {
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
		
		JPanel CreditsTitleContainerPanel = new JPanel();
		CreditsTitleContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		CreditsTitleContainerPanel.setBounds(207, 10, 1155, 107);
		contentPane.add(CreditsTitleContainerPanel);
		CreditsTitleContainerPanel.setLayout(null);
		
		JLabel CreditsTitleLabel = new JLabel("");
		CreditsTitleLabel.setBounds(0, 0, 1155, 107);
		EffectsManager.SetImageLabel(CreditsTitleLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CreditsScreen\\CreditsTitle.png");
		CreditsTitleContainerPanel.add(CreditsTitleLabel);
		
		JPanel CreditsContainerPanel = new JPanel();
		CreditsContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		CreditsContainerPanel.setBounds(217, 175, 1145, 550);
		contentPane.add(CreditsContainerPanel);
		CreditsContainerPanel.setLayout(null);
		
		JLabel CreditsLabel = new JLabel("");
		CreditsLabel.setBounds(0, 0, 1145, 550);
		EffectsManager.SetImageLabel(CreditsLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\CreditsScreen\\Credits.png");
		CreditsContainerPanel.add(CreditsLabel);
		
		JPanel ReturnButtonContainerPanel = new JPanel();
		ReturnButtonContainerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ReturnButtonContainerPanel.setBounds(37, 741, 300, 100);
		contentPane.add(ReturnButtonContainerPanel);
		ReturnButtonContainerPanel.setLayout(null);
		
		JButton ReturnButton = new JButton("");
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
				MenuScreen.main();
				dispose();
			}
		});
		ReturnButton.setBounds(0, 0, 300, 100);
		EffectsManager.SetImageButton(ReturnButton, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\ReturnButton.png");
		ReturnButtonContainerPanel.add(ReturnButton);
		
		JLabel BackgroundLabel = new JLabel("");
		BackgroundLabel.setBounds(0, 0, 1540, 845);
		EffectsManager.SetImageLabel(BackgroundLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\BasicScreenBackground.png");
		contentPane.add(BackgroundLabel);
		
		//Adding Components and settings actions//
		
	}
}
