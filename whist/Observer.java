import ch.aplu.jcardgame.Card;

public interface Observer {
	//HARUS DIPiSAH karena dia namah terus tiap dia playround . to be continued....
	public void addCurrentCard(Card card);
	
	public void tableInfo(Card winningCard, Suit leadSuit, Suit currentTrump);
}
