//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class RandomStrategy implements SelectionStrategy {


	public Card selectCard(Hand cards, Random random,Suit trump,GameInformation gameInfo) {
		int x = random.nextInt(cards.getNumberOfCards());
		
		return cards.get(x);
		 
//		return selected;
	}


}
