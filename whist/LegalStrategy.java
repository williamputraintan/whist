import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class LegalStrategy implements SelectionStrategy{

	public Card selectCard(Hand cards,Random random, Suit trump,GameInformation gameInfo) {
		Card selectedCard;
		int index;
		ArrayList<Card> trumpCards;
		 
		if(cards.getNumberOfCardsWithSuit(trump)>0) {
			trumpCards=cards.getCardsWithSuit(trump);
			index= random.nextInt(trumpCards.size());
			selectedCard = trumpCards.get(index);
		}else {
			index= random.nextInt(cards.getNumberOfCards());
			selectedCard = cards.get(index);
			
		}
		
		return selectedCard;
	}


}