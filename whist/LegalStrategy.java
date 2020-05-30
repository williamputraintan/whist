import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class LegalStrategy implements SelectionStrategy{

	public Card selectCard(Hand cards, GameInformation gameInfo) {
		Card selectedCard;
		int index;
		ArrayList<Card> trumpCards;
		Random random = gameInfo.getRandom();
		Suit leadSuit = gameInfo.getLeadSuit();
		
		
		if(cards.getNumberOfCardsWithSuit(leadSuit)>0) {
			trumpCards=cards.getCardsWithSuit(leadSuit);
			index= random.nextInt(trumpCards.size());
			selectedCard = trumpCards.get(index);
		}else {
			index= random.nextInt(cards.getNumberOfCards());
			selectedCard = cards.get(index);
			
		}

		return selectedCard;
	}


}