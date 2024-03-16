/**
 * 
 */
package commandpattern;

/**
 * @author
 */
public class MultiplyCommand extends BinaryCommand {

	

	public MultiplyCommand(Calculator t) {
		super(t);
	}

	protected double calculate() {
		return this.operand1 * this.operand2;
	}


	public String getCmdShortCut() {
		return "*";
	}
}
