package Managers;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EffectsManager {
	
	//Delcaration of finals variables//
	public static final int WIDTH_OF_COMPUTER_SCREEN_AT_GROWING_RATE = 2000;
	public static final int HEIGHT_OF_COMPUTER_SCREEN_AT_GROWING_RATE = 3000;
	public static final int WIDTH_OF_COMPUTER_SCREEN = 1080;
	public static final int HEIGHT_OF_COMPUTER_SCREEN = 1920;
	public static final int START_NOW = 0;
	public static final int NORMAL_FRAMERATE = 16;
	public static final int FRAMERATE_ANIMATION = 90;
	public static final int GROWING_RATE = 5;
	public static final int ONE_SECONDS = 1000;
	public static final int ZERO_SECONDS = 0;
	
	//declaration of variables to modify//
	private static int ModificableWidth = 0;
	private static int ModificableHeight = 0;
	private static int Frame = 0;
	
	//Declaration of variables important for "hola" method"
	int RedColor = 0;
	int GreenColor = 0;
	int BlueColor = 0;
	
	//We create the code for the effects,but not the effects themselves//
	public static TimerTask OpeningLeftToRight(JPanel contentPane, Timer timerForAnimation) {
		TimerTask timer = new TimerTask(){
			@Override
			public void run() {
				contentPane.setBounds(0, 0, ModificableWidth, HEIGHT_OF_COMPUTER_SCREEN);
				ModificableWidth = ModificableWidth + GROWING_RATE;
				if(ModificableWidth >= WIDTH_OF_COMPUTER_SCREEN_AT_GROWING_RATE) {	
					timerForAnimation.cancel();
				}
			}		
		};
		return timer;
	}
	
	public static TimerTask SetImageOnLabel(JLabel label, String Image) {
		TimerTask timer = new TimerTask(){
			@Override
			public void run() {
				SetImageLabel(label,Image);
			}		
		};
		return timer;
	}
	
	///////////////////////////////timertask for cinematic animation///////////////////////////////////////////////////////////
	
	public static TimerTask playFrameCinematic(ArrayList<String> Animation, JLabel Screen) {
		TimerTask timer = new TimerTask(){
			@Override
			public void run() {
				if(Frame <= Animation.size()) {
					SetImageLabel(Screen,Animation.get(Frame));
					Frame = Frame + 1;
				}else {
					SetImageLabel(Screen,Animation.get(Frame));
				}
				
			}		
		};
		return timer;
	}
	
	//We create the effects and decide at what moment and how fast the go//
	public static void OpeningLeftToRightScreenEffect(JPanel contentPane){	
		Timer timer = new Timer();
		ModificableWidth = 0;
		timer.scheduleAtFixedRate(OpeningLeftToRight(contentPane, timer), START_NOW, NORMAL_FRAMERATE);
	}
	
	
	//This is for setting images on a label
	 public static void SetImageLabel(JLabel labelName, String ImageToUse){
		 ImageIcon image = new ImageIcon(ImageToUse);
		 Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		 labelName.setIcon(icon);
	 }
	 
	//This is for setting images on a Button
	public static void SetImageButton(JButton ButtonName, String ImageToUse){
		ImageIcon image = new ImageIcon(ImageToUse);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(ButtonName.getWidth(), ButtonName.getHeight(), Image.SCALE_DEFAULT));
		ButtonName.setIcon(icon);
	}
	
	////////////////////////////////////////cinematic animations/////////////////////////////////////////////////////////////////////////////////////
	
	static ArrayList<String> loadAnimation(ArrayList<String> animation, String SourceForAnimation) {
		File AnimationFolder = new File(SourceForAnimation);
		File[] fileAnimation = AnimationFolder.listFiles();
		
		for (File file:fileAnimation) {
			animation.add(file.getAbsolutePath());
		}	
		return animation;	
	}
	
	
		 
	//Animations for the games///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void AttackAnimation(JLabel label, String AttackImage, String IdleImage) {
		Timer timer = new Timer();
		timer.schedule(SetImageOnLabel(label, AttackImage), ZERO_SECONDS);
		timer.schedule(SetImageOnLabel(label, IdleImage), ONE_SECONDS);
	}
	
	public static void DefendingAnimations(JLabel label, String DefendImage, String IdleImage) {
		Timer timer = new Timer();
		timer.schedule(SetImageOnLabel(label, DefendImage), ZERO_SECONDS);
		timer.schedule(SetImageOnLabel(label, IdleImage), ONE_SECONDS);
	}
		 
	public static void PlayCinematic(JLabel Screen, String SourceForAnimation) {
		Timer timer = new Timer();
		ArrayList<String> Animation = new ArrayList<>();
		Animation = loadAnimation(Animation, SourceForAnimation);
		timer.scheduleAtFixedRate(playFrameCinematic(Animation, Screen), START_NOW, FRAMERATE_ANIMATION);
	}
	
}
