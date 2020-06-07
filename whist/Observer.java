import ch.aplu.jcardgame.Card;

public interface Observer {
	
	//add card function to the observer
	public void addCurrentCard(Card card);
	
	//Update current information of the round
	public void tableInfo(Card winningCard, Suit leadSuit, Suit currentTrump);
}
