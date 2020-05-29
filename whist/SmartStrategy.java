import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class SmartStrategy implements SelectionStrategy{

	private ArrayList<Card> trumpCards;
	private int index;


	
	
	public Card selectCard(Hand cards,Random random, Suit trump, ArrayList<Card> cardsOnTable) {
		Card selectedCard;
		
		if(cards.getNumberOfCardsWithSuit(trump)>0) {
			trumpCards = cards.getCardsWithSuit(trump);
			System.out.println(trumpCards);
			index = random.nextInt(trumpCards.size());
			selectedCard = trumpCards.get(index);
		}else {
			index = random.nextInt(cards.getNumberOfCards());
			selectedCard = cards.get(index);
			
		}
		
		return selectedCard;
	}





 

}
