package Levels;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Managers.EffectsManager;
import Managers.SoundManager;
import screens.MenuScreen;

import javax.swing.JLabel;
import java.awt.Color;

public class Chapter2Cinematic extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chapter2Cinematic frame = new Chapter2Cinematic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creating events for animation/
	public TimerTask EndAnimation() {
		TimerTask timer = new TimerTask(){
			@Override
			public void run() {
				dispose();
				Levels.Chapter2.main();
			}		
		};
		return timer;
	}
	
	/**
	 * Create the frame.
	 */
	public Chapter2Cinematic() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		//setting the frame//
		Timer timer = new Timer();
		
		SoundManager.StopMusic();
		SoundManager.ReproduceMusicInLoop(SoundManager.Chapter2Theme);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Screen = new JLabel("");
		Screen.setBackground(new Color(0, 0, 0));
		Screen.setBounds(0, 0, 1530, 845);
		contentPane.add(Screen);
		EffectsManager.OpeningLeftToRightScreenEffect(contentPane);
		
		EffectsManager.SetImageLabel(Screen, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\Chapters\\Chapter 2\\Chapter2Card.png");
		
		//we end the animation at 10 seconds//
		timer.schedule(EndAnimation(), 10000);
	}
}