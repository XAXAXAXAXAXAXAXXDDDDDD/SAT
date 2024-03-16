/**
 * 
 */
package commandpattern;

/**
 * @author
 */
public class SubtractionCommand extends BinaryCommand {
	
	public SubtractionCommand(Calculator t) {
		super(t);
	}

	protected double calculate() {
		return this.operand1 - this.operand2;
	}

	public String getCmdShortCut() {
		return "-";
	}
}
