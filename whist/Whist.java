// Whist.java

import ch.aplu.jcardgame.*;
import ch.aplu.jgamegrid.*;

import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("serial")
public class Whist extends CardGame {

  final String trumpImage[] = {"bigspade.gif","bigheart.gif","bigdiamond.gif","bigclub.gif"};

  static final Random random = new Random(30006);
  
  // return random Enum value
  public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
      int x = random.nextInt(clazz.getEnumConstants().length);
      return clazz.getEnumConstants()[x];
  }
  
  // return random Card from Hand
  public static Card randomCard(Hand hand){
      int x = random.nextInt(hand.getNumberOfCards());
      return hand.get(x);
  }
 
  // return random Card from ArrayList
  public static Card randomCard(ArrayList<Card> list){
      int x = random.nextInt(list.size());
      return list.get(x);
  }
  
  public boolean rankGreater(Card card1, Card card2) {
	  return card1.getRankId() < card2.getRankId(); // Warning: Reverse rank order of cards (see comment on enum)
  }
  private static int Human;
  private static int NPC_random;
  private static int NPC_legal;
  private static int NPC_smart;

  private final String version = "1.0";
  public final int nbPlayers = 4;
  public static int nbStartCards;
  public static int winningScore = 11;
  public Player[] players = new Player[nbPlayers];
  public GameInformation gameInfo = new GameInformation(nbPlayers, random);
  public static GameProperties gameProps;
  
  private final int handWidth = 400;
  private final int trickWidth = 40;
  private final Deck deck = new Deck(Suit.values(), Rank.values(), "cover");
  private final Location[] handLocations = {
			  new Location(350, 625),
			  new Location(75, 350),
			  new Location(350, 75),
			  new Location(625, 350)
	  };
  private final Location[] scoreLocations = {
			  new Location(575, 675),
			  new Location(25, 575),
			  new Location(575, 25),
			  new Location(650, 575)
	  };
  private Actor[] scoreActors = {null, null, null, null };
  private final Location trickLocation = new Location(350, 350);
  private final Location textLocation = new Location(350, 450);
  private final int thinkingTime = 2000;
  private Hand[] hands;
  private Location hideLocation = new Location(-500, - 500);
  private Location trumpsActorLocation = new Location(50, 50);
  
//  private static boolean enforceRules = false;

  public void setStatus(String string) { setStatusText(string); }
  
  private int[] scores = new int[nbPlayers];

  Font bigFont = new Font("Serif", Font.BOLD, 36);

  private void initScore() {
	  int NPC_smart = gameProps.getNPC_smart();
	  int NPC_random= gameProps.getNPC_random();
	  int NPC_legal=gameProps.getNPC_legal();
	  int Human=gameProps.getHuman();
	
	  
	  
//	  System.out.println(gameProps.getNPC_smart());
	  for (int i = 0; i < nbPlayers; i++) {
		 scores[i] = 0;
		 if(Human>0 && i==0) {
			 players[i] = new Player("human");
		 }else if (NPC_random > 0) {
			 players[i] = new Player("random");
			 NPC_random-=1;
		 }else if (NPC_smart > 0) {
			 players[i] = new Player("smart");
			 NPC_smart-=1;
		 }else if (NPC_legal > 0) {
			 players[i] = new Player("legal");
			 NPC_legal-=1;
		 }
		 scoreActors[i] = new TextActor("0", Color.WHITE, bgColor, bigFont);
		 addActor(scoreActors[i], scoreLocations[i]);
	 }
  }

  public void updateScore(int player) {
	removeActor(scoreActors[player]);
	scoreActors[player] = new TextActor(String.valueOf(scores[player]), Color.WHITE, bgColor, bigFont);
	addActor(scoreActors[player], scoreLocations[player]);
  }

  public Whist(){
	  
    super(700, 700, 30);
  
    setTitle("Whist (V" + version + ") Constructed for UofM SWEN30006 with JGameGrid (www.aplu.ch)");
    setStatusText("Initializing...");
    initScore();
    Optional<Integer> winner;
    Round round= new Round(hands,gameProps,players,this,gameInfo);
    do { 
     round.initRound();
      winner = round.playRound();
    } while (!winner.isPresent());
    addActor(new Actor("sprites/gameover.gif"), textLocation);
    setStatusText("Game over. Winner is player: " + winner.get());
    refresh();
  }
 public GameInformation getInfo() {
	 return gameInfo;
 }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException{
  
	System.out.println("Choose properties (original/legal/smart): ");
	Scanner myObj = new Scanner(System.in); 

	String property = myObj.nextLine();
  	
	gameProps= new GameProperties(property);

    new Whist();
   
  }

  public Location[] getHandLoc() {
	  return handLocations;
  }
  public int getHandWidth() {
	  return handWidth;
  }
  public Location getTrickLocation() {
	  return trickLocation;
  }
  public Location getTrumpsActorLocation() {
	return trumpsActorLocation ;
	  
	  
  }
  public int getTrickWidth() {
	  return trickWidth;
  }
  public Random getRandom() {
	  return random;
  }
  public int getThinkingTime() {
	  return thinkingTime;
  }
  public int[] getScores() {
	  return scores;
  }
  public Location getHideLocation() {
	  return hideLocation;
  }
  public Deck getDeck() {
	  return deck;
  }
  public Player[] getPlayers() {
	  return players;
  }


}
