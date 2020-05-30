import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class LegalStrategy implements SelectionStrategy{

	public Card selectCard(Hand cards, GameInformation gameInfo) {
		Card selectedCard;
		int index;
		ArrayList<Card> leadCards;
		Random random = gameInfo.getRandom();
		Suit leadSuit = gameInfo.getLeadSuit();
		
		
		if(cards.getNumberOfCardsWithSuit(leadSuit)>0) {
			leadCards=cards.getCardsWithSuit(leadSuit);
			index= random.nextInt(leadCards.size());
			selectedCard = leadCards.get(index);
		}else {
			index= random.nextInt(cards.getNumberOfCards());
			selectedCard = cards.get(index);
		}

		return selectedCard;
	}


}