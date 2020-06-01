import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GameProperties {
	private int Human;
	private int nbPlayers;
	private int nbStartCards ;
	private int NPC_legal ;
	private int NPC_random ; 
	private int NPC_smart ;
	private boolean enforceRules;
	private int winningScore;
	
	
	public GameProperties(String property) throws IOException {
		Properties gameProperties = new Properties();
		String fileName ="whist/"+property+".properties";
	
		System.out.print(fileName);
	
		// Read properties
		FileReader inStream = null;
		try {
			inStream = new FileReader(fileName);
			gameProperties.load(inStream);
		} finally {
			if (inStream != null) {
			     inStream.close();
			}
		}
		Human=Integer.parseInt(gameProperties.getProperty("Human"));
		NPC_random = Integer.parseInt(gameProperties.getProperty("NPC_random"));
		NPC_legal = Integer.parseInt(gameProperties.getProperty("NPC_legal"));
		NPC_smart = Integer.parseInt(gameProperties.getProperty("NPC_smart"));
		enforceRules = Boolean.parseBoolean(gameProperties.getProperty("enforceRules"));
		nbStartCards = Integer.parseInt(gameProperties.getProperty("nbStartCards"));
		winningScore = Integer.parseInt(gameProperties.getProperty("winningScore"));
		nbPlayers= Integer.parseInt(gameProperties.getProperty("nbPlayers"));
			
	}

	public int getHuman() {
		return Human;
	}

	public int getNbPlayers() {
		return nbPlayers;
	}


	public int getNbStartCards() {
		return nbStartCards;
	}

	public int getNPC_legal() {
		return NPC_legal;
	}

	public int getNPC_random() {
		return NPC_random;
	}

	public int getNPC_smart() {
		return NPC_smart;
	}

	public boolean getEnforceRules() {
		return enforceRules;
	}

	public int getWinningScore() {
		return winningScore;
	}

}
