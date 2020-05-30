import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class SmartStrategy implements SelectionStrategy{

	public Card selectCard(Hand cards, GameInformation gameInfo) {
		Card selectedCard;
		int index;
		ArrayList<Card> handLeadCards; //Array of the same 
		Random random = gameInfo.getRandom();
		Suit lead = gameInfo.getLeadSuit();
		int numLeadCard = cards.getNumberOfCardsWithSuit(lead);
//		gameInfo.getCurrentlyPlayed().sort(Hand.SortType.SUITPRIORITY, true);s
		
		
		if(numLeadCard>0){
			handLeadCards = cards.getCardsWithSuit(lead);
			System.out.println(handLeadCards);
			index = random.nextInt(handLeadCards.size());
			selectedCard = handLeadCards.get(index);
		}else {
			index = random.nextInt(cards.getNumberOfCards());
			selectedCard = cards.get(index);
			
		}
		
		return selectedCard;
	}
	

}
