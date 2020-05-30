//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class RandomStrategy implements SelectionStrategy {


	public Card selectCard(Hand cards, GameInformation gameInfo) {
		Random random = gameInfo.getRandom();
		
		int x = random.nextInt(cards.getNumberOfCards());
		
		return cards.get(x);
		 
//		return selected;
	}


}
