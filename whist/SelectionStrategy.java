import java.util.Random;

import ch.aplu.jcardgame.*;

public interface SelectionStrategy {
	
	public Card selectCard(Hand cards,Random random,Suit trump);
	
}