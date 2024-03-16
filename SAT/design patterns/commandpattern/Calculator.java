package commandpattern;

import java.util.Observable;
import java.util.Stack;

public class Calculator extends Observable {

	private Stack<Command> commandStack; // command Stack
	Stack<Double> operandStack; // memory for operands

	public Calculator() {
		commandStack = new Stack<Command>();
		operandStack = new Stack<Double>();
	}

	public void execCommand(Command cmd) {

		// try to execute the last commend before executing the new one
		execLastCommand();

		// execute the new one
		commandStack.push(cmd);
		cmd.execute();

		this.notifyObservers();

	}

	public void clearAll() {
		operandStack.clear();
		commandStack.clear();
		this.notifyObservers();
	}

	public void undo() {
		if (!commandStack.isEmpty()) {
			Command lastCmd = commandStack.pop();
			lastCmd.undo();

			if (!lastCmd.hasBeenExecuted()) {

				if (!commandStack.isEmpty())
					commandStack.pop().undo();
			}

		} 
		else 
			clearOpndStack();

		this.notifyObservers();
	}

	public void setOperand(double operand) {
		this.operandStack.push(operand);
		this.notifyObservers();

	}

	public double getResult() {
		if (operandStack.isEmpty())
			return 0;
		else
			return operandStack.peek();
	}

	public Command execLastCommand() {
		Command lastCmd = null;
		if (!commandStack.isEmpty()) {
			lastCmd = commandStack.peek();
			if (!lastCmd.hasBeenExecuted()) {
				lastCmd.execute();

				// if lastcmd was still not executed it will be deleted
				if (!lastCmd.hasBeenExecuted())
					commandStack.pop();
				this.notifyObservers();

			}
		}
		return lastCmd;

	}

	private void clearOpndStack() {
		if (operandStack.size() >= 2) {
			double top = operandStack.peek();
			operandStack.clear();
			operandStack.push(top);
		}
	}
	public void equalsResult() {

		execLastCommand();

		clearOpndStack();

		commandStack.clear();

		this.notifyObservers();

	}

	public String toString() {
		return "opndstack" + operandStack + " commandStack " + commandStack;
	}

	public void notifyObservers() {
		System.out.println("CalcState: " + this);
		this.setChanged();
		super.notifyObservers();
	}
}
