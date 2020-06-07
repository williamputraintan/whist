
import java.util.Random;
import ch.aplu.jcardgame.*;


public class RandomStrategy implements SelectionStrategy {

	/**
	 * The function will return a random card from players hand and disregards any rules 
	 */
	public Card selectCard(Player playerInfo) {

		//Get random generated rules
		Random random = playerInfo.getRandom();

		//Grab all cards on players hand
		Hand myCards = playerInfo.getHand();
		
		//Sellect the random number index to pick from
		int x = random.nextInt(myCards.getNumberOfCards());
		
		//return the card by using the random index
		return myCards.get(x);
		 
	}


}
