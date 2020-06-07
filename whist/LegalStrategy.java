// Edited by Team101: William Putra Intan(955545), Franklin Aldo Darmansa (1025392), Patricia Angelica Budiman (1012861)
import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class LegalStrategy implements SelectionStrategy{
	
	
	public Card selectCard(Player playerInfo) {
		
		//Variable for selected cards
		Card selectedCard;
		int index;
		ArrayList<Card> leadCards;
		
		//Get information about what player had
		Random random = playerInfo.getRandom();
		Suit leadSuit = playerInfo.getLeadSuit();
		Hand cards = playerInfo.getHand();
		
		//Select same suit as lead cards if they there any
		if(cards.getNumberOfCardsWithSuit(leadSuit)>0) {
			leadCards=cards.getCardsWithSuit(leadSuit);
			index= random.nextInt(leadCards.size());
			selectedCard = leadCards.get(index);
		}else {
			
			//Select any cards from hand if no suit same as lead cards
			index= random.nextInt(cards.getNumberOfCards());
			selectedCard = cards.get(index);
		}

		return selectedCard;
	}


}