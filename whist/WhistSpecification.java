import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class WhistSpecification {
	private String property;
	
	private static int Human;
	private static int NPC_random;
	private static int NPC_legal;
	private static int NPC_smart;
	public final int nbPlayers = 4;
	public static int nbStartCards;
	public static int winningScore = 11;
	private static boolean enforceRules = false;
	  
	public WhistSpecification(String property) {
		this.property=property;
		
	}
	
	
	public void setSpec() throws IOException {	
		
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
		
		Human = Integer.parseInt(gameProperties.getProperty("Human"));
		NPC_random = Integer.parseInt(gameProperties.getProperty("NPC_random"));
		NPC_legal = Integer.parseInt(gameProperties.getProperty("NPC_legal"));
		NPC_smart = Integer.parseInt(gameProperties.getProperty("NPC_random"));
		enforceRules = Boolean.parseBoolean(gameProperties.getProperty("enforceRules"));
		nbStartCards = Integer.parseInt(gameProperties.getProperty("nbStartCards"));
		winningScore = Integer.parseInt(gameProperties.getProperty("winningScore"));
		
	}
	

}
