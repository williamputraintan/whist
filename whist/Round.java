import java.util.Optional;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.CardAdapter;
import ch.aplu.jcardgame.CardListener;
import ch.aplu.jcardgame.Deck;
import ch.aplu.jcardgame.Hand;
import ch.aplu.jcardgame.RowLayout;
import ch.aplu.jcardgame.TargetArea;
import ch.aplu.jgamegrid.Actor;

public class Round {
	private Hand[] hands;

	private GameProperties gameProps;
	private Deck deck;
	private Player[] players;
	private Whist whist;
	private Card selected;
	private GameInformation gameInfo;
	
	public Round(Hand[] hands,GameProperties gameProps,Player[] players, Whist whist,GameInformation gameInfo) {
		this.hands=hands;
		this.gameProps=gameProps;
		this.players=players;
		this.whist=whist;
		this.gameInfo=gameInfo;
		this.deck=whist.getDeck();
	}
	
	  public void initRound() {
			 hands = deck.dealingOut(gameProps.getNbPlayers(), gameProps.getNbStartCards()); // Last element of hands is leftover cards; these are ignored
			 for (int i = 0; i < gameProps.getNbPlayers(); i++) {
					   hands[i].sort(Hand.SortType.SUITPRIORITY, true);
					
					   players[i].setHand(hands[i]);
				 }

			 if(gameProps.getHuman()>0) {
				 // Set up human player for interaction
				CardListener cardListener = new CardAdapter()  // Human Player plays card
					    {
					      public void leftDoubleClicked(Card card) { 
					    	  selected = card; hands[0].setTouchEnabled(false); }
					    };
				hands[0].addCardListener(cardListener);
			 }
			 
			 // graphics
		    RowLayout[] layouts = new RowLayout[gameProps.getNbPlayers()];
		    for (int i = 0; i < gameProps.getNbPlayers(); i++) {
		      layouts[i] = new RowLayout(whist.getHandLoc()[i], whist.getHandWidth());
		      layouts[i].setRotationAngle(90 * i);
		      // layouts[i].setStepDelay(10);
		      hands[i].setView(whist, layouts[i]);
		      hands[i].setTargetArea(new TargetArea(whist.getTrickLocation()));
		      hands[i].draw();
		    }
//		    for (int i = 1; i < nbPlayers; i++)  // This code can be used to visually hide the cards in a hand (make them face down)
//		      hands[i].setVerso(true);
		    // End graphics
	  }
	  public Optional<Integer> playRound() {  // Returns winner, if any
			// Select and display trump suit
			final Suit trumps = Whist.randomEnum(Suit.class);
			final Actor trumpsActor = new Actor("sprites/"+whist.trumpImage[trumps.ordinal()]);
			
			gameInfo.setCurrentTrump(trumps);
			
			whist.addActor(trumpsActor, whist.getTrumpsActorLocation());
			// End trump suit
			Hand trick;
			int winner;
			Card winningCard;
			Suit lead;

			int nextPlayer = whist.getRandom().nextInt(gameProps.getNbPlayers()); // randomly select player to lead for this round
			for (int i = 0; i <gameProps.getNbStartCards(); i++) {
				trick = new Hand(deck);
			
		    	selected = null;
		    	 System.out.println("CURRENT TURN whist = " + gameInfo.getCurrentlyPlayed().size());
		        if (gameProps.getHuman() > 0 && 0 == nextPlayer) {  // Select lead depending on player type
		    		hands[0].setTouchEnabled(true);
		    		whist.setStatus("Player 0 double-click on card to lead.");
		    		while (null == selected) Whist.delay(100);
		    		
		        } else {
		    		whist.setStatusText("Player " + nextPlayer + " thinking...");
		            Whist.delay(whist.getThinkingTime());
		            System.out.println("TYPE:"+players[nextPlayer].getType());
		            selected = players[nextPlayer].getCard(trumps, whist);
		        }
		        gameInfo.addCurrentCard(selected);
		       
		        // Lead with selected card
			        trick.setView(whist, new RowLayout(whist.getTrickLocation(), (trick.getNumberOfCards()+2)*whist.getTrickWidth()));
					trick.draw();
					selected.setVerso(false);
					// No restrictions on the card being lead
					lead = (Suit) selected.getSuit();
					gameInfo.setLeadSuit(lead);
					System.out.print("ROUND LEAD "+gameInfo.getLeadSuit());
					selected.transfer(trick, true); // transfer to trick (includes graphic effect)
					winner = nextPlayer;
					winningCard = selected;
					gameInfo.setWinningCard(winningCard);
				// End Lead
				for (int j = 1; j < gameProps.getNbPlayers(); j++) {
					if (++nextPlayer >= gameProps.getNbPlayers()) nextPlayer = 0;  // From last back to first
					selected = null;
			    	 System.out.println("CURRENT TURN whist = " + gameInfo.getCurrentlyPlayed().size());
			        if (0 == nextPlayer && gameProps.getHuman() > 0) {
			    		hands[0].setTouchEnabled(true);
			    		whist.setStatus("Player 0 double-click on card to follow.");
			    		while (null == selected) Whist.delay(100);
			        } else {
				        whist.setStatusText("Player " + nextPlayer + " thinking...");
				        Whist.delay(whist.getThinkingTime());
				        System.out.println("TYPE:"+players[nextPlayer].getType());
				        selected = players[nextPlayer].getCard(trumps, whist);
				        System.out.println("LEAD "+lead);
			        }
			        gameInfo.addCurrentCard(selected);
			        
			        // Follow with selected card
				        trick.setView(whist, new RowLayout(whist.getTrickLocation(), (trick.getNumberOfCards()+2)*whist.getTrickWidth()));
						trick.draw();
						selected.setVerso(false);  // In case it is upside down
						// Check: Following card must follow suit if possible
							if (selected.getSuit() != lead && hands[nextPlayer].getNumberOfCardsWithSuit(lead) > 0) {
								 // Rule violation
								 String violation = "Follow rule broken by player " + nextPlayer + " attempting to play " + selected;
								 System.out.println(violation);
								 if (gameProps.getEnforceRules()) 
									 try {
										 throw(new BrokeRuleException(violation));
										} catch (BrokeRuleException e) {
											e.printStackTrace();
											System.out.println("A cheating player spoiled the game!");
											System.exit(0);
										}  
							 }
						// End Check
						 selected.transfer(trick, true); // transfer to trick (includes graphic effect)
						 System.out.println("winning: suit = " + winningCard.getSuit() + ", rank = " + winningCard.getRankId());
						 System.out.println(" played: suit = " +    selected.getSuit() + ", rank = " +    selected.getRankId());
						 if ( // beat current winner with higher card
							 (selected.getSuit() == winningCard.getSuit() && whist.rankGreater(selected, winningCard)) ||
							  // trumped when non-trump was winning
							 (selected.getSuit() == trumps && winningCard.getSuit() != trumps)) {
							 System.out.println("NEW WINNER");
							 winner = nextPlayer;
							 winningCard = selected;
							 gameInfo.setWinningCard(winningCard);
						 }
					// End Follow
					}

				Whist.delay(600);
				trick.setView(whist, new RowLayout(whist.getHideLocation(), 0));
				trick.draw();		
				nextPlayer = winner;
				whist.setStatusText("Player " + nextPlayer + " wins trick.");
				whist.getScores()[nextPlayer]++;
				whist.updateScore(nextPlayer);
				if (gameProps.getWinningScore() == whist.getScores()[nextPlayer]) return Optional.of(nextPlayer);
				}
			whist.removeActor(trumpsActor);
			return Optional.empty();
		  }


}
