import java.util.Random;

import ch.aplu.jcardgame.*;

public class RandomStrategy implements SelectionStrategy {
	private Card selected;

	@Override
	public Card selectCard(Hand cards, Random random,Suit trump) {
		int x = random.nextInt(cards.getNumberOfCards());
		selected = cards.get(x);
		return selected;
	}

}
