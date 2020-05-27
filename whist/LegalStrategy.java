import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class LegalStrategy implements SelectionStrategy{
	private Card selected;
	private ArrayList<Card> trumpCards;
	private int index;

	@Override
	public void selectCard(Hand cards,Random random, Suit trump) {
		 
		if(cards.getNumberOfCardsWithSuit(trump)>0) {
			trumpCards=cards.getCardsWithSuit(trump);
			index= random.nextInt(trumpCards.size());
			setSelected(trumpCards.get(index));
		}else {
			index= random.nextInt(cards.getNumberOfCards());
			setSelected(cards.get(index));
			
		}
		
		
	}

	public Card getSelected() {
		return selected;
	}

	public void setSelected(Card selected) {
		this.selected = selected;
	}


}