// Edited by Team101: William Putra Intan(955545), Franklin Aldo Darmansa (1025392), Patricia Angelica Budiman (1012861)
import ch.aplu.jcardgame.*;

public interface SelectionStrategy {
	
	/**
	 * will select what card needed
	 * @param player
	 * @return selectedCard for the move
	 */
	public Card selectCard(Player player);

}