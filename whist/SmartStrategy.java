import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class SmartStrategy implements SelectionStrategy{

	public Card selectCard(Hand cards, GameInformation gameInfo) {
		Card selectedCard;
		int index;
		ArrayList<Card> trumpCards; //Array of the same trump
		Random random = gameInfo.getRandom();
		Suit trump = gameInfo.getTrump();
		
		System.out.println(gameInfo.getCurrentlyPlayed());
		
		
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
