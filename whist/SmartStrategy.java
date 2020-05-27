import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class SmartStrategy implements SelectionStrategy{
	private Card selected;
	private ArrayList<Card> trumpCards;
	private int index;

	
	
	public void selectCard(Hand cards,Random random, Suit trump, ArrayList<Card> cardsOnTable) {

		if(cards.getNumberOfCardsWithSuit(trump)>0) {
			trumpCards = cards.getCardsWithSuit(trump);
			System.out.println(trumpCards);
			index = random.nextInt(trumpCards.size());
			selected = trumpCards.get(index);
		}else {
			index = random.nextInt(cards.getNumberOfCards());
			selected = cards.get(index);
			
		}
		
		
	}



	@Override
	public Card selectCard(Hand cards, Random random, Suit trump) {
		// TODO Auto-generated method stub
		return null;
	}



 

}
