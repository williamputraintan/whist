/**
 * The class will select strategy based on the type of player
 */
// Edited by Team101: William Putra Intan(955545), Franklin Aldo Darmansa (1025392), Patricia Angelica Budiman (1012861)
public class SelectionStrategyFactory {
	//Create new strategy for all type of player
	private final SelectionStrategy randomStrategy =  new RandomStrategy();
	private final SelectionStrategy smartStrategy =  new SmartStrategy();
	private final SelectionStrategy legalStrategy =  new LegalStrategy();
	private SelectionStrategy selectedStrategy;
	
	/**
	 * Will use the strategy based on user's type
	 * @param users type
	 * @return the strategy used for the player
	 */
	public SelectionStrategy getSelectionStrategy(String type) {
		if(type.equals("random")) {
			selectedStrategy= randomStrategy;
		}
		else if(type.equals("legal")) {
			selectedStrategy=  legalStrategy;
		}
		else if(type.equals("smart")) {
			selectedStrategy= smartStrategy;
		}
		return selectedStrategy;
	}

}
