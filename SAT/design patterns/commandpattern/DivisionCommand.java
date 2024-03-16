/**
 * 
 */
package commandpattern;

/**
 * @author
 */
public class DivisionCommand extends BinaryCommand {

	public DivisionCommand(Calculator t) {
		super(t);
	}

	protected double calculate() {
		// currently no exception handling
		if (operand2 == 0)
			operand2 = 1;
		return this.operand1 / this.operand2;
	}


	public String getCmdShortCut() {
		return "/";
	}
}
