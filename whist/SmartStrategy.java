import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class SmartStrategy implements SelectionStrategy{

	public Card selectCard(Hand cards, GameInformation gameInfo) {
		Card selectedCard;
		int index;
		ArrayList<Card> leadCards; //Array of the same trump
		Random random = gameInfo.getRandom();
		Suit lead = gameInfo.getLeadSuit();
		int numLeadCard = cards.getNumberOfCardsWithSuit(lead);
//		gameInfo.getCurrentlyPlayed()
		
		
		if(numLeadCard>0){
			leadCards = cards.getCardsWithSuit(lead);
			System.out.println(leadCards);
			index = random.nextInt(leadCards.size());
			selectedCard = leadCards.get(index);
		}else {
			index = random.nextInt(cards.getNumberOfCards());
			selectedCard = cards.get(index);
			
		}
		
		return selectedCard;
	}





 

}
