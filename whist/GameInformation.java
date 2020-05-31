import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;


public class GameInformation {
	private ArrayList<Card> cardUsed = new ArrayList<Card>();
	private ArrayList<Card> currentlyPlayed = new ArrayList<Card>();
	
//	private Hand currentlyPlayed = new Hand(null);
	private int nbplayer;
	private Random random;
	private Suit currentTrump;
	private Suit leadSuit;
	private Card winningCard;
	
	public GameInformation(int nbplayer, Random random) {
		this.nbplayer = nbplayer;
		this.random = random;
	}
	public Random getRandom() {
		return this.random;
	}
	
	public void setCurrentTrump(Suit trump) {
		this.currentTrump = trump;
	}
	public Suit getTrump() {
		return this.currentTrump;
	}
	public void setLeadSuit(Suit leadSuit) {
		this.leadSuit = leadSuit;
	}
	public Suit  getLeadSuit() {
		return this.leadSuit;
	}
	
	
	public void addCurrentCard(Card currentCard) {	
		currentlyPlayed.add(currentCard);
//		currentlyPlayed.insert(currentCard,false);
		
//		System.out.println(currentlyPlayed);

		if (currentlyPlayed.size()>= nbplayer) {
			cardUsed.addAll(currentlyPlayed);
			currentlyPlayed.clear();
			
		}
	}


	
	public ArrayList<Card> getCurrentlyPlayed(){
		return currentlyPlayed;
	}
	
	public void setWinningCard(Card card) {
		this.winningCard = card;
	}

	public Card getWinningCard() {
		return this.winningCard;
	}
	
	
}
