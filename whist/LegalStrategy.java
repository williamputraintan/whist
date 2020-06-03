import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class LegalStrategy implements SelectionStrategy{

	public Card selectCard(Player playerInfo) {
		Card selectedCard;
		int index;
		ArrayList<Card> leadCards;
		Random random = playerInfo.getRandom();
		Suit leadSuit = playerInfo.getLeadSuit();
		Hand cards = playerInfo.getHand();
		
		
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