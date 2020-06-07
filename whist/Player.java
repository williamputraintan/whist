// Edited by Team101: William Putra Intan(955545), Franklin Aldo Darmansa (1025392), Patricia Angelica Budiman (1012861)
import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class Player implements Observer {
	
	//Declaring variables for player information
	private int score;
	private Hand hand;
	private String type;
	private Card selectedCard;
	private final SelectionStrategyFactory selectionStrategyFactory = new SelectionStrategyFactory();
	
	//Variables for information for the game round
	private Random random;
	private ArrayList<Card> cardsOnTable = new ArrayList<Card>();
	private Card winningCard;
	private Suit leadSuit;
	private Suit currentTrump;
	
	//Constructor for the player class
	public Player(String type, Random random) {
		this.score = 0;
		this.type=type;
		this.random = random;
	}

	/**
	 * @return selected card based on player strategy
	 * */
	public Card getCard(){
		
		//Strategy for the player
		SelectionStrategy selectionStrategy= selectionStrategyFactory.getSelectionStrategy(this.type);
		
		//run the strategy to select card
		selectedCard= selectionStrategy.selectCard(this);
		
		return selectedCard;
	}

	@Override
	public void addCurrentCard(Card currentCard) {
		cardsOnTable.add(currentCard);
		if (cardsOnTable.size() >= 4){
			cardsOnTable.clear();
		}
		
	}

	@Override
	public void tableInfo(Card winningCard, Suit leadSuit, Suit currentTrump) {
		this.winningCard = winningCard;
		this.leadSuit = leadSuit;
		this.currentTrump = currentTrump;
	}

	
	public Suit getCurrentTrump() {
		return currentTrump;
	}
	public Card getWinningCard() {
		return winningCard;
	}
	public Random getRandom() {
		return random;
	}
	public Suit getLeadSuit() {
		return leadSuit;
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
	public ArrayList<Card> getCardsOnTable() {
		return cardsOnTable;
	}
	
}
