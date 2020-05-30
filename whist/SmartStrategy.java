import java.util.ArrayList;
import java.util.Random;



import ch.aplu.jcardgame.*;
import java.util.Iterator;

public class SmartStrategy implements SelectionStrategy{

	public Card selectCard(Hand cards, GameInformation gameInfo) {
		Card selectedCard;
		int index;
		ArrayList<Card> leadCards; //Array of cards in hand same as lead
		Random random = gameInfo.getRandom();
		Suit lead = gameInfo.getLeadSuit();
		int numLeadCard = cards.getNumberOfCardsWithSuit(lead);
//		ArrayList<Card> cardsOnTable= gameInfo.getCurrentlyPlayed();
		
//		ArrayList<Card> leadsOnTable= getCardsOnTable(cardsOnTable,lead);
//		ArrayList<Card> trumpsOnTable= getCardsOnTable(cardsOnTable,gameInfo.getTrump());
//		Hand hand=
//
//		
		if(numLeadCard>0){
			leadCards = cards.getCardsWithSuit(lead);
			index = random.nextInt(leadCards.size());
			selectedCard = leadCards.get(index);
		}else {
			index = random.nextInt(cards.getNumberOfCards());
			selectedCard = cards.get(index);
			
		}
		
		return selectedCard;
	}
	
	private ArrayList<Card> getCardsOnTable(ArrayList<Card> allCards, Suit suit) {
		ArrayList<Card> cards= new ArrayList<Card>();
		Iterator<Card> i = allCards.iterator();
		while (i.hasNext()) {
			Card item=i.next();
			if(item.getSuit().equals(suit)) {
				cards.add(item);
			}
		}
		return cards;
	}





 

}
