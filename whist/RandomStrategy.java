
import java.util.Random;

import ch.aplu.jcardgame.*;

public class RandomStrategy implements SelectionStrategy {


	public Card selectCard(Player playerInfo) {
		Random random = playerInfo.getRandom();
		Hand myCards = playerInfo.getHand();
		
		int x = random.nextInt(myCards.getNumberOfCards());
		
		return myCards.get(x);
		 
//		return selected;
	}


}
