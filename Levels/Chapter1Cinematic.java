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

public class Chapter1Cinematic extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chapter1Cinematic frame = new Chapter1Cinematic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creating events for animation/
	
	public TimerTask SetCardForChapter1(JLabel Screen, String Image) {
		TimerTask timer = new TimerTask(){
			@Override
			public void run() {
				EffectsManager.SetImageLabel(Screen,Image);
			}		
		};
		return timer;
	}
	
	public TimerTask EndAnimation() {
		TimerTask timer = new TimerTask(){
			@Override
			public void run() {
				Levels.Chapter1.main();
				dispose();
			}		
		};
		return timer;
	}
	
	/**
	 * Create the frame.
	 */
	public Chapter1Cinematic() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		//setting the frame//
		Timer timer = new Timer();
		
		SoundManager.StopMusic();
		SoundManager.ReproduceMusicInLoop(SoundManager.Chapter1Theme);
		
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
			
		EffectsManager.PlayCinematic(Screen, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\Animations\\Chapter1IntroAnimation");
		
		//we end the animation at 40 seconds//
		timer.schedule(EndAnimation(), 40000);
	}
}
