import java.util.Random;

import ch.aplu.jcardgame.*;

public class Player {
	private int score;
	private Hand hand;
	private String type;
	private Card selectedCard;
	private Random random;

	
	public Player(String type, Random random) {
		this.score = 0;
		this.type=type;
		this.random=random;
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
		if(type.equals("random")) {
			selectedCard= new RandomStrategy().selectCard(hand, random, trump);
		}else if(type.equals("legal")) {
			selectedCard= new LegalStrategy().selectCard(hand, random, trump);
		}else if(type.equals("smart")) {
			selectedCard= new SmartStrategy().selectCard(hand, random, trump);
		}
		return selectedCard;
	}


	
	
	
}