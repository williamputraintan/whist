import java.util.ArrayList;
import java.util.Random;



import ch.aplu.jcardgame.*;


public class SmartStrategy implements SelectionStrategy{

	public Card selectCard(Hand cards, GameInformation gameInfo) {

		ArrayList<Card> leadCards; 	//Array of leadcards in hand
		ArrayList<Card> trumpCards;	//Array of trump cards in hand
		
		

		Card highestTrumpCardUsed;
		Card selected;
		Suit trumpSuit = gameInfo.getTrump();
		Suit leadSuit = gameInfo.getLeadSuit();
		int numLeadCard = cards.getNumberOfCardsWithSuit(leadSuit);
		int numTrumpCard = cards.getNumberOfCardsWithSuit(trumpSuit);
		
		int currentTurn = gameInfo.getCurrentlyPlayed().size();

		Card winningCard = gameInfo.getWinningCard();
		Suit winningSuit = (Suit) winningCard.getSuit();	
		System.out.print("current turn = "+currentTurn+"\n");
		System.out.println("LEAD SUIT "+leadSuit);
		switch(currentTurn) {
	
			case 0:
//				if(numTrumpCard>0){
//					
//					selectedCard = leadCards.get(0);
//				}else {
//					index = random.nextInt(cards.getNumberOfCards());
//					selectedCard = cards.get(index);
//					
//				}
				
				selected = findSmallest_nonSuit(cards.getCardList(), trumpSuit);
				
				if (selected!=null) {
					return selected;
				}else {
					return cards.getLast();
				}

			default:
				if(numLeadCard>0){
					leadCards = cards.getCardsWithSuit(leadSuit);
					
					System.out.println("LEAD CARDS>0 :"+leadCards);
						
					for(int i=leadCards.size()-1;i>=0;i--) {
//						System.out.println("leadrankID = "+ leadCards.get(i).getRankId());
//						System.out.println("winningcardrankID = "+winningCard.getRankId());
//						System.out.println(leadCards.get(i).getSuit());
//						System.out.println(winningSuit);
						if(leadCards.get(i).getRankId() < winningCard.getRankId() && leadCards.get(i).getSuit() == (winningSuit)) {
//							System.out.println("leadrankID = "+ leadCards.get(i).getRankId());
//							System.out.println("winningcardrankID = "+winningCard.getRankId());
//							System.out.println(leadCards.get(i));
							return leadCards.get(i);
						}
					
					}					

					return leadCards.get(leadCards.size()-1);
					
				}else if(numTrumpCard > 0) {
					trumpCards = cards.getCardsWithSuit(trumpSuit);
					
					highestTrumpCardUsed = findHighest_suit(gameInfo.getCurrentlyPlayed(), trumpSuit);
					if(highestTrumpCardUsed != null) {
						for(Card card:trumpCards) {
							if(card.getRankId() < highestTrumpCardUsed.getRankId()) {
								return card;
							}
						}
						selected = findSmallest_nonSuit(trumpCards, trumpSuit);
						if(selected != null) {
							return selected;
						}
					}
				}
//				System.out.println(cards);
				return findSmallest_nonSuit(cards.getCardList(),trumpSuit);
		}
		

		
		
	}
	
	private Card findHighest_suit(ArrayList<Card> list, Suit suit) {
		
		boolean isFirst = true;
		Card highestCard = null;
		
		for(Card card:list) {
			if(isFirst) {
				if (card.getSuit().equals(suit)) {
					highestCard = card;
					isFirst = false;
					System.out.println("HIGHEST SUIT = "+card);
				}
				continue;
			}

			if(card.getSuit().equals(suit) && card.getRankId() < highestCard.getRankId()) {
				highestCard = card;
			}
		}
		return highestCard;
	}
	
	private Card findSmallest_nonSuit(ArrayList<Card> list, Suit suit) {
		boolean isFirst = true;
		Card lowestCard = null;
		System.out.println("Printig the list for findSmallest_nonsuit = "+list);
		for(Card card:list) {
			if(isFirst) {
				if (!card.getSuit().equals(suit)) {
					lowestCard = card;
					isFirst = false;
				}
				continue;
			}

			if(!card.getSuit().equals(suit) &&card.getRankId() > lowestCard.getRankId()) {
				lowestCard = card;
			}
			
		}
		return lowestCard;
	}

}
