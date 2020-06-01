import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class Player {
	private int score;
	private Hand hand;
	private String type;
	private Card selectedCard;
	GameInformation gameInfo;
	

	private final SelectionStrategyFactory selectionStrategyFactory = new SelectionStrategyFactory();


	
	public Player(String type) {
		this.score = 0;
		this.type=type;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public Hand getHand() {
		return hand;
	}
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	public String getType() {
		return type;
	}
	public void getInfo(Whist whist) {
		gameInfo = whist.gameInfo;
	}
	
	
	public Card getCard(Suit trump, Whist whist) {
		SelectionStrategy selectionStrategy= selectionStrategyFactory.getSelectionStrategy(type);
		getInfo(whist);
		selectedCard = selectionStrategy.selectCard(hand, gameInfo);
		System.out.println("PLAYERRR: "+type);
		
		return selectedCard;
	}
	
}
