package Levels;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Managers.EffectsManager;
import Managers.SoundManager;

import java.awt.AWTException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Robot;
import java.awt.Toolkit;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

	


public class Chapter2 extends JFrame {

	private JPanel contentPane;
	
	//Addint components for the funcioning of the game//
	Random random = new Random();
	int DiceNumber;
	int PlayerTurn = PLAYER2_TURN;
	static final int ENEMY_TURN = 1;
	static final int PLAYER2_TURN = 2;
	boolean GameStatus = GAME_HAS_ENDED;
	static final boolean GAME_HAS_ENDED = true;
	static final boolean GAME_NOT_ENDED = false;
	String DiceNumberToDisplay;
	ArrayList<Integer> EnemyRowOne = new ArrayList<>();
	ArrayList<Integer> EnemyRowTwo = new ArrayList<>();
	ArrayList<Integer> EnemyRowThree = new ArrayList<>();
	ArrayList<Integer> P2RowOne = new ArrayList<>();
	ArrayList<Integer> P2RowTwo = new ArrayList<>();
	ArrayList<Integer> P2RowThree = new ArrayList<>();
	static final boolean IS_FULL = true;
	static final boolean IS_NOT_FULL= false;
	boolean RowOneSpaceOneEnemyLabelIsFull = false;
	boolean RowOneSpaceTwoEnemyLabelIsFull = false;
	boolean RowOneSpaceThreeEnemyLabelIsFull = false;
	boolean RowTwoSpaceOneEnemyLabelIsFull = false;
	boolean RowTwoSpaceTwoEnemyLabelIsFull = false;
	boolean RowTwoSpaceThreeEnemyLabelIsFull = false;
	boolean RowThreeSpaceOneEnemyLabelIsFull = false;
	boolean RowThreeSpaceTwoEnemyLabelIsFull = false;
	boolean RowThreeSpaceThreeEnemyLabelIsFull = false;
	boolean RowOneSpaceOneP2LabelIsFull = false;
	boolean RowOneSpaceTwoP2LabelIsFull = false;
	boolean RowOneSpaceThreeP2LabelIsFull = false;
	boolean RowTwoSpaceOneP2LabelIsFull = false;
	boolean RowTwoSpaceTwoP2LabelIsFull = false;
	boolean RowTwoSpaceThreeP2LabelIsFull = false;
	boolean RowThreeSpaceOneP2LabelIsFull = false;
	boolean RowThreeSpaceTwoP2LabelIsFull = false;
	boolean RowThreeSpaceThreeP2LabelIsFull = false;
	static final int SPACE_ONE_IN_ROW = 0;
	static final int SPACE_TWO_IN_ROW = 1;
	static final int SPACE_THREE_IN_ROW = 2;
	static final String ENEMY_IDLE = "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\Chapters\\Chapter 2\\IdleEnemyChapter2.png";
	static final String ENEMY_DEFEND = "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\Chapters\\Chapter 2\\EnemyChapter2Defend.png";
	static final String ENEMY_ATTACK = "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\Chapters\\Chapter 2\\EnemyChapter2Attack.png";
	static final String PLAYER_TWO_DEFEND = "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player2Defend.png";
	static final String PLAYER_TWO_IDLE = "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer2.png";
	int RowOneP1TotalNumber;
	int RowTwoP1TotalNumber;
	int RowThreeP1TotalNumber;
	int RowOneP2TotalNumber;
	int RowTwoP2TotalNumber;
	int RowThreeP2TotalNumber;
	int P1TotalNumber;
	int P2TotalNumber;
	int SpaceOneTemporaryNumber;
	int SpaceTwoTemporaryNumber;
	int SpaceThreeTemporaryNumber;
	int NumberToComper;
	int GameIsDone;
	boolean IsGameDone;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chapter2 frame = new Chapter2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void RowAttackRow(ArrayList<Integer> AttackingRow, ArrayList<Integer> DefendingRow, JLabel label, String Defend, String Idle) {
		NumberToComper = AttackingRow.get(SPACE_ONE_IN_ROW);
		for(int i = 0; i <= 2; i++) {
			if(NumberToComper == DefendingRow.get(i) && DefendingRow.get(i) != 0) {
				DefendingRow.set(i,0);
				SoundManager.ReproduceSoundEffect(SoundManager.RowDeleteEffect);
				EffectsManager.DefendingAnimations(label, Defend, Idle);
			}
		}
		
		NumberToComper = AttackingRow.get(SPACE_TWO_IN_ROW);
		for(int i = 0; i <= 2; i++) {
			if(NumberToComper == DefendingRow.get(i) && DefendingRow.get(i) != 0) {
				DefendingRow.set(i,0);
				SoundManager.ReproduceSoundEffect(SoundManager.RowDeleteEffect);
				EffectsManager.DefendingAnimations(label, Defend, Idle);
			}
		}
		
		NumberToComper = AttackingRow.get(SPACE_THREE_IN_ROW);
		for(int i = 0; i <= 2; i++) {
			if(NumberToComper == DefendingRow.get(i) && DefendingRow.get(i) != 0) {
				DefendingRow.set(i,0);
				SoundManager.ReproduceSoundEffect(SoundManager.RowDeleteEffect);
				EffectsManager.DefendingAnimations(label, Defend, Idle);
			}
		}
	}
	
	private void VisuallUpdatesEnemyRows(JLabel EnemyRowOneSpaceOneLabel, JLabel EnemyRowOneSpaceTwoLabel, JLabel EnemyRowOneSpaceThreeLabel,JLabel EnemyRowTwoSpaceOneLabel, JLabel EnemyRowTwoSpaceTwoLabel, JLabel EnemyRowTwoSpaceThreeLabel, JLabel EnemyRowThreeSpaceOneLabel, JLabel EnemyRowThreeSpaceTwoLabel, JLabel EnemyRowThreeSpaceThreeLabel) {
		EnemyRowOneSpaceOneLabel.setText(Integer.toString(EnemyRowOne.get(SPACE_ONE_IN_ROW)));
		EnemyRowOneSpaceTwoLabel.setText(Integer.toString(EnemyRowOne.get(SPACE_TWO_IN_ROW)));
		EnemyRowOneSpaceThreeLabel.setText(Integer.toString(EnemyRowOne.get(SPACE_THREE_IN_ROW)));
		EnemyRowTwoSpaceOneLabel.setText(Integer.toString(EnemyRowTwo.get(SPACE_ONE_IN_ROW)));
		EnemyRowTwoSpaceTwoLabel.setText(Integer.toString(EnemyRowTwo.get(SPACE_TWO_IN_ROW)));
		EnemyRowTwoSpaceThreeLabel.setText(Integer.toString(EnemyRowTwo.get(SPACE_THREE_IN_ROW)));
		EnemyRowThreeSpaceOneLabel.setText(Integer.toString(EnemyRowThree.get(SPACE_ONE_IN_ROW)));
		EnemyRowThreeSpaceTwoLabel.setText(Integer.toString(EnemyRowThree.get(SPACE_TWO_IN_ROW)));
		EnemyRowThreeSpaceThreeLabel.setText(Integer.toString(EnemyRowThree.get(SPACE_THREE_IN_ROW)));
	}
	
	private void VisuallUpdatesP2Rows(JLabel P2RowOneSpaceOneLabel, JLabel P2RowOneSpaceTwoLabel, JLabel P2RowOneSpaceThreeLabel,JLabel P2RowTwoSpaceOneLabel, JLabel P2RowTwoSpaceTwoLabel, JLabel P2RowTwoSpaceThreeLabel, JLabel P2RowThreeSpaceOneLabel, JLabel P2RowThreeSpaceTwoLabel, JLabel P2RowThreeSpaceThreeLabel) {
		P2RowOneSpaceOneLabel.setText(Integer.toString(P2RowOne.get(SPACE_ONE_IN_ROW)));
		P2RowOneSpaceTwoLabel.setText(Integer.toString(P2RowOne.get(SPACE_TWO_IN_ROW)));
		P2RowOneSpaceThreeLabel.setText(Integer.toString(P2RowOne.get(SPACE_THREE_IN_ROW)));
		P2RowTwoSpaceOneLabel.setText(Integer.toString(P2RowTwo.get(SPACE_ONE_IN_ROW)));
		P2RowTwoSpaceTwoLabel.setText(Integer.toString(P2RowTwo.get(SPACE_TWO_IN_ROW)));
		P2RowTwoSpaceThreeLabel.setText(Integer.toString(P2RowTwo.get(SPACE_THREE_IN_ROW)));
		P2RowThreeSpaceOneLabel.setText(Integer.toString(P2RowThree.get(SPACE_ONE_IN_ROW)));
		P2RowThreeSpaceTwoLabel.setText(Integer.toString(P2RowThree.get(SPACE_TWO_IN_ROW)));
		P2RowThreeSpaceThreeLabel.setText(Integer.toString(P2RowThree.get(SPACE_THREE_IN_ROW)));
		
	}
	
	private int CalculateRowScore(ArrayList<Integer> row, JLabel PlayerRowVisualContainer) {
		int totalScore;
		
		if(row.get(SPACE_ONE_IN_ROW) == row.get(SPACE_TWO_IN_ROW) && row.get(SPACE_TWO_IN_ROW) == row.get(SPACE_THREE_IN_ROW)){
			totalScore = (row.get(SPACE_ONE_IN_ROW) + row.get(SPACE_TWO_IN_ROW) + row.get(SPACE_THREE_IN_ROW)) * 3;
			
		}else if(row.get(SPACE_ONE_IN_ROW) == row.get(SPACE_TWO_IN_ROW)) {
			totalScore = ((row.get(SPACE_ONE_IN_ROW) + row.get(SPACE_TWO_IN_ROW)) * 2) + row.get(SPACE_THREE_IN_ROW);
			
		}else if(row.get(SPACE_ONE_IN_ROW) == row.get(SPACE_THREE_IN_ROW)) {
			totalScore = ((row.get(SPACE_ONE_IN_ROW) + row.get(SPACE_THREE_IN_ROW)) * 2) + row.get(SPACE_TWO_IN_ROW);
			
		}else if(row.get(SPACE_TWO_IN_ROW) == row.get(SPACE_THREE_IN_ROW)) {
			totalScore = ((row.get(SPACE_TWO_IN_ROW) + row.get(SPACE_THREE_IN_ROW)) * 2) + row.get(SPACE_ONE_IN_ROW);
			
		}else {
			totalScore = row.get(SPACE_ONE_IN_ROW) + row.get(SPACE_TWO_IN_ROW) + row.get(SPACE_THREE_IN_ROW);
		}
		
		PlayerRowVisualContainer.setText(Integer.toString(totalScore));
		return totalScore;
	}
	
	
	private boolean UpdateAvailabilityOfEnemyChart(ArrayList<Integer> EnemyRowOne, ArrayList<Integer> EnemyRowTwo, ArrayList<Integer> EnemyRowThree) {
		if(EnemyRowOne.get(SPACE_ONE_IN_ROW) == 0) {
			RowOneSpaceOneEnemyLabelIsFull = IS_NOT_FULL;
		}else {
			RowOneSpaceOneEnemyLabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(EnemyRowOne.get(SPACE_TWO_IN_ROW) == 0) {
			RowOneSpaceTwoEnemyLabelIsFull = IS_NOT_FULL;
		}else {
			RowOneSpaceTwoEnemyLabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(EnemyRowOne.get(SPACE_THREE_IN_ROW) == 0) {
			RowOneSpaceThreeEnemyLabelIsFull = IS_NOT_FULL;
		}else {
			RowOneSpaceThreeEnemyLabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(EnemyRowTwo.get(SPACE_ONE_IN_ROW) == 0) {
			RowTwoSpaceOneEnemyLabelIsFull = IS_NOT_FULL;
		}else {
			RowTwoSpaceOneEnemyLabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(EnemyRowTwo.get(SPACE_TWO_IN_ROW) == 0) {
			RowTwoSpaceTwoEnemyLabelIsFull = IS_NOT_FULL;
		}else {
			RowTwoSpaceTwoEnemyLabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		if(EnemyRowTwo.get(SPACE_THREE_IN_ROW) == 0) {
			RowTwoSpaceThreeEnemyLabelIsFull = IS_NOT_FULL;
		}else {
			RowTwoSpaceThreeEnemyLabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(EnemyRowThree.get(SPACE_ONE_IN_ROW) == 0) {
			RowThreeSpaceOneEnemyLabelIsFull = IS_NOT_FULL;
		}else {
			RowThreeSpaceOneEnemyLabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(EnemyRowThree.get(SPACE_TWO_IN_ROW) == 0) {
			RowThreeSpaceTwoEnemyLabelIsFull = IS_NOT_FULL;
		}else {
			RowThreeSpaceTwoEnemyLabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(EnemyRowThree.get(SPACE_THREE_IN_ROW) == 0) {
			RowThreeSpaceThreeEnemyLabelIsFull = IS_NOT_FULL;
		}else {
			RowThreeSpaceThreeEnemyLabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(GameIsDone == 9) {
			IsGameDone = true;
		}else {
			GameIsDone = 0;
		}
		
		return IsGameDone;
	}
	
	private boolean UpdateAvailabilityOfP2Chart(ArrayList<Integer> EnemyRowOne, ArrayList<Integer> EnemyRowTwo, ArrayList<Integer> EnemyRowThree) {
		if(P2RowOne.get(SPACE_ONE_IN_ROW) == 0) {
			RowOneSpaceOneP2LabelIsFull = IS_NOT_FULL;
		}else {
			RowOneSpaceOneP2LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P2RowOne.get(SPACE_TWO_IN_ROW) == 0) {
			RowOneSpaceTwoP2LabelIsFull = IS_NOT_FULL;
		}else {
			RowOneSpaceTwoP2LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P2RowOne.get(SPACE_THREE_IN_ROW) == 0) {
			RowOneSpaceThreeP2LabelIsFull = IS_NOT_FULL;
		}else {
			RowOneSpaceThreeP2LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P2RowTwo.get(SPACE_ONE_IN_ROW) == 0) {
			RowTwoSpaceOneP2LabelIsFull = IS_NOT_FULL;
		}else {
			RowTwoSpaceOneP2LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P2RowTwo.get(SPACE_TWO_IN_ROW) == 0) {
			RowTwoSpaceTwoP2LabelIsFull = IS_NOT_FULL;
		}else {
			RowTwoSpaceTwoP2LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		if(P2RowTwo.get(SPACE_THREE_IN_ROW) == 0) {
			RowTwoSpaceThreeP2LabelIsFull = IS_NOT_FULL;
		}else {
			RowTwoSpaceThreeP2LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P2RowThree.get(SPACE_ONE_IN_ROW) == 0) {
			RowThreeSpaceOneP2LabelIsFull = IS_NOT_FULL;
		}else {
			RowThreeSpaceOneP2LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P2RowThree.get(SPACE_TWO_IN_ROW) == 0) {
			RowThreeSpaceTwoP2LabelIsFull = IS_NOT_FULL;
		}else {
			RowThreeSpaceTwoP2LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P2RowThree.get(SPACE_THREE_IN_ROW) == 0) {
			RowThreeSpaceThreeP2LabelIsFull = IS_NOT_FULL;
		}else {
			RowThreeSpaceThreeP2LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(GameIsDone == 9) {
			IsGameDone = true;
		}else {
			GameIsDone = 0;
			System.out.println();
			System.out.println(GameIsDone);
		}
		
		return IsGameDone;
	}
	
	private void IntroduceNumberToRow(boolean SpaceIsFull, ArrayList<Integer> Row, JLabel SpaceInRowLabel, int NextPlayerTurn, int SpaceInRow) {
		if(SpaceIsFull == IS_NOT_FULL && GameStatus == GAME_NOT_ENDED) {
			Row.set(SpaceInRow, DiceNumber);
			SpaceInRowLabel.setText(Integer.toString(Row.get(SpaceInRow)));
			SpaceIsFull = IS_FULL;
			PlayerTurn = NextPlayerTurn;
			GameStatus = GAME_HAS_ENDED;
		}
		
	}
	
	private void DecideWinner() {
		GameIsDone = 0;
		UpdateAvailabilityOfEnemyChart(EnemyRowOne, EnemyRowTwo, EnemyRowThree);
		UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
		
		if(UpdateAvailabilityOfEnemyChart(EnemyRowOne, EnemyRowTwo, EnemyRowThree) || UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree)) {	
			
			if(P1TotalNumber < P2TotalNumber) {
				dispose();
				Levels.YouWinScreen.main();
			}else {
				dispose();
				Levels.YouLoseScreen.main();
			}	
		}	
	}
	
	/**
	 * Create the frame.
	 */
	public Chapter2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		setBackground(new Color(0, 0, 0));
		setTitle("Player vs Average worker");
		setResizable(false);
		//setting the farme//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		EffectsManager.OpeningLeftToRightScreenEffect(contentPane);
		
		//adding the music//
		SoundManager.ReproduceMusicInLoop(SoundManager.Chapter2Theme);
		
		//setings the logic for the game//
		EnemyRowOne.add(0);
		EnemyRowOne.add(0);
		EnemyRowOne.add(0);
		EnemyRowTwo.add(0);
		EnemyRowTwo.add(0);
		EnemyRowTwo.add(0);
		EnemyRowThree.add(0);
		EnemyRowThree.add(0);
		EnemyRowThree.add(0);
		P2RowOne.add(0);
		P2RowOne.add(0);
		P2RowOne.add(0);
		P2RowTwo.add(0);
		P2RowTwo.add(0);
		P2RowTwo.add(0);
		P2RowThree.add(0);
		P2RowThree.add(0);
		P2RowThree.add(0);
		
		//adding components//
		JPanel BattleScenarioPanel = new JPanel();
		BattleScenarioPanel.setBackground(new Color(0, 0, 0));
		BattleScenarioPanel.setBorder(new LineBorder(new Color(255, 255, 0)));
		BattleScenarioPanel.setBounds(442, 0, 622, 835);
		contentPane.add(BattleScenarioPanel);
		BattleScenarioPanel.setLayout(null);
				
		JPanel EnemyChartPanel = new JPanel();
		EnemyChartPanel.setBackground(new Color(0, 0, 0));
		EnemyChartPanel.setBounds(10, 10, 602, 350);
		EnemyChartPanel.setBorder(new LineBorder(new Color(255, 255, 0)));
		BattleScenarioPanel.add(EnemyChartPanel);
		EnemyChartPanel.setLayout(null);
		
		JLabel RowOneSpaceOneEnemyLabel = new JLabel("0");
		RowOneSpaceOneEnemyLabel.setBackground(new Color(0, 0, 0));
		RowOneSpaceOneEnemyLabel.setForeground(new Color(255, 255, 0));
		RowOneSpaceOneEnemyLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowOneSpaceOneEnemyLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowOneSpaceOneEnemyLabel.setBounds(42, 224, 85, 85);
		EnemyChartPanel.add(RowOneSpaceOneEnemyLabel);
		
		JLabel RowOneSpaceTwoEnemyLabel = new JLabel("0");
		RowOneSpaceTwoEnemyLabel.setBackground(new Color(0, 0, 0));
		RowOneSpaceTwoEnemyLabel.setForeground(new Color(255, 255, 0));
		RowOneSpaceTwoEnemyLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowOneSpaceTwoEnemyLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowOneSpaceTwoEnemyLabel.setBounds(42, 129, 85, 85);
		EnemyChartPanel.add(RowOneSpaceTwoEnemyLabel);
		
		JLabel RowOneSpaceThreeEnemyLabel = new JLabel("0");
		RowOneSpaceThreeEnemyLabel.setToolTipText("");
		RowOneSpaceThreeEnemyLabel.setBackground(new Color(0, 0, 0));
		RowOneSpaceThreeEnemyLabel.setForeground(new Color(255, 255, 0));
		RowOneSpaceThreeEnemyLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowOneSpaceThreeEnemyLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowOneSpaceThreeEnemyLabel.setBounds(42, 34, 85, 85);
		EnemyChartPanel.add(RowOneSpaceThreeEnemyLabel);
		
		JLabel RowTwoSpaceOneEnemyLabel = new JLabel("0");
		RowTwoSpaceOneEnemyLabel.setForeground(new Color(255, 255, 0));
		RowTwoSpaceOneEnemyLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowTwoSpaceOneEnemyLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoSpaceOneEnemyLabel.setBounds(254, 224, 85, 85);
		EnemyChartPanel.add(RowTwoSpaceOneEnemyLabel);
		
		JLabel RowTwoSpaceTwoEnemyLabel = new JLabel("0");
		RowTwoSpaceTwoEnemyLabel.setForeground(new Color(255, 255, 0));
		RowTwoSpaceTwoEnemyLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowTwoSpaceTwoEnemyLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoSpaceTwoEnemyLabel.setBounds(254, 129, 85, 85);
		EnemyChartPanel.add(RowTwoSpaceTwoEnemyLabel);
		
		JLabel RowTwoSpaceThreeEnemyLabel = new JLabel("0");
		RowTwoSpaceThreeEnemyLabel.setBackground(new Color(255, 255, 0));
		RowTwoSpaceThreeEnemyLabel.setForeground(new Color(255, 255, 0));
		RowTwoSpaceThreeEnemyLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowTwoSpaceThreeEnemyLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoSpaceThreeEnemyLabel.setBounds(254, 34, 85, 85);
		EnemyChartPanel.add(RowTwoSpaceThreeEnemyLabel);
		
		JLabel RowThreeSpaceOneEnemyLabel = new JLabel("0");
		RowThreeSpaceOneEnemyLabel.setForeground(new Color(255, 255, 0));
		RowThreeSpaceOneEnemyLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowThreeSpaceOneEnemyLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeSpaceOneEnemyLabel.setBounds(468, 224, 85, 85);
		EnemyChartPanel.add(RowThreeSpaceOneEnemyLabel);
		
		JLabel RowThreeSpaceTwoEnemyLabel = new JLabel("0");
		RowThreeSpaceTwoEnemyLabel.setForeground(new Color(255, 255, 0));
		RowThreeSpaceTwoEnemyLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowThreeSpaceTwoEnemyLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeSpaceTwoEnemyLabel.setBounds(468, 129, 85, 85);
		EnemyChartPanel.add(RowThreeSpaceTwoEnemyLabel);
		
		JLabel RowThreeSpaceThreeEnemyLabel = new JLabel("0");
		RowThreeSpaceThreeEnemyLabel.setForeground(new Color(255, 255, 0));
		RowThreeSpaceThreeEnemyLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowThreeSpaceThreeEnemyLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeSpaceThreeEnemyLabel.setBounds(468, 34, 85, 85);
		EnemyChartPanel.add(RowThreeSpaceThreeEnemyLabel);
		
		JPanel Player2ChartPanel = new JPanel();
		Player2ChartPanel.setBackground(new Color(0, 0, 0));
		Player2ChartPanel.setLayout(null);
		Player2ChartPanel.setBorder(new LineBorder(new Color(255, 255, 0)));
		Player2ChartPanel.setBounds(10, 475, 602, 350);
		BattleScenarioPanel.add(Player2ChartPanel);
		
		JLabel RowOneSpaceOneP2Label = new JLabel("0");
		RowOneSpaceOneP2Label.setForeground(new Color(255, 255, 0));
		RowOneSpaceOneP2Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowOneSpaceOneP2Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowOneSpaceOneP2Label.setBounds(42, 41, 85, 85);
		Player2ChartPanel.add(RowOneSpaceOneP2Label);
		
		JLabel RowOneSpaceTwoP2Label = new JLabel("0");
		RowOneSpaceTwoP2Label.setForeground(new Color(255, 255, 0));
		RowOneSpaceTwoP2Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowOneSpaceTwoP2Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowOneSpaceTwoP2Label.setBounds(42, 136, 85, 85);
		Player2ChartPanel.add(RowOneSpaceTwoP2Label);
		
		JLabel RowOneSpaceThreeP2Label = new JLabel("0");
		RowOneSpaceThreeP2Label.setForeground(new Color(255, 255, 0));
		RowOneSpaceThreeP2Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowOneSpaceThreeP2Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowOneSpaceThreeP2Label.setBounds(42, 231, 85, 85);
		Player2ChartPanel.add(RowOneSpaceThreeP2Label);
		
		JLabel RowTwoSpaceOneP2Label = new JLabel("0");
		RowTwoSpaceOneP2Label.setForeground(new Color(255, 255, 0));
		RowTwoSpaceOneP2Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowTwoSpaceOneP2Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoSpaceOneP2Label.setBounds(254, 41, 85, 85);
		Player2ChartPanel.add(RowTwoSpaceOneP2Label);
		
		JLabel RowTwoSpaceTwoP2Label = new JLabel("0");
		RowTwoSpaceTwoP2Label.setForeground(new Color(255, 255, 0));
		RowTwoSpaceTwoP2Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowTwoSpaceTwoP2Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoSpaceTwoP2Label.setBounds(254, 136, 85, 85);
		Player2ChartPanel.add(RowTwoSpaceTwoP2Label);
		
		JLabel RowTwoSpaceThreeP2Label = new JLabel("0");
		RowTwoSpaceThreeP2Label.setForeground(new Color(255, 255, 0));
		RowTwoSpaceThreeP2Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowTwoSpaceThreeP2Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoSpaceThreeP2Label.setBounds(254, 231, 85, 85);
		Player2ChartPanel.add(RowTwoSpaceThreeP2Label);
		
		JLabel RowThreeSpaceOneP2Label = new JLabel("0");
		RowThreeSpaceOneP2Label.setForeground(new Color(255, 255, 0));
		RowThreeSpaceOneP2Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowThreeSpaceOneP2Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeSpaceOneP2Label.setBounds(468, 41, 85, 85);
		Player2ChartPanel.add(RowThreeSpaceOneP2Label);
		
		JLabel RowThreeSpaceTwoP2Label = new JLabel("0");
		RowThreeSpaceTwoP2Label.setForeground(new Color(255, 255, 0));
		RowThreeSpaceTwoP2Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowThreeSpaceTwoP2Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeSpaceTwoP2Label.setBounds(468, 136, 85, 85);
		Player2ChartPanel.add(RowThreeSpaceTwoP2Label);
		
		JLabel RowThreeSpaceThreeP2Label = new JLabel("0");
		RowThreeSpaceThreeP2Label.setForeground(new Color(255, 255, 0));
		RowThreeSpaceThreeP2Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowThreeSpaceThreeP2Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeSpaceThreeP2Label.setBounds(468, 231, 85, 85);
		Player2ChartPanel.add(RowThreeSpaceThreeP2Label);
		
		JPanel P2DicePanel = new JPanel();
		P2DicePanel.setBackground(new Color(0, 0, 0));
		P2DicePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		P2DicePanel.setBounds(10, 665, 408, 158);
		contentPane.add(P2DicePanel);
		
		JLabel P2DiceLabel = new JLabel("");
		P2DiceLabel.setBackground(new Color(0, 0, 0));
		P2DiceLabel.setForeground(new Color(255, 255, 0));
		P2DiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		P2DiceLabel.setPreferredSize(new Dimension(400, 150));
		P2DiceLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		P2DicePanel.add(P2DiceLabel);
		
		JPanel P2CharacterPanel = new JPanel();
		P2CharacterPanel.setBackground(new Color(0, 0, 0));
		P2CharacterPanel.setBorder(new LineBorder(new Color(255, 255, 0)));
		P2CharacterPanel.setBounds(10, 360, 408, 295);
		contentPane.add(P2CharacterPanel);
		P2CharacterPanel.setLayout(null);
		
		JLabel Player2Label = new JLabel("");
		Player2Label.setBounds(10, 10, 388, 275);
		EffectsManager.SetImageLabel(Player2Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer2.png");
		P2CharacterPanel.add(Player2Label);
		
		JPanel P1DicePanel = new JPanel();
		P1DicePanel.setBackground(new Color(0, 0, 0));
		P1DicePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		P1DicePanel.setBounds(1074, 23, 456, 158);
		contentPane.add(P1DicePanel);
		
		JLabel P1DiceLabel = new JLabel("");
		P1DiceLabel.setForeground(new Color(255, 255, 0));
		P1DiceLabel.setBackground(new Color(0, 0, 0));
		P1DiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
		P1DiceLabel.setPreferredSize(new Dimension(450, 150));
		P1DiceLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		P1DicePanel.add(P1DiceLabel);
		
		JPanel P1CharacterPanel = new JPanel();
		P1CharacterPanel.setBackground(new Color(0, 0, 0));
		P1CharacterPanel.setBorder(new LineBorder(new Color(255, 255, 0)));
		P1CharacterPanel.setBounds(1074, 193, 456, 295);
		contentPane.add(P1CharacterPanel);
		P1CharacterPanel.setLayout(null);
		
		JLabel EnemyLabel = new JLabel("");
		EnemyLabel.setBounds(10, 10, 436, 275);
		EffectsManager.SetImageLabel(Player2Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer2.png");
		P1CharacterPanel.add(EnemyLabel);
		
		JLabel RowOneP1TotalNumberLabel = new JLabel("0");
		RowOneP1TotalNumberLabel.setBackground(new Color(0, 0, 0));
		RowOneP1TotalNumberLabel.setForeground(new Color(255, 255, 0));
		RowOneP1TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		RowOneP1TotalNumberLabel.setBounds(42, 10, 85, 21);
		EnemyChartPanel.add(RowOneP1TotalNumberLabel);
		
		JLabel RowTwoP1TotalNumberLabel = new JLabel("0");
		RowTwoP1TotalNumberLabel.setBackground(new Color(0, 0, 0));
		RowTwoP1TotalNumberLabel.setForeground(new Color(255, 255, 0));
		RowTwoP1TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoP1TotalNumberLabel.setBounds(254, 10, 85, 21);
		EnemyChartPanel.add(RowTwoP1TotalNumberLabel);
		
		JLabel RowThreeP1TotalNumberLabel = new JLabel("0");
		RowThreeP1TotalNumberLabel.setForeground(new Color(255, 255, 0));
		RowThreeP1TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeP1TotalNumberLabel.setBounds(468, 10, 85, 21);
		EnemyChartPanel.add(RowThreeP1TotalNumberLabel);
		
		JLabel P1TotalNumberLabel = new JLabel("0");
		P1TotalNumberLabel.setForeground(new Color(255, 255, 0));
		P1TotalNumberLabel.setBackground(new Color(0, 0, 0));
		P1TotalNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 96));
		P1TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		P1TotalNumberLabel.setBounds(1074, 498, 456, 126);
		contentPane.add(P1TotalNumberLabel);
		
		JLabel RowOneP2TotalNumberLabel = new JLabel("0");
		RowOneP2TotalNumberLabel.setForeground(new Color(255, 255, 0));
		RowOneP2TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowOneP2TotalNumberLabel.setBounds(42, 319, 85, 21);
		Player2ChartPanel.add(RowOneP2TotalNumberLabel);
		
		JLabel RowTwoP2TotalNumberLabel = new JLabel("0");
		RowTwoP2TotalNumberLabel.setForeground(new Color(255, 255, 0));
		RowTwoP2TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoP2TotalNumberLabel.setBounds(254, 319, 85, 21);
		Player2ChartPanel.add(RowTwoP2TotalNumberLabel);
		
		JLabel RowThreeP2TotalNumberLabel = new JLabel("0");
		RowThreeP2TotalNumberLabel.setForeground(new Color(255, 255, 0));
		RowThreeP2TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeP2TotalNumberLabel.setBounds(468, 319, 85, 21);
		Player2ChartPanel.add(RowThreeP2TotalNumberLabel);
		
		JLabel P2TotalNumberLabel = new JLabel("0");
		P2TotalNumberLabel.setForeground(new Color(255, 255, 0));
		P2TotalNumberLabel.setBackground(new Color(0, 0, 0));
		P2TotalNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 96));
		P2TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		P2TotalNumberLabel.setBounds(10, 208, 408, 142);
		contentPane.add(P2TotalNumberLabel);
		
		JButton NextTurnButton = new JButton("Next Turn");
		NextTurnButton.setBorder(new LineBorder(new Color(255, 255, 0)));
		NextTurnButton.setBackground(new Color(0, 0, 0));
		NextTurnButton.setFont(new Font("Tahoma", Font.PLAIN, 99));
		NextTurnButton.setForeground(new Color(255, 255, 0));
		
		NextTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecideWinner();
				SoundManager.ReproduceSoundEffect(SoundManager.NextTurnEffect);
				if(GameStatus == GAME_HAS_ENDED) {
					DiceNumber = random.nextInt(6) + 1;	
					DiceNumberToDisplay = Integer.toString(DiceNumber);
					
					P1TotalNumber = RowOneP1TotalNumber + RowTwoP1TotalNumber + RowThreeP1TotalNumber;
					P1TotalNumberLabel.setText("Score: " + Integer.toString(P1TotalNumber));
					
					P2TotalNumber = RowOneP2TotalNumber + RowTwoP2TotalNumber + RowThreeP2TotalNumber;
					P2TotalNumberLabel.setText("Score: " + Integer.toString(P2TotalNumber));
					
					if(PlayerTurn == PLAYER2_TURN) {
						P2DiceLabel.setText(DiceNumberToDisplay);
						P2CharacterPanel.setBackground(Color.RED);
						P1CharacterPanel.setBackground(Color.BLACK);
					}				
					GameStatus = GAME_NOT_ENDED;
					
					if(PlayerTurn == ENEMY_TURN) {
						P1DiceLabel.setText(DiceNumberToDisplay);					
						P1CharacterPanel.setBackground(Color.RED);
						P2CharacterPanel.setBackground(Color.BLACK);
						
						int Desicion = 0;
						Random random = new Random();
						
						while(PlayerTurn == ENEMY_TURN) {
							Desicion = random.nextInt(3) + 1;
							GameStatus = GAME_NOT_ENDED;							
							
							if(Desicion == 1) {
								if(PlayerTurn == ENEMY_TURN) {
									SoundManager.ReproduceSoundEffect(SoundManager.AttackEffect);
									IntroduceNumberToRow(RowOneSpaceOneEnemyLabelIsFull, EnemyRowOne, RowOneSpaceOneEnemyLabel, PLAYER2_TURN, SPACE_ONE_IN_ROW);
									IntroduceNumberToRow(RowOneSpaceTwoEnemyLabelIsFull, EnemyRowOne, RowOneSpaceTwoEnemyLabel, PLAYER2_TURN, SPACE_TWO_IN_ROW);
									IntroduceNumberToRow(RowOneSpaceThreeEnemyLabelIsFull, EnemyRowOne, RowOneSpaceThreeEnemyLabel, PLAYER2_TURN, SPACE_THREE_IN_ROW);
									
									RowOneP1TotalNumber = CalculateRowScore(EnemyRowOne, RowOneP1TotalNumberLabel);
									
									RowAttackRow(EnemyRowOne, P2RowOne, Player2Label, PLAYER_TWO_DEFEND, PLAYER_TWO_IDLE);
									
									EffectsManager.AttackAnimation(EnemyLabel, ENEMY_ATTACK,  ENEMY_IDLE);
																			  
									
									RowOneP2TotalNumber = CalculateRowScore(P2RowOne, RowOneP2TotalNumberLabel);
									
									UpdateAvailabilityOfEnemyChart(EnemyRowOne, EnemyRowTwo, EnemyRowThree);
									UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
									
									VisuallUpdatesEnemyRows(RowOneSpaceOneEnemyLabel, RowOneSpaceTwoEnemyLabel, RowOneSpaceThreeEnemyLabel, RowTwoSpaceOneEnemyLabel, RowTwoSpaceTwoEnemyLabel, RowTwoSpaceThreeEnemyLabel, RowThreeSpaceOneEnemyLabel, RowThreeSpaceTwoEnemyLabel, RowThreeSpaceThreeEnemyLabel);
									VisuallUpdatesP2Rows(RowOneSpaceOneP2Label, RowOneSpaceTwoP2Label, RowOneSpaceThreeP2Label, RowTwoSpaceOneP2Label, RowTwoSpaceTwoP2Label, RowTwoSpaceThreeP2Label, RowThreeSpaceOneP2Label, RowThreeSpaceTwoP2Label, RowThreeSpaceThreeP2Label);
									
									PlayerTurn = PLAYER2_TURN;
								}
							}
							
							if(Desicion == 2) {
								if(PlayerTurn == ENEMY_TURN) {
									SoundManager.ReproduceSoundEffect(SoundManager.AttackEffect);
									IntroduceNumberToRow(RowTwoSpaceOneEnemyLabelIsFull, EnemyRowTwo, RowTwoSpaceOneEnemyLabel, PLAYER2_TURN, SPACE_ONE_IN_ROW); 
									IntroduceNumberToRow(RowTwoSpaceTwoEnemyLabelIsFull, EnemyRowTwo, RowTwoSpaceTwoEnemyLabel, PLAYER2_TURN, SPACE_TWO_IN_ROW);
									IntroduceNumberToRow(RowTwoSpaceThreeEnemyLabelIsFull, EnemyRowTwo, RowTwoSpaceThreeEnemyLabel, PLAYER2_TURN, SPACE_THREE_IN_ROW);
									
									RowTwoP1TotalNumber = CalculateRowScore(EnemyRowTwo, RowTwoP1TotalNumberLabel);
									
									RowAttackRow(EnemyRowTwo, P2RowTwo, Player2Label, PLAYER_TWO_DEFEND, PLAYER_TWO_IDLE);
									
									EffectsManager.AttackAnimation(EnemyLabel, ENEMY_ATTACK, ENEMY_IDLE);
									
									RowTwoP2TotalNumber = CalculateRowScore(P2RowTwo, RowTwoP2TotalNumberLabel);
									
									UpdateAvailabilityOfEnemyChart(EnemyRowOne, EnemyRowTwo, EnemyRowThree);
									UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
									
									VisuallUpdatesEnemyRows(RowOneSpaceOneEnemyLabel, RowOneSpaceTwoEnemyLabel, RowOneSpaceThreeEnemyLabel, RowTwoSpaceOneEnemyLabel, RowTwoSpaceTwoEnemyLabel, RowTwoSpaceThreeEnemyLabel, RowThreeSpaceOneEnemyLabel, RowThreeSpaceTwoEnemyLabel, RowThreeSpaceThreeEnemyLabel);
									VisuallUpdatesP2Rows(RowOneSpaceOneP2Label, RowOneSpaceTwoP2Label, RowOneSpaceThreeP2Label, RowTwoSpaceOneP2Label, RowTwoSpaceTwoP2Label, RowTwoSpaceThreeP2Label, RowThreeSpaceOneP2Label, RowThreeSpaceTwoP2Label, RowThreeSpaceThreeP2Label);
									
									PlayerTurn = PLAYER2_TURN;
								}
							}
							
							if(Desicion == 3) {
								if(PlayerTurn == ENEMY_TURN) {
									SoundManager.ReproduceSoundEffect(SoundManager.AttackEffect);
									IntroduceNumberToRow(RowThreeSpaceOneEnemyLabelIsFull, EnemyRowThree, RowThreeSpaceOneEnemyLabel, PLAYER2_TURN, SPACE_ONE_IN_ROW);
									IntroduceNumberToRow(RowThreeSpaceTwoEnemyLabelIsFull, EnemyRowThree, RowThreeSpaceTwoEnemyLabel, PLAYER2_TURN, SPACE_TWO_IN_ROW);
									IntroduceNumberToRow(RowThreeSpaceThreeEnemyLabelIsFull, EnemyRowThree, RowThreeSpaceThreeEnemyLabel, PLAYER2_TURN, SPACE_THREE_IN_ROW);
									
									RowThreeP1TotalNumber = CalculateRowScore(EnemyRowThree, RowThreeP1TotalNumberLabel);
									
									RowAttackRow(EnemyRowThree, P2RowThree, Player2Label, PLAYER_TWO_DEFEND, PLAYER_TWO_IDLE);
									
									EffectsManager.AttackAnimation(EnemyLabel, ENEMY_ATTACK, ENEMY_IDLE);
									
									RowThreeP2TotalNumber = CalculateRowScore(P2RowThree, RowThreeP2TotalNumberLabel);
									
									UpdateAvailabilityOfEnemyChart(EnemyRowOne, EnemyRowTwo, EnemyRowThree);
									UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
									
									VisuallUpdatesEnemyRows(RowOneSpaceOneEnemyLabel, RowOneSpaceTwoEnemyLabel, RowOneSpaceThreeEnemyLabel, RowTwoSpaceOneEnemyLabel, RowTwoSpaceTwoEnemyLabel, RowTwoSpaceThreeEnemyLabel, RowThreeSpaceOneEnemyLabel, RowThreeSpaceTwoEnemyLabel, RowThreeSpaceThreeEnemyLabel);
									VisuallUpdatesP2Rows(RowOneSpaceOneP2Label, RowOneSpaceTwoP2Label, RowOneSpaceThreeP2Label, RowTwoSpaceOneP2Label, RowTwoSpaceTwoP2Label, RowTwoSpaceThreeP2Label, RowThreeSpaceOneP2Label, RowThreeSpaceTwoP2Label, RowThreeSpaceThreeP2Label);
									
									PlayerTurn = PLAYER2_TURN;
								}
							}
						}
					}				
				}
			}
		});
		NextTurnButton.setBounds(42, 370, 535, 95);
		BattleScenarioPanel.add(NextTurnButton);
		
		JButton SubmitNumberToRowOneP1Button = new JButton();
		SubmitNumberToRowOneP1Button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SubmitNumberToRowOneP1Button.setText("ATTACK");
			}
			public void mouseExited(MouseEvent e) {
				SubmitNumberToRowOneP1Button.setText("ATTACK");
			}
		});
		SubmitNumberToRowOneP1Button.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		SubmitNumberToRowOneP1Button.setText("ATTACK");
		SubmitNumberToRowOneP1Button.setForeground(new Color(255, 255, 0));
		SubmitNumberToRowOneP1Button.setBackground(new Color(0, 0, 0));
		SubmitNumberToRowOneP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameStatus == GAME_NOT_ENDED && PlayerTurn == ENEMY_TURN) {
				}
			}
		});
		SubmitNumberToRowOneP1Button.setBounds(42, 319, 85, 21);
		EnemyChartPanel.add(SubmitNumberToRowOneP1Button);
		
		JButton SubmitNumberToRowTwoP1Button = new JButton();
		SubmitNumberToRowTwoP1Button.setBackground(new Color(0, 0, 0));
		SubmitNumberToRowTwoP1Button.setForeground(new Color(255, 255, 0));
		SubmitNumberToRowTwoP1Button.setText("ATTACK");
		SubmitNumberToRowTwoP1Button.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		SubmitNumberToRowTwoP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SubmitNumberToRowTwoP1Button.setBounds(254, 319, 85, 21);
		EnemyChartPanel.add(SubmitNumberToRowTwoP1Button);
		
		JButton SubmitNumberToRowThreeP1Button = new JButton();
		SubmitNumberToRowThreeP1Button.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		SubmitNumberToRowThreeP1Button.setText("ATTACK");
		SubmitNumberToRowThreeP1Button.setForeground(new Color(255, 255, 0));
		SubmitNumberToRowThreeP1Button.setBackground(new Color(0, 0, 0));
		SubmitNumberToRowThreeP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SubmitNumberToRowThreeP1Button.setBounds(468, 319, 85, 21);
		EnemyChartPanel.add(SubmitNumberToRowThreeP1Button);
		
		JButton SubmitNumberToRowOneP2Button = new JButton();
		SubmitNumberToRowOneP2Button.setText("ATTACK");
		SubmitNumberToRowOneP2Button.setForeground(new Color(255, 255, 0));
		SubmitNumberToRowOneP2Button.setBackground(new Color(0, 0, 0));
		SubmitNumberToRowOneP2Button.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		SubmitNumberToRowOneP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameStatus == GAME_NOT_ENDED && PlayerTurn == PLAYER2_TURN) {
					SoundManager.ReproduceSoundEffect(SoundManager.AttackEffect);
					IntroduceNumberToRow(RowOneSpaceOneP2LabelIsFull, P2RowOne, RowOneSpaceOneP2Label, ENEMY_TURN, SPACE_ONE_IN_ROW);
					IntroduceNumberToRow(RowOneSpaceTwoP2LabelIsFull, P2RowOne, RowOneSpaceTwoP2Label, ENEMY_TURN, SPACE_TWO_IN_ROW);
					IntroduceNumberToRow(RowOneSpaceThreeP2LabelIsFull, P2RowOne, RowOneSpaceThreeP2Label, ENEMY_TURN, SPACE_THREE_IN_ROW);
					
					RowOneP2TotalNumber = CalculateRowScore(P2RowOne, RowOneP2TotalNumberLabel);
					
					RowAttackRow(P2RowOne, EnemyRowOne, EnemyLabel, ENEMY_DEFEND, ENEMY_IDLE);
					
					EffectsManager.AttackAnimation(Player2Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player2Attack.png"
							   ,  "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer2.png");
					
					RowOneP1TotalNumber = CalculateRowScore(EnemyRowOne, RowOneP1TotalNumberLabel);
					
					UpdateAvailabilityOfEnemyChart(EnemyRowOne, EnemyRowTwo, EnemyRowThree);
					UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
					
					VisuallUpdatesEnemyRows(RowOneSpaceOneEnemyLabel, RowOneSpaceTwoEnemyLabel, RowOneSpaceThreeEnemyLabel, RowTwoSpaceOneEnemyLabel, RowTwoSpaceTwoEnemyLabel, RowTwoSpaceThreeEnemyLabel, RowThreeSpaceOneEnemyLabel, RowThreeSpaceTwoEnemyLabel, RowThreeSpaceThreeEnemyLabel);
					VisuallUpdatesP2Rows(RowOneSpaceOneP2Label, RowOneSpaceTwoP2Label, RowOneSpaceThreeP2Label, RowTwoSpaceOneP2Label, RowTwoSpaceTwoP2Label, RowTwoSpaceThreeP2Label, RowThreeSpaceOneP2Label, RowThreeSpaceTwoP2Label, RowThreeSpaceThreeP2Label);
				}
			}
		});
		SubmitNumberToRowOneP2Button.setBounds(42, 10, 85, 21);
		Player2ChartPanel.add(SubmitNumberToRowOneP2Button);
		
		JButton SubmitNumberToRowTwoP2Button = new JButton();
		SubmitNumberToRowTwoP2Button.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		SubmitNumberToRowTwoP2Button.setForeground(new Color(255, 255, 0));
		SubmitNumberToRowTwoP2Button.setText("ATTACK");
		SubmitNumberToRowTwoP2Button.setBackground(new Color(0, 0, 0));
		SubmitNumberToRowTwoP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameStatus == GAME_NOT_ENDED && PlayerTurn == PLAYER2_TURN) {
					SoundManager.ReproduceSoundEffect(SoundManager.AttackEffect);
					IntroduceNumberToRow(RowTwoSpaceOneP2LabelIsFull, P2RowTwo, RowTwoSpaceOneP2Label, ENEMY_TURN, SPACE_ONE_IN_ROW);
					IntroduceNumberToRow(RowTwoSpaceTwoP2LabelIsFull, P2RowTwo, RowTwoSpaceTwoP2Label, ENEMY_TURN, SPACE_TWO_IN_ROW);
					IntroduceNumberToRow(RowTwoSpaceThreeP2LabelIsFull, P2RowTwo, RowTwoSpaceThreeP2Label, ENEMY_TURN, SPACE_THREE_IN_ROW);
					
					RowTwoP2TotalNumber = CalculateRowScore(P2RowTwo, RowTwoP2TotalNumberLabel);
					
					RowAttackRow(P2RowTwo, EnemyRowTwo, EnemyLabel, ENEMY_DEFEND, ENEMY_IDLE);
					
					EffectsManager.AttackAnimation(Player2Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player2Attack.png"
							   ,  "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer2.png");
					
					RowTwoP1TotalNumber = CalculateRowScore(EnemyRowTwo, RowTwoP1TotalNumberLabel);
					
					UpdateAvailabilityOfEnemyChart(EnemyRowOne, EnemyRowTwo, EnemyRowThree);
					UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
					
					VisuallUpdatesEnemyRows(RowOneSpaceOneEnemyLabel, RowOneSpaceTwoEnemyLabel, RowOneSpaceThreeEnemyLabel, RowTwoSpaceOneEnemyLabel, RowTwoSpaceTwoEnemyLabel, RowTwoSpaceThreeEnemyLabel, RowThreeSpaceOneEnemyLabel, RowThreeSpaceTwoEnemyLabel, RowThreeSpaceThreeEnemyLabel);
					VisuallUpdatesP2Rows(RowOneSpaceOneP2Label, RowOneSpaceTwoP2Label, RowOneSpaceThreeP2Label, RowTwoSpaceOneP2Label, RowTwoSpaceTwoP2Label, RowTwoSpaceThreeP2Label, RowThreeSpaceOneP2Label, RowThreeSpaceTwoP2Label, RowThreeSpaceThreeP2Label);
				}
			}
		});
		SubmitNumberToRowTwoP2Button.setBounds(254, 10, 85, 21);
		Player2ChartPanel.add(SubmitNumberToRowTwoP2Button);
		
		JButton SubmitNumberToRowThreeP2Button = new JButton();
		SubmitNumberToRowThreeP2Button.setText("ATTACK");
		SubmitNumberToRowThreeP2Button.setForeground(new Color(255, 255, 0));
		SubmitNumberToRowThreeP2Button.setBackground(new Color(0, 0, 0));
		SubmitNumberToRowThreeP2Button.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		SubmitNumberToRowThreeP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameStatus == GAME_NOT_ENDED && PlayerTurn == PLAYER2_TURN) {
					SoundManager.ReproduceSoundEffect(SoundManager.AttackEffect);
					IntroduceNumberToRow(RowThreeSpaceOneP2LabelIsFull, P2RowThree, RowThreeSpaceOneP2Label, ENEMY_TURN, SPACE_ONE_IN_ROW);
					IntroduceNumberToRow(RowThreeSpaceTwoP2LabelIsFull, P2RowThree, RowThreeSpaceThreeP2Label, ENEMY_TURN, SPACE_TWO_IN_ROW);
					IntroduceNumberToRow(RowThreeSpaceThreeP2LabelIsFull, P2RowThree, RowThreeSpaceThreeP2Label, ENEMY_TURN, SPACE_THREE_IN_ROW);
					
					RowThreeP2TotalNumber = CalculateRowScore(P2RowThree, RowThreeP2TotalNumberLabel);
					
					RowAttackRow(P2RowThree, EnemyRowThree, EnemyLabel, ENEMY_DEFEND, ENEMY_IDLE);
					
					EffectsManager.AttackAnimation(Player2Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player2Attack.png"
							   ,  "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer2.png");
					
					RowThreeP1TotalNumber = CalculateRowScore(EnemyRowThree, RowThreeP1TotalNumberLabel);
					
					UpdateAvailabilityOfEnemyChart(EnemyRowOne, EnemyRowTwo, EnemyRowThree);
					UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
					
					VisuallUpdatesEnemyRows(RowOneSpaceOneEnemyLabel, RowOneSpaceTwoEnemyLabel, RowOneSpaceThreeEnemyLabel, RowTwoSpaceOneEnemyLabel, RowTwoSpaceTwoEnemyLabel, RowTwoSpaceThreeEnemyLabel, RowThreeSpaceOneEnemyLabel, RowThreeSpaceTwoEnemyLabel, RowThreeSpaceThreeEnemyLabel);
					VisuallUpdatesP2Rows(RowOneSpaceOneP2Label, RowOneSpaceTwoP2Label, RowOneSpaceThreeP2Label, RowTwoSpaceOneP2Label, RowTwoSpaceTwoP2Label, RowTwoSpaceThreeP2Label, RowThreeSpaceOneP2Label, RowThreeSpaceTwoP2Label, RowThreeSpaceThreeP2Label);
					
				}
			}
		});
		SubmitNumberToRowThreeP2Button.setBounds(468, 10, 85, 21);
		Player2ChartPanel.add(SubmitNumberToRowThreeP2Button);
		
		JLabel BackgroundLabel = new JLabel("");
		BackgroundLabel.setBackground(new Color(0, 0, 0));
		BackgroundLabel.setBounds(0, 0, 1540, 845);
		EffectsManager.SetImageLabel(BackgroundLabel, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Rectangle.png");
		contentPane.add(BackgroundLabel);
		
	}
}