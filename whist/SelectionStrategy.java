import ch.aplu.jcardgame.*;

public interface SelectionStrategy {
	
	/**
	 * will select what card needed
	 * @param player
	 * @return selectedCard for the move
	 */
	public Card selectCard(Player player);

}