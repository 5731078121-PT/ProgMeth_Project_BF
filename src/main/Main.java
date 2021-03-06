package main;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

import logic.GameLogic;
import logic.PlayerStatus;
import render.GameBegin;
import render.GameScreen;
import render.GameTitle;
import render.GameWindow;
import render.RenderableHolder;



public class Main {
	public static JFrame frame;
	public static GameLogic gameLogic;
	public static GameScreen gameScreen;
	public static GameTitle gameTitle;
	public static GameWindow gameWindow;
	public static GameBegin gameBegin;
	public static JComponent nextScene = null;
	public static boolean isStart;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gameTitle = new GameTitle();
		gameWindow = new GameWindow(gameTitle);
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}
			gameWindow.getCurrentScene().repaint();
			if(gameWindow.getCurrentScene() instanceof GameScreen){
				 gameLogic.logicUpdate();
			}
			if(nextScene != null){
				
				gameWindow.switchScene(nextScene);
				nextScene = null;
			}
			
		}
		
	}
	
	
	public static void titleScene(){

		nextScene = gameTitle;
		
	}

	public static void runGame(){
		if(gameScreen != null){
			gameScreen.removeAll();
		}
//		gameLogic = null;
		gameScreen = new GameScreen();
		gameLogic = new GameLogic();
		GameLogic.playerStatus = new PlayerStatus();
		RenderableHolder.getInstance().add(GameLogic.playerStatus);
		nextScene = gameScreen;
		
	}
	
	public static void startGame(){
		gameBegin = new GameBegin();
		nextScene = gameBegin;
	}
	
}