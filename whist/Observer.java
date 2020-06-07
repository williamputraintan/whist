// Edited by Team101: William Putra Intan(955545), Franklin Aldo Darmansa (1025392), Patricia Angelica Budiman (1012861)
import ch.aplu.jcardgame.Card;

public interface Observer {
	
	//add card function to the observer
	public void addCurrentCard(Card card);
	
	//Update current information of the round
	public void tableInfo(Card winningCard, Suit leadSuit, Suit currentTrump);
}
