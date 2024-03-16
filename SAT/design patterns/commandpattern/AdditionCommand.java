/**
 * 
 */
package commandpattern;

/**
 * @author
 */
public class AdditionCommand extends BinaryCommand {

	public AdditionCommand(Calculator t) {
		super(t);
	}

	protected double calculate() {
		return this.operand1 + this.operand2;
	}

	public String getCmdShortCut() {
		return "+";
	}
}
