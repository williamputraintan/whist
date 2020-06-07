// Edited by Team101: William Putra Intan(955545), Franklin Aldo Darmansa (1025392), Patricia Angelica Budiman (1012861)
/**
 * An exception thrown when a player breaks a rule
 */
@SuppressWarnings("serial")
public class BrokeRuleException extends Exception {
	public BrokeRuleException(String violation) {
		super(violation);
	}
}
