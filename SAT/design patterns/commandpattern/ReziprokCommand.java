/**
 * 
 */
package commandpattern;

/**
 * @author
 */
public class ReziprokCommand extends UnaryCommand {

	public ReziprokCommand(Calculator t) {
		super(t);
	}

	protected double calculate() {
		// currently no exception handling
		if (super.operand1 == 0)
			operand1 = 1;
		return 1/super.operand1;
	}

	public String getCmdShortCut() {
		return "1/";
	}

}
