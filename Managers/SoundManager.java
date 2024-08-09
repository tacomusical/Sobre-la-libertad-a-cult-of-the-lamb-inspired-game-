package Managers;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * This CLass contains files of the root of every single sound and music in the project
 * when we reproduce something,we need as a argument a file type,thats why all sound and music is public,so it can be easily acces
 * we made all methods static so we can use them whenever we want in every screen without neddind to declare the object in say screen
 * when we reproduce something we firts use the stop method, followed by the reproduce method,this is absolutely vital,if not,the program will crash
 */

public class SoundManager {
	
	//Declaration of music//
	public static File MainMenuTheme = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\MusicResources\\MainMenuTheme.wav");
	public static File PlayerVsPlayerTheme = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\MusicResources\\PlayerVsPlayerTheme.wav");
	public static File Chapter1Theme = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\MusicResources\\Chapter1Theme.wav");
	public static File Chapter2Theme = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\MusicResources\\Chapter2Theme.wav");
	public static File Chapter3Theme = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\MusicResources\\Chapter3Theme.wav");
	public static File Chapter4Theme = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\MusicResources\\Chapter4Theme.wav");
	public static File Chapter5Theme = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\MusicResources\\Chapter5Theme.wav");
	
	//Declaration of Sound Effects//
	public static File ButtonSoundEffect = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\SoundEffectsResources\\ButtonSound.wav");
	public static File ButtonSoundEffectMouseEvent = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\SoundEffectsResources\\ButtonSoundMouseEvent.wav");
	public static File AttackEffect = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\SoundEffectsResources\\Attack.wav");
	public static File NextTurnEffect = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\SoundEffectsResources\\NextTurn.wav");
	public static File RowDeleteEffect = new File("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\AudioResources\\SoundEffectsResources\\RowDelete.wav");
	
	//Declaration of clip and audioStream for music and sound effetcs//
	static Clip clipForMusic;
	static Clip clipForSoundEffect;
	static AudioInputStream AudioStreamMusic;
	static AudioInputStream AudioStreamSoundEffect;
	static boolean IsMusicPlaying = false;
	
	
	//Methods for music//
	public static void ReproduceMusicInLoop(File MusicToLoop){
		if(IsMusicPlaying == false){
			try {	
				AudioStreamMusic = AudioSystem.getAudioInputStream(MusicToLoop);
				clipForMusic = AudioSystem.getClip();	
				clipForMusic.open(AudioStreamMusic);
				clipForMusic.loop(1000);		
				IsMusicPlaying = true;
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void StopMusic() {
		clipForMusic.stop();
		clipForMusic.close();
		IsMusicPlaying = false;
	}
	
	//Methods for the soundEffects//
	public static void ReproduceSoundEffect(File SoundEffectToReproduce) {
		try {
			AudioStreamSoundEffect = AudioSystem.getAudioInputStream(SoundEffectToReproduce);
			clipForSoundEffect = AudioSystem.getClip();
			clipForSoundEffect.open(AudioStreamSoundEffect);
			clipForSoundEffect.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public static void StopSoundEffect() {
		clipForSoundEffect.stop();
		clipForSoundEffect.close();
	}
	
}
