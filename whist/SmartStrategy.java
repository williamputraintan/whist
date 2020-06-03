import java.util.ArrayList;

import ch.aplu.jcardgame.*;


public class SmartStrategy implements SelectionStrategy{

	public Card selectCard(Player playerInfo) {

		ArrayList<Card> leadCards; 	//Array of leadcards in hand
		ArrayList<Card> trumpCards;	//Array of trump cards in hand
		
		

		Card highestTrumpCardUsed;
		Card selected;
		
		Hand myCards = playerInfo.getHand();
		Suit trumpSuit = playerInfo.getCurrentTrump();
		Suit leadSuit = playerInfo.getLeadSuit();
		Card winningCard = playerInfo.getWinningCard();
		ArrayList<Card> cardsOnTable = playerInfo.getCardsOnTable();
		
		Suit winningSuit = (Suit) winningCard.getSuit();
		int currentTurn = cardsOnTable.size();
		int numLeadCard = playerInfo.getHand().getNumberOfCardsWithSuit(leadSuit);
		int numTrumpCard = playerInfo.getHand().getNumberOfCardsWithSuit(trumpSuit);		
		
		System.out.print("current turn = "+currentTurn+"\n");
		switch(currentTurn) {
	
			case 0:
				
				selected = findSmallest_nonSuit(myCards.getCardList(), trumpSuit);
				
				if (selected!=null) {
					return selected;
				}else {
					return myCards.getLast();
				}

			default:
				if(numLeadCard>0){
					leadCards = myCards.getCardsWithSuit(leadSuit);
					
					System.out.println(leadCards);
						
					for(int i=leadCards.size()-1;i>=0;i--) {

						if(leadCards.get(i).getRankId() < winningCard.getRankId() && leadCards.get(i).getSuit() == (winningSuit)) {
							return leadCards.get(i);
						}
					
					}					

					return leadCards.get(leadCards.size()-1);
					
				}else if(numTrumpCard > 0) {
					trumpCards = myCards.getCardsWithSuit(trumpSuit);
					
					highestTrumpCardUsed = findHighest_suit(cardsOnTable, trumpSuit);
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
					return trumpCards.get(trumpCards.size()-1); 
				}
//				System.out.println(cards);
				return myCards.getLast();
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
