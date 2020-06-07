/**
 * The class will select strategy based on the type of player
 */
class SelectionStrategyFactory {
	//Create new strategy for all type of player
	private final SelectionStrategy randomStrategy =  new RandomStrategy();
	private final SelectionStrategy smartStrategy =  new SmartStrategy();
	private final SelectionStrategy legalStrategy =  new LegalStrategy();
	private SelectionStrategy selectedStrategy;
	
	/**
	 * Will use the strategy based on users type
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
