import ch.aplu.jcardgame.*;

public interface SelectionStrategy {

	public Card selectCard(Hand cards, GameInformation gameInfo);

}