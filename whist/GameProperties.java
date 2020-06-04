import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GameProperties {
	private int Human;
<<<<<<< HEAD
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
	
=======
	private int NPC_random;
	private int NPC_legal;
	private int NPC_smart;

	private final String version = "1.0";
	private int nbPlayers = 4;
	private int nbStartCards;
	private int winningScore = 11;
	private boolean enforceRules=false;
	
	 
	 
	public GameProperties(String fileName) throws IOException {
		Properties gameProperties = new Properties();
		
		
		System.out.print(fileName);
		
>>>>>>> william
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
<<<<<<< HEAD
		Human=Integer.parseInt(gameProperties.getProperty("Human"));
		NPC_random = Integer.parseInt(gameProperties.getProperty("NPC_random"));
		NPC_legal = Integer.parseInt(gameProperties.getProperty("NPC_legal"));
		NPC_smart = Integer.parseInt(gameProperties.getProperty("NPC_smart"));
		enforceRules = Boolean.parseBoolean(gameProperties.getProperty("enforceRules"));
		nbStartCards = Integer.parseInt(gameProperties.getProperty("nbStartCards"));
		winningScore = Integer.parseInt(gameProperties.getProperty("winningScore"));
		nbPlayers= Integer.parseInt(gameProperties.getProperty("nbPlayers"));
			
	}
=======
		this.Human= Integer.parseInt(gameProperties.getProperty("Human"));
		this.NPC_random= Integer.parseInt(gameProperties.getProperty("NPC_random"));
		this.NPC_legal= Integer.parseInt(gameProperties.getProperty("NPC_legal"));
		this.NPC_smart= Integer.parseInt(gameProperties.getProperty("NPC_smart"));
		this.enforceRules= Boolean.parseBoolean(gameProperties.getProperty("enforceRules"));
		this.nbStartCards= Integer.parseInt(gameProperties.getProperty("nbStartCards"));
		this.winningScore= Integer.parseInt(gameProperties.getProperty("winningScore"));
	 }


>>>>>>> william

	public int getHuman() {
		return Human;
	}

<<<<<<< HEAD
	public int getNbPlayers() {
		return nbPlayers;
	}


	public int getNbStartCards() {
		return nbStartCards;
=======
	public int getNPC_random() {
		return NPC_random;
>>>>>>> william
	}

	public int getNPC_legal() {
		return NPC_legal;
	}

<<<<<<< HEAD
	public int getNPC_random() {
		return NPC_random;
	}

=======
>>>>>>> william
	public int getNPC_smart() {
		return NPC_smart;
	}

<<<<<<< HEAD
	public boolean getEnforceRules() {
		return enforceRules;
=======
	public String getVersion() {
		return version;
	}

	public int getNbPlayers() {
		return nbPlayers;
	}

	public int getNbStartCards() {
		return nbStartCards;
>>>>>>> william
	}

	public int getWinningScore() {
		return winningScore;
	}

<<<<<<< HEAD
=======
	public boolean isEnforceRules() {
		return enforceRules;
	}
>>>>>>> william
}
