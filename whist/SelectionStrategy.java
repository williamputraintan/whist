import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public interface SelectionStrategy {
	
	public void selectCard(Hand cards,Random random,Suit trump);
//	public Card selectCard(Hand cards,Random random,Suit trump, ArrayList<Card> cardsOnTable);
	public Card getSelected();
	

}