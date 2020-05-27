//import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.*;

public class RandomStrategy implements SelectionStrategy {
	private Card selected;

	public void selectCard(Hand cards, Random random,Suit trump) {
		int x = random.nextInt(cards.getNumberOfCards());
		setSelected(cards.get(x));
//		return selected;
	}

	public Card getSelected() {
		return selected;
	}

	public void setSelected(Card selected) {
		this.selected = selected;
	}
	
	


	//public Card selectCard() {
		// TODO Auto-generated method stub
	//	return null;
	//}


}
