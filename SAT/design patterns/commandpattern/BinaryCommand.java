package commandpattern;

public abstract class BinaryCommand extends Command {

	protected double operand1, operand2;

	protected BinaryCommand(Calculator calc) {
		super(calc);
	}

	@Override
	public void execute() {
		
//		// if operand stack is empty put 0 as a default
		if (calc.operandStack.isEmpty())
			calc.setOperand(0);
		
		if (calc.operandStack.size() == 1) 
			operand1 = calc.operandStack.peek();
		

		if (calc.operandStack.size() == 2) {
			executed = true;
			operand2 = calc.operandStack.pop();
			operand1 = calc.operandStack.pop();
			calc.operandStack.push(calculate());
		}

	}

	@Override
	public void undo() {
		if (executed) {
			calc.operandStack.pop();
			calc.operandStack.push(operand1);
		} else if (calc.operandStack.size() == 2)
			calc.operandStack.pop();
	}

	@Override
	public String toString() {
		return "" + this.getCmdShortCut() + "(" + operand1 + "," + operand2
				+ ") " + executed;

	}
}
