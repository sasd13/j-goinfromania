package game.view;

import game.Game;
import game.menu.GameMenu;
import game.round.Round;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class GameView extends JFrame implements Observer {
	
	private static GameView instance = null;
	
	private GameMenu gameMenu;
	private ListRoundView listRoundView;
	private RoundView liveRoundView;
	
	private GameView() {
		super(Game.NAME);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.gameMenu = new GameMenu();
		setJMenuBar(this.gameMenu);
		
		this.listRoundView = new ListRoundView();
		
		this.liveRoundView = new RoundView();
	}
	
	public static synchronized GameView getInstance() {
		if (instance == null) {
			instance = new GameView();
		}
		
		return instance;
	}
	
	public ListRoundView getListRoundView() {
		return this.listRoundView;
	}
	
	public void setListRoundView(ListRoundView listRoundView) {
		this.listRoundView = listRoundView;
	}
	
	public RoundView getLiveRoundView() {
		return this.liveRoundView;
	}
	
	public void setLiveRoundView(RoundView liveRoundView) {
		this.liveRoundView = liveRoundView;
	}
	
	@Override
	public void update(Observable observable, Object arg) {		
		Game game = (Game) observable;
		
		this.listRoundView.update(game, arg);
		
		Round liveRound = game.getLiveRound();
		if (liveRound != null) {
			liveRound.addObserver(this.liveRoundView);
			this.liveRoundView.update(liveRound, arg);
		}
	}
	
	public void displayListRoundView() {		
		getContentPane().remove(this.liveRoundView);
		getContentPane().add(this.listRoundView, BorderLayout.CENTER);
		
		validate();
		repaint();
	}
	
	public void displayLiveRoundView() {
		getContentPane().remove(this.listRoundView);
		getContentPane().add(this.liveRoundView, BorderLayout.CENTER);
		
		validate();
		repaint();
	}
}
