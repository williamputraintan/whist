
class SelectionStrategyFactory {
	private final SelectionStrategy randomStrategy =  new RandomStrategy();
	private final SelectionStrategy smartStrategy =  new SmartStrategy();
	private final SelectionStrategy legalStrategy =  new LegalStrategy();
	private SelectionStrategy selectedStrategy;
	
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
