import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class LegalStrategy implements SelectionStrategy{
	private Card selected;
	private ArrayList<Card> trumpCards;
	private int index;

	@Override
	public Card selectCard(Hand cards,Random random, Suit trump) {
		 
		if(cards.getNumberOfCardsWithSuit(trump)>0) {
			trumpCards=cards.getCardsWithSuit(trump);
			index= random.nextInt(trumpCards.size());
			selected=trumpCards.get(index);
		}else {
			index= random.nextInt(cards.getNumberOfCards());
			selected=cards.get(index);
			
		}
		
		return selected;
		
	}

}