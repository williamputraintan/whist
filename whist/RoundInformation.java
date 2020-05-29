import java.util.ArrayList;

import ch.aplu.jcardgame.*;


public class RoundInformation {
	private ArrayList<Card> cardUsed = new ArrayList<Card>();
	
	
	private ArrayList<Card> currentlyPlayed = new ArrayList<Card>();
	private int nbplayer;
	
	
	public RoundInformation(int nbplayer) {
		this.nbplayer = nbplayer;
	}
	
	
	
	public void addCurrentCard(Card currentCard) {
		currentlyPlayed.add(currentCard);
		
		if (currentlyPlayed.size()>= nbplayer) {
			cardUsed.addAll(currentlyPlayed);
			currentlyPlayed.clear();
		}
	}
	
	
	
	
	
	
}
