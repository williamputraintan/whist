import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class Player {
	private int score;
	private Hand hand;
	private String type;
	private Card selectedCard;
	private Random random;
	private final SelectionStrategyFactory selectionStrategyFactory = new SelectionStrategyFactory();
	private ArrayList<Card> cardsOnTable;

	
	

	

	
	public Player(String type, Random random) {
		this.score = 0;
		this.type=type;
		this.random=random;
	}
	public void addUsedCard(Card newCard) {
		cardsOnTable.add(newCard);
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
	
	public Card getCard(Suit trump) {
		SelectionStrategy selectionStrategy= selectionStrategyFactory.getSelectionStrategy(type);
		
		
		selectedCard= selectionStrategy.getSelected(); 
		
		
		
		return selectedCard;
	}
	
	public void addCards(Card card) {
		cardsOnTable.add(card);
	}
	
	public void resetCard() {
		cardsOnTable.clear();
	}
}
