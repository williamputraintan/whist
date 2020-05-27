import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class SmartStrategy implements SelectionStrategy, RecordGame {
	private Card selected;
	private ArrayList<Card> trumpCards;
	private int index;
	private ArrayList<Card> usedCards;

	
	
	
	public Card selectCard(Hand cards,Random random, Suit trump) {

		if(cards.getNumberOfCardsWithSuit(trump)>0) {
			trumpCards=cards.getCardsWithSuit(trump);
			System.out.println(trumpCards);
			index= random.nextInt(trumpCards.size());
			selected=trumpCards.get(index);
		}else {
			index= random.nextInt(cards.getNumberOfCards());
			selected=cards.get(index);
			
		}
		
		return selected;
		
	}
	
@Override
public void recordCard(Card addedCard) {
	usedCards.add(addedCard);
}
	
	

}
