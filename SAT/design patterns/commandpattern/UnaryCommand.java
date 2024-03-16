package commandpattern;

public abstract class UnaryCommand extends Command {

	protected double operand1;

	protected UnaryCommand(Calculator calc) {
		super(calc);
	}

	@Override
	public void execute() {

		// // if operand stack is empty put 0 as a default
		if (calc.operandStack.isEmpty())
			calc.setOperand(0);

		executed = true;
		operand1 = calc.operandStack.pop();
		calc.operandStack.push(calculate());

	}

	@Override
	public void undo() {
		if (executed) {
			calc.operandStack.pop();
			calc.operandStack.push(operand1);
		}
	}

	@Override
	public String toString() {
		return "" + this.getCmdShortCut() + "(" + operand1 + ") " + executed;
	}
}