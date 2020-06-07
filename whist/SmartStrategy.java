// Edited by Team101: William Putra Intan(955545), Franklin Aldo Darmansa (1025392), Patricia Angelica Budiman (1012861)
import java.util.ArrayList;

import ch.aplu.jcardgame.*;


public class SmartStrategy implements SelectionStrategy{

	public Card selectCard(Player playerInfo) {
		ArrayList<Card> leadCards; 	//Array of leadcards in hand
		ArrayList<Card> trumpCards;	//Array of trump cards in hand
		
		//Current cards used 
		Card highestTrumpCardUsed;
		Card selected;
		
		//Grab information from player class
		Hand myCards = playerInfo.getHand();
		Suit trumpSuit = playerInfo.getCurrentTrump();
		Suit leadSuit = playerInfo.getLeadSuit();
		Card winningCard = playerInfo.getWinningCard();
		ArrayList<Card> cardsOnTable = playerInfo.getCardsOnTable();
		
		//Set current winning suit
		Suit winningSuit = (Suit) winningCard.getSuit();
		int currentTurn = cardsOnTable.size();
		int numLeadCard = playerInfo.getHand().getNumberOfCardsWithSuit(leadSuit);
		int numTrumpCard = playerInfo.getHand().getNumberOfCardsWithSuit(trumpSuit);		
		
		
		//Identify which strategy used for different turns
		switch(currentTurn) {
			
			//If NPC have the first turn
			case 0:
				
				//Will get the smallest non trump suit
				selected = findSmallest_nonSuit(myCards.getCardList(), trumpSuit);
				
				//Will return the the smallest non trump suit card or any smallest card number otherwise
				if (selected!=null) {
					return selected;
				}else {
					return myCards.getLast();
				}

			//NPC move other than the first move
			default:
								
				//Will check if have a card that have the same suit as the lead card
				if(numLeadCard>0){

					//Will grab all cards that have the same suit as leadCard
					leadCards = myCards.getCardsWithSuit(leadSuit);
					
					//Will iterate to find smallest lead card that could beat the highest lead card
					for(int i=leadCards.size()-1;i>=0;i--) {
						if(leadCards.get(i).getRankId() < winningCard.getRankId() && leadCards.get(i).getSuit() == (winningSuit)) {
							return leadCards.get(i);
						}
					
					}					
					//Return smallest lead suit cards if none have bigger value 
					return leadCards.get(leadCards.size()-1);
					
				}else if(numTrumpCard > 0) {
					//Will try the return trump cards
					trumpCards = myCards.getCardsWithSuit(trumpSuit);
					
					//Will find the highest trump suit cards on the table
					highestTrumpCardUsed = findHighest_suit(cardsOnTable, trumpSuit);

					//Will iterate to find smallest trump card that could beat the highest Trump card
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
					//Will return the smallest trump card
					return trumpCards.get(trumpCards.size()-1); 
				}

				//Will return the smallest card that current player had if none lead/trump suit card exist
				return myCards.getLast();
		}
		
	}
	
	/**
	 * The function will return the highest card from the card list for the specified suit
	 * @param list, of cards to iterate
	 * @param suit, the specified suit
	 * @return the highest card
	 */
	private Card findHighest_suit(ArrayList<Card> list, Suit suit) {
		
		boolean isFirst = true;
		Card highestCard = null;
		
		for(Card card:list) {
			//To grab the first card
			if(isFirst) {
				if (card.getSuit().equals(suit)) {
					highestCard = card;
					isFirst = false;

				}
				continue;
			}

			//Comparing to get the highest card
			if(card.getSuit().equals(suit) && card.getRankId() < highestCard.getRankId()) {
				highestCard = card;
			}
		}
		return highestCard;
	}
	 /**
	  * Find the smallest card that is not the specified suit
	  * @param list, the card list to iterate
	  * @param suit, the suit that do not want the card to return
	  * @return smallest card avail that is not the suit
	  */
	private Card findSmallest_nonSuit(ArrayList<Card> list, Suit suit) {
		boolean isFirst = true;
		Card lowestCard = null;

		for(Card card:list) {

			//Will find the first non-suit card
			if(isFirst) {
				if (!card.getSuit().equals(suit)) {
					lowestCard = card;
					isFirst = false;
				}
				continue;
			}

			//Will compare to get the smallest card
			if(!card.getSuit().equals(suit) &&card.getRankId() > lowestCard.getRankId()) {
				lowestCard = card;
			}
			
		}
		return lowestCard;
	}

}
