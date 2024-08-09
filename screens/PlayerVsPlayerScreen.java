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
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

	


public class PlayerVsPlayerScreen extends JFrame {

	private JPanel contentPane;
	
	//Addint components for the funcioning of the game//
	Random random = new Random();
	int DiceNumber;
	int PlayerTurn = PLAYER1_TURN;
	static final int PLAYER1_TURN = 1;
	static final int PLAYER2_TURN = 2;
	boolean GameStatus = GAME_HAS_ENDED;
	static final boolean GAME_HAS_ENDED = true;
	static final boolean GAME_NOT_ENDED = false;
	String DiceNumberToDisplay;
	ArrayList<Integer> P1RowOne = new ArrayList<>();
	ArrayList<Integer> P1RowTwo = new ArrayList<>();
	ArrayList<Integer> P1RowThree = new ArrayList<>();
	ArrayList<Integer> P2RowOne = new ArrayList<>();
	ArrayList<Integer> P2RowTwo = new ArrayList<>();
	ArrayList<Integer> P2RowThree = new ArrayList<>();
	static final boolean IS_FULL = true;
	static final boolean IS_NOT_FULL= false;
	boolean RowOneSpaceOneP1LabelIsFull = false;
	boolean RowOneSpaceTwoP1LabelIsFull = false;
	boolean RowOneSpaceThreeP1LabelIsFull = false;
	boolean RowTwoSpaceOneP1LabelIsFull = false;
	boolean RowTwoSpaceTwoP1LabelIsFull = false;
	boolean RowTwoSpaceThreeP1LabelIsFull = false;
	boolean RowThreeSpaceOneP1LabelIsFull = false;
	boolean RowThreeSpaceTwoP1LabelIsFull = false;
	boolean RowThreeSpaceThreeP1LabelIsFull = false;
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
	static final String PLAYER_ONE_DEFEND = "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player1Defend.png";
	static final String PLAYER_TWO_DEFEND = "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player2Defend.png";
	static final String PLAYER_ONE_IDLE = "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer1.png";
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
	static String Player1Name;
	static String Player2Name;
	static String Winner;
	static String Loser;



	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerVsPlayerScreen frame = new PlayerVsPlayerScreen();
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
	
	private void VisuallUpdatesP1Rows(JLabel P1RowOneSpaceOneLabel, JLabel P1RowOneSpaceTwoLabel, JLabel P1RowOneSpaceThreeLabel,JLabel P1RowTwoSpaceOneLabel, JLabel P1RowTwoSpaceTwoLabel, JLabel P1RowTwoSpaceThreeLabel, JLabel P1RowThreeSpaceOneLabel, JLabel P1RowThreeSpaceTwoLabel, JLabel P1RowThreeSpaceThreeLabel) {
		P1RowOneSpaceOneLabel.setText(Integer.toString(P1RowOne.get(SPACE_ONE_IN_ROW)));
		P1RowOneSpaceTwoLabel.setText(Integer.toString(P1RowOne.get(SPACE_TWO_IN_ROW)));
		P1RowOneSpaceThreeLabel.setText(Integer.toString(P1RowOne.get(SPACE_THREE_IN_ROW)));
		P1RowTwoSpaceOneLabel.setText(Integer.toString(P1RowTwo.get(SPACE_ONE_IN_ROW)));
		P1RowTwoSpaceTwoLabel.setText(Integer.toString(P1RowTwo.get(SPACE_TWO_IN_ROW)));
		P1RowTwoSpaceThreeLabel.setText(Integer.toString(P1RowTwo.get(SPACE_THREE_IN_ROW)));
		P1RowThreeSpaceOneLabel.setText(Integer.toString(P1RowThree.get(SPACE_ONE_IN_ROW)));
		P1RowThreeSpaceTwoLabel.setText(Integer.toString(P1RowThree.get(SPACE_TWO_IN_ROW)));
		P1RowThreeSpaceThreeLabel.setText(Integer.toString(P1RowThree.get(SPACE_THREE_IN_ROW)));
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
	
	
	private boolean UpdateAvailabilityOfP1Chart(ArrayList<Integer> P1RowOne, ArrayList<Integer> P1RowTwo, ArrayList<Integer> P1RowThree) {
		if(P1RowOne.get(SPACE_ONE_IN_ROW) == 0) {
			RowOneSpaceOneP1LabelIsFull = IS_NOT_FULL;
		}else {
			RowOneSpaceOneP1LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P1RowOne.get(SPACE_TWO_IN_ROW) == 0) {
			RowOneSpaceTwoP1LabelIsFull = IS_NOT_FULL;
		}else {
			RowOneSpaceTwoP1LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P1RowOne.get(SPACE_THREE_IN_ROW) == 0) {
			RowOneSpaceThreeP1LabelIsFull = IS_NOT_FULL;
		}else {
			RowOneSpaceThreeP1LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P1RowTwo.get(SPACE_ONE_IN_ROW) == 0) {
			RowTwoSpaceOneP1LabelIsFull = IS_NOT_FULL;
		}else {
			RowTwoSpaceOneP1LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P1RowTwo.get(SPACE_TWO_IN_ROW) == 0) {
			RowTwoSpaceTwoP1LabelIsFull = IS_NOT_FULL;
		}else {
			RowTwoSpaceTwoP1LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		if(P1RowTwo.get(SPACE_THREE_IN_ROW) == 0) {
			RowTwoSpaceThreeP1LabelIsFull = IS_NOT_FULL;
		}else {
			RowTwoSpaceThreeP1LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P1RowThree.get(SPACE_ONE_IN_ROW) == 0) {
			RowThreeSpaceOneP1LabelIsFull = IS_NOT_FULL;
		}else {
			RowThreeSpaceOneP1LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P1RowThree.get(SPACE_TWO_IN_ROW) == 0) {
			RowThreeSpaceTwoP1LabelIsFull = IS_NOT_FULL;
		}else {
			RowThreeSpaceTwoP1LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(P1RowThree.get(SPACE_THREE_IN_ROW) == 0) {
			RowThreeSpaceThreeP1LabelIsFull = IS_NOT_FULL;
		}else {
			RowThreeSpaceThreeP1LabelIsFull = IS_FULL;
			GameIsDone = GameIsDone + 1;
		}
		
		if(GameIsDone == 9) {
			IsGameDone = true;
		}else {
			GameIsDone = 0;
		}
		
		return IsGameDone;
	}
	
	private boolean UpdateAvailabilityOfP2Chart(ArrayList<Integer> P1RowOne, ArrayList<Integer> P1RowTwo, ArrayList<Integer> P1RowThree) {
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
		UpdateAvailabilityOfP1Chart(P1RowOne, P1RowTwo, P1RowThree);
		UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
		
		if(UpdateAvailabilityOfP1Chart(P1RowOne, P1RowTwo, P1RowThree)) {	
			Winner = Player1Name;
			Loser = Player2Name;
			PlayerVSPlayerResultScreen.main();
			dispose();
		}
		
		if(UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree)) {
			Winner = Player2Name;
			Loser = Player1Name;
			PlayerVSPlayerResultScreen.main();
			dispose();
		}
		
		
	}

	/**
	 * Create the frame.
	 */
	public PlayerVsPlayerScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\BasicScreen\\Icon.png"));
		setBackground(new Color(0, 0, 0));
		setTitle("Player vs Player");
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
		SoundManager.StopMusic();
		SoundManager.ReproduceMusicInLoop(SoundManager.PlayerVsPlayerTheme);
		
		//setings the logic for the game//
		P1RowOne.add(0);
		P1RowOne.add(0);
		P1RowOne.add(0);
		P1RowTwo.add(0);
		P1RowTwo.add(0);
		P1RowTwo.add(0);
		P1RowThree.add(0);
		P1RowThree.add(0);
		P1RowThree.add(0);
		P2RowOne.add(0);
		P2RowOne.add(0);
		P2RowOne.add(0);
		P2RowTwo.add(0);
		P2RowTwo.add(0);
		P2RowTwo.add(0);
		P2RowThree.add(0);
		P2RowThree.add(0);
		P2RowThree.add(0);
		Player1Name = PlayerVsPlayerGameSetupScreen.GetPlayer1();
		Player2Name = PlayerVsPlayerGameSetupScreen.GetPlayer2();
		
		//adding components//
		JPanel BattleScenarioPanel = new JPanel();
		BattleScenarioPanel.setBackground(new Color(0, 0, 0));
		BattleScenarioPanel.setBorder(new LineBorder(new Color(255, 255, 0)));
		BattleScenarioPanel.setBounds(442, 0, 622, 835);
		contentPane.add(BattleScenarioPanel);
		BattleScenarioPanel.setLayout(null);
				
		JPanel Player1ChartPanel = new JPanel();
		Player1ChartPanel.setBackground(new Color(0, 0, 0));
		Player1ChartPanel.setBounds(10, 10, 602, 350);
		Player1ChartPanel.setBorder(new LineBorder(new Color(255, 255, 0)));
		BattleScenarioPanel.add(Player1ChartPanel);
		Player1ChartPanel.setLayout(null);
		
		JLabel RowOneSpaceOneP1Label = new JLabel("0");
		RowOneSpaceOneP1Label.setBackground(new Color(0, 0, 0));
		RowOneSpaceOneP1Label.setForeground(new Color(255, 255, 0));
		RowOneSpaceOneP1Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowOneSpaceOneP1Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowOneSpaceOneP1Label.setBounds(42, 224, 85, 85);
		Player1ChartPanel.add(RowOneSpaceOneP1Label);
		
		JLabel RowOneSpaceTwoP1Label = new JLabel("0");
		RowOneSpaceTwoP1Label.setBackground(new Color(0, 0, 0));
		RowOneSpaceTwoP1Label.setForeground(new Color(255, 255, 0));
		RowOneSpaceTwoP1Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowOneSpaceTwoP1Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowOneSpaceTwoP1Label.setBounds(42, 129, 85, 85);
		Player1ChartPanel.add(RowOneSpaceTwoP1Label);
		
		JLabel RowOneSpaceThreeP1Label = new JLabel("0");
		RowOneSpaceThreeP1Label.setToolTipText("");
		RowOneSpaceThreeP1Label.setBackground(new Color(0, 0, 0));
		RowOneSpaceThreeP1Label.setForeground(new Color(255, 255, 0));
		RowOneSpaceThreeP1Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowOneSpaceThreeP1Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowOneSpaceThreeP1Label.setBounds(42, 34, 85, 85);
		Player1ChartPanel.add(RowOneSpaceThreeP1Label);
		
		JLabel RowTwoSpaceOneP1Label = new JLabel("0");
		RowTwoSpaceOneP1Label.setForeground(new Color(255, 255, 0));
		RowTwoSpaceOneP1Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowTwoSpaceOneP1Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoSpaceOneP1Label.setBounds(254, 224, 85, 85);
		Player1ChartPanel.add(RowTwoSpaceOneP1Label);
		
		JLabel RowTwoSpaceTwoP1Label = new JLabel("0");
		RowTwoSpaceTwoP1Label.setForeground(new Color(255, 255, 0));
		RowTwoSpaceTwoP1Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowTwoSpaceTwoP1Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoSpaceTwoP1Label.setBounds(254, 129, 85, 85);
		Player1ChartPanel.add(RowTwoSpaceTwoP1Label);
		
		JLabel RowTwoSpaceThreeP1Label = new JLabel("0");
		RowTwoSpaceThreeP1Label.setBackground(new Color(255, 255, 0));
		RowTwoSpaceThreeP1Label.setForeground(new Color(255, 255, 0));
		RowTwoSpaceThreeP1Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowTwoSpaceThreeP1Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoSpaceThreeP1Label.setBounds(254, 34, 85, 85);
		Player1ChartPanel.add(RowTwoSpaceThreeP1Label);
		
		JLabel RowThreeSpaceOneP1Label = new JLabel("0");
		RowThreeSpaceOneP1Label.setForeground(new Color(255, 255, 0));
		RowThreeSpaceOneP1Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowThreeSpaceOneP1Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeSpaceOneP1Label.setBounds(468, 224, 85, 85);
		Player1ChartPanel.add(RowThreeSpaceOneP1Label);
		
		JLabel RowThreeSpaceTwoP1Label = new JLabel("0");
		RowThreeSpaceTwoP1Label.setForeground(new Color(255, 255, 0));
		RowThreeSpaceTwoP1Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowThreeSpaceTwoP1Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeSpaceTwoP1Label.setBounds(468, 129, 85, 85);
		Player1ChartPanel.add(RowThreeSpaceTwoP1Label);
		
		JLabel RowThreeSpaceThreeP1Label = new JLabel("0");
		RowThreeSpaceThreeP1Label.setForeground(new Color(255, 255, 0));
		RowThreeSpaceThreeP1Label.setFont(new Font("Tahoma", Font.PLAIN, 95));
		RowThreeSpaceThreeP1Label.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeSpaceThreeP1Label.setBounds(468, 34, 85, 85);
		Player1ChartPanel.add(RowThreeSpaceThreeP1Label);
		
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
		
		JLabel Player1Label = new JLabel("");
		Player1Label.setBounds(10, 10, 436, 275);
		EffectsManager.SetImageLabel(Player2Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer2.png");
		P1CharacterPanel.add(Player1Label);
		
		JLabel RowOneP1TotalNumberLabel = new JLabel("0");
		RowOneP1TotalNumberLabel.setBackground(new Color(0, 0, 0));
		RowOneP1TotalNumberLabel.setForeground(new Color(255, 255, 0));
		RowOneP1TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		RowOneP1TotalNumberLabel.setBounds(42, 10, 85, 21);
		Player1ChartPanel.add(RowOneP1TotalNumberLabel);
		
		JLabel RowTwoP1TotalNumberLabel = new JLabel("0");
		RowTwoP1TotalNumberLabel.setBackground(new Color(0, 0, 0));
		RowTwoP1TotalNumberLabel.setForeground(new Color(255, 255, 0));
		RowTwoP1TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowTwoP1TotalNumberLabel.setBounds(254, 10, 85, 21);
		Player1ChartPanel.add(RowTwoP1TotalNumberLabel);
		
		JLabel RowThreeP1TotalNumberLabel = new JLabel("0");
		RowThreeP1TotalNumberLabel.setForeground(new Color(255, 255, 0));
		RowThreeP1TotalNumberLabel.setBorder(new LineBorder(new Color(255, 255, 0)));
		RowThreeP1TotalNumberLabel.setBounds(468, 10, 85, 21);
		Player1ChartPanel.add(RowThreeP1TotalNumberLabel);
		
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
					
					if(PlayerTurn == PLAYER1_TURN) {
						P1DiceLabel.setText(DiceNumberToDisplay);					
						P1CharacterPanel.setBackground(Color.RED);
						P2CharacterPanel.setBackground(Color.BLACK);
					}				
					
					if(PlayerTurn == PLAYER2_TURN) {
						P2DiceLabel.setText(DiceNumberToDisplay);
						P2CharacterPanel.setBackground(Color.RED);
						P1CharacterPanel.setBackground(Color.BLACK);
					}				
					GameStatus = GAME_NOT_ENDED;
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
				if(GameStatus == GAME_NOT_ENDED && PlayerTurn == PLAYER1_TURN) {
					SoundManager.ReproduceSoundEffect(SoundManager.AttackEffect);
					IntroduceNumberToRow(RowOneSpaceOneP1LabelIsFull, P1RowOne, RowOneSpaceOneP1Label, PLAYER2_TURN, SPACE_ONE_IN_ROW);
					IntroduceNumberToRow(RowOneSpaceTwoP1LabelIsFull, P1RowOne, RowOneSpaceTwoP1Label, PLAYER2_TURN, SPACE_TWO_IN_ROW);
					IntroduceNumberToRow(RowOneSpaceThreeP1LabelIsFull, P1RowOne, RowOneSpaceThreeP1Label, PLAYER2_TURN, SPACE_THREE_IN_ROW);
					
					RowOneP1TotalNumber = CalculateRowScore(P1RowOne, RowOneP1TotalNumberLabel);
					
					RowAttackRow(P1RowOne, P2RowOne, Player2Label, PLAYER_TWO_DEFEND, PLAYER_TWO_IDLE);
					
					EffectsManager.AttackAnimation(Player1Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player1Attack.png"
															   ,  "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer1.png");
					
					RowOneP2TotalNumber = CalculateRowScore(P2RowOne, RowOneP2TotalNumberLabel);
					
					UpdateAvailabilityOfP1Chart(P1RowOne, P1RowTwo, P1RowThree);
					UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
					
					VisuallUpdatesP1Rows(RowOneSpaceOneP1Label, RowOneSpaceTwoP1Label, RowOneSpaceThreeP1Label, RowTwoSpaceOneP1Label, RowTwoSpaceTwoP1Label, RowTwoSpaceThreeP1Label, RowThreeSpaceOneP1Label, RowThreeSpaceTwoP1Label, RowThreeSpaceThreeP1Label);
					VisuallUpdatesP2Rows(RowOneSpaceOneP2Label, RowOneSpaceTwoP2Label, RowOneSpaceThreeP2Label, RowTwoSpaceOneP2Label, RowTwoSpaceTwoP2Label, RowTwoSpaceThreeP2Label, RowThreeSpaceOneP2Label, RowThreeSpaceTwoP2Label, RowThreeSpaceThreeP2Label);
				}
			}
		});
		SubmitNumberToRowOneP1Button.setBounds(42, 319, 85, 21);
		Player1ChartPanel.add(SubmitNumberToRowOneP1Button);
		
		JButton SubmitNumberToRowTwoP1Button = new JButton();
		SubmitNumberToRowTwoP1Button.setBackground(new Color(0, 0, 0));
		SubmitNumberToRowTwoP1Button.setForeground(new Color(255, 255, 0));
		SubmitNumberToRowTwoP1Button.setText("ATTACK");
		SubmitNumberToRowTwoP1Button.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		SubmitNumberToRowTwoP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameStatus == GAME_NOT_ENDED && PlayerTurn == PLAYER1_TURN) {
					SoundManager.ReproduceSoundEffect(SoundManager.AttackEffect);
					IntroduceNumberToRow(RowTwoSpaceOneP1LabelIsFull, P1RowTwo, RowTwoSpaceOneP1Label, PLAYER2_TURN, SPACE_ONE_IN_ROW); 
					IntroduceNumberToRow(RowTwoSpaceTwoP1LabelIsFull, P1RowTwo, RowTwoSpaceTwoP1Label, PLAYER2_TURN, SPACE_TWO_IN_ROW);
					IntroduceNumberToRow(RowTwoSpaceThreeP1LabelIsFull, P1RowTwo, RowTwoSpaceThreeP1Label, PLAYER2_TURN, SPACE_THREE_IN_ROW);
					
					RowTwoP1TotalNumber = CalculateRowScore(P1RowTwo, RowTwoP1TotalNumberLabel);
					
					RowAttackRow(P1RowTwo, P2RowTwo, Player2Label, PLAYER_TWO_DEFEND, PLAYER_TWO_IDLE);
					
					EffectsManager.AttackAnimation(Player1Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player1Attack.png"
							   ,  "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer1.png");
					
					RowTwoP2TotalNumber = CalculateRowScore(P2RowTwo, RowTwoP2TotalNumberLabel);
					
					UpdateAvailabilityOfP1Chart(P1RowOne, P1RowTwo, P1RowThree);
					UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
					
					VisuallUpdatesP1Rows(RowOneSpaceOneP1Label, RowOneSpaceTwoP1Label, RowOneSpaceThreeP1Label, RowTwoSpaceOneP1Label, RowTwoSpaceTwoP1Label, RowTwoSpaceThreeP1Label, RowThreeSpaceOneP1Label, RowThreeSpaceTwoP1Label, RowThreeSpaceThreeP1Label);
					VisuallUpdatesP2Rows(RowOneSpaceOneP2Label, RowOneSpaceTwoP2Label, RowOneSpaceThreeP2Label, RowTwoSpaceOneP2Label, RowTwoSpaceTwoP2Label, RowTwoSpaceThreeP2Label, RowThreeSpaceOneP2Label, RowThreeSpaceTwoP2Label, RowThreeSpaceThreeP2Label);
				}
			}
		});
		SubmitNumberToRowTwoP1Button.setBounds(254, 319, 85, 21);
		Player1ChartPanel.add(SubmitNumberToRowTwoP1Button);
		
		JButton SubmitNumberToRowThreeP1Button = new JButton();
		SubmitNumberToRowThreeP1Button.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		SubmitNumberToRowThreeP1Button.setText("ATTACK");
		SubmitNumberToRowThreeP1Button.setForeground(new Color(255, 255, 0));
		SubmitNumberToRowThreeP1Button.setBackground(new Color(0, 0, 0));
		SubmitNumberToRowThreeP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameStatus == GAME_NOT_ENDED && PlayerTurn == PLAYER1_TURN) {
					SoundManager.ReproduceSoundEffect(SoundManager.AttackEffect);
					IntroduceNumberToRow(RowThreeSpaceOneP1LabelIsFull, P1RowThree, RowThreeSpaceOneP1Label, PLAYER2_TURN, SPACE_ONE_IN_ROW);
					IntroduceNumberToRow(RowThreeSpaceTwoP1LabelIsFull, P1RowThree, RowThreeSpaceTwoP1Label, PLAYER2_TURN, SPACE_TWO_IN_ROW);
					IntroduceNumberToRow(RowThreeSpaceThreeP1LabelIsFull, P1RowThree, RowThreeSpaceThreeP1Label, PLAYER2_TURN, SPACE_THREE_IN_ROW);
					
					RowThreeP1TotalNumber = CalculateRowScore(P1RowThree, RowThreeP1TotalNumberLabel);
					
					RowAttackRow(P1RowThree, P2RowThree, Player2Label, PLAYER_TWO_DEFEND, PLAYER_TWO_IDLE);
					
					EffectsManager.AttackAnimation(Player1Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player1Attack.png"
							   ,  "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer1.png");
					
					RowThreeP2TotalNumber = CalculateRowScore(P2RowThree, RowThreeP2TotalNumberLabel);
					
					UpdateAvailabilityOfP1Chart(P1RowOne, P1RowTwo, P1RowThree);
					UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
					
					VisuallUpdatesP1Rows(RowOneSpaceOneP1Label, RowOneSpaceTwoP1Label, RowOneSpaceThreeP1Label, RowTwoSpaceOneP1Label, RowTwoSpaceTwoP1Label, RowTwoSpaceThreeP1Label, RowThreeSpaceOneP1Label, RowThreeSpaceTwoP1Label, RowThreeSpaceThreeP1Label);
					VisuallUpdatesP2Rows(RowOneSpaceOneP2Label, RowOneSpaceTwoP2Label, RowOneSpaceThreeP2Label, RowTwoSpaceOneP2Label, RowTwoSpaceTwoP2Label, RowTwoSpaceThreeP2Label, RowThreeSpaceOneP2Label, RowThreeSpaceTwoP2Label, RowThreeSpaceThreeP2Label);
				}
			}
		});
		SubmitNumberToRowThreeP1Button.setBounds(468, 319, 85, 21);
		Player1ChartPanel.add(SubmitNumberToRowThreeP1Button);
		
		JButton SubmitNumberToRowOneP2Button = new JButton();
		SubmitNumberToRowOneP2Button.setText("ATTACK");
		SubmitNumberToRowOneP2Button.setForeground(new Color(255, 255, 0));
		SubmitNumberToRowOneP2Button.setBackground(new Color(0, 0, 0));
		SubmitNumberToRowOneP2Button.setBorder(new LineBorder(new Color(255, 255, 0), 1, true));
		SubmitNumberToRowOneP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameStatus == GAME_NOT_ENDED && PlayerTurn == PLAYER2_TURN) {
					SoundManager.ReproduceSoundEffect(SoundManager.AttackEffect);
					IntroduceNumberToRow(RowOneSpaceOneP2LabelIsFull, P2RowOne, RowOneSpaceOneP2Label, PLAYER1_TURN, SPACE_ONE_IN_ROW);
					IntroduceNumberToRow(RowOneSpaceTwoP2LabelIsFull, P2RowOne, RowOneSpaceTwoP2Label, PLAYER1_TURN, SPACE_TWO_IN_ROW);
					IntroduceNumberToRow(RowOneSpaceThreeP2LabelIsFull, P2RowOne, RowOneSpaceThreeP2Label, PLAYER1_TURN, SPACE_THREE_IN_ROW);
					
					RowOneP2TotalNumber = CalculateRowScore(P2RowOne, RowOneP2TotalNumberLabel);
					
					RowAttackRow(P2RowOne, P1RowOne, Player1Label, PLAYER_ONE_DEFEND, PLAYER_ONE_IDLE);
					
					EffectsManager.AttackAnimation(Player2Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player2Attack.png"
							   ,  "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer2.png");
					
					RowOneP1TotalNumber = CalculateRowScore(P1RowOne, RowOneP1TotalNumberLabel);
					
					UpdateAvailabilityOfP1Chart(P1RowOne, P1RowTwo, P1RowThree);
					UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
					
					VisuallUpdatesP1Rows(RowOneSpaceOneP1Label, RowOneSpaceTwoP1Label, RowOneSpaceThreeP1Label, RowTwoSpaceOneP1Label, RowTwoSpaceTwoP1Label, RowTwoSpaceThreeP1Label, RowThreeSpaceOneP1Label, RowThreeSpaceTwoP1Label, RowThreeSpaceThreeP1Label);
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
					IntroduceNumberToRow(RowTwoSpaceOneP2LabelIsFull, P2RowTwo, RowTwoSpaceOneP2Label, PLAYER1_TURN, SPACE_ONE_IN_ROW);
					IntroduceNumberToRow(RowTwoSpaceTwoP2LabelIsFull, P2RowTwo, RowTwoSpaceTwoP2Label, PLAYER1_TURN, SPACE_TWO_IN_ROW);
					IntroduceNumberToRow(RowTwoSpaceThreeP2LabelIsFull, P2RowTwo, RowTwoSpaceThreeP2Label, PLAYER1_TURN, SPACE_THREE_IN_ROW);
					
					RowTwoP2TotalNumber = CalculateRowScore(P2RowTwo, RowTwoP2TotalNumberLabel);
					
					RowAttackRow(P2RowTwo, P1RowTwo, Player1Label, PLAYER_ONE_DEFEND, PLAYER_ONE_IDLE);
					
					EffectsManager.AttackAnimation(Player2Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player2Attack.png"
							   ,  "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer2.png");
					
					RowTwoP1TotalNumber = CalculateRowScore(P1RowTwo, RowTwoP1TotalNumberLabel);
					
					UpdateAvailabilityOfP1Chart(P1RowOne, P1RowTwo, P1RowThree);
					UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
					
					VisuallUpdatesP1Rows(RowOneSpaceOneP1Label, RowOneSpaceTwoP1Label, RowOneSpaceThreeP1Label, RowTwoSpaceOneP1Label, RowTwoSpaceTwoP1Label, RowTwoSpaceThreeP1Label, RowThreeSpaceOneP1Label, RowThreeSpaceTwoP1Label, RowThreeSpaceThreeP1Label);
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
					IntroduceNumberToRow(RowThreeSpaceOneP2LabelIsFull, P2RowThree, RowThreeSpaceOneP2Label, PLAYER1_TURN, SPACE_ONE_IN_ROW);
					IntroduceNumberToRow(RowThreeSpaceTwoP2LabelIsFull, P2RowThree, RowThreeSpaceThreeP2Label, PLAYER1_TURN, SPACE_TWO_IN_ROW);
					IntroduceNumberToRow(RowThreeSpaceThreeP2LabelIsFull, P2RowThree, RowThreeSpaceThreeP2Label, PLAYER1_TURN, SPACE_THREE_IN_ROW);
					
					RowThreeP2TotalNumber = CalculateRowScore(P2RowThree, RowThreeP2TotalNumberLabel);
					
					RowAttackRow(P2RowThree, P1RowThree, Player1Label, PLAYER_ONE_DEFEND, PLAYER_ONE_IDLE);
					
					EffectsManager.AttackAnimation(Player2Label, "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\Player2Attack.png"
							   ,  "C:\\Users\\El peligroso\\Desktop\\Matatena\\Resources\\VisualResources\\ScreenResources\\RealPlayerVsPlayer\\IdlePlayer2.png");
					
					RowThreeP1TotalNumber = CalculateRowScore(P1RowThree, RowThreeP1TotalNumberLabel);
					
					UpdateAvailabilityOfP1Chart(P1RowOne, P1RowTwo, P1RowThree);
					UpdateAvailabilityOfP2Chart(P2RowOne, P2RowTwo, P2RowThree);
					
					VisuallUpdatesP1Rows(RowOneSpaceOneP1Label, RowOneSpaceTwoP1Label, RowOneSpaceThreeP1Label, RowTwoSpaceOneP1Label, RowTwoSpaceTwoP1Label, RowTwoSpaceThreeP1Label, RowThreeSpaceOneP1Label, RowThreeSpaceTwoP1Label, RowThreeSpaceThreeP1Label);
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
