
import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class Player implements Observer {
	private int score;
	private Hand hand;
	private String type;
	private Card selectedCard;
	private final SelectionStrategyFactory selectionStrategyFactory = new SelectionStrategyFactory();

	private Random random;
	private ArrayList<Card> cardsOnTable = new ArrayList<Card>();
	private Card winningCard;
	private Suit leadSuit;
	private Suit currentTrump;
	
	
	public Player(String type, Random random) {
		this.score = 0;
		this.type=type;
		this.random = random;
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
	
	public Card getCard(){
		SelectionStrategy selectionStrategy= selectionStrategyFactory.getSelectionStrategy(this.type);
		
		selectedCard= selectionStrategy.selectCard(this);
//		System.out.println("cardsOnTable = " + cardsOnTable);
//		System.out.println("leadSuit = "+leadSuit);
//		System.out.println("winningCard = "+ winningCard);
//		System.out.println("cur trump = " + currentTrump);
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

	
}
