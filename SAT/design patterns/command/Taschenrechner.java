package command;

import java.util.Observable;
import java.util.Stack;

public class Taschenrechner extends Observable {
	Stack<Double> stackOperands;

	private double result;
	private double currOperand;
	private double lastOperand;

	public Taschenrechner() {
		stackOperands = new Stack<Double>();
	}

	public double getResult() {
		return this.result;
	}

	public void setOperand(String input) {
		this.currOperand = Double.parseDouble(input);
	}

	public void notifyObservers() {
		this.setChanged();
		super.notifyObservers();
	}

	public double add() {
		this.stackOperands.push(currOperand);
		this.result = this.lastOperand + this.currOperand;
		this.lastOperand = this.result;

		this.notifyObservers();
		return this.result;
	}

	public double sub() {
		this.stackOperands.push(currOperand);
		this.result = this.lastOperand - this.currOperand;
		this.lastOperand = this.result;

		this.notifyObservers();
		return this.result;
	}

	public double mult() {
		this.stackOperands.push(currOperand);
		this.result = this.lastOperand * this.currOperand;
		this.lastOperand = this.result;

		this.notifyObservers();
		return this.result;
	}

	public double div() {
		if (this.currOperand == 0) {
			this.currOperand = 1;
		}
		this.stackOperands.push(currOperand);
		this.result = this.lastOperand / this.currOperand;
		this.lastOperand = this.result;

		this.notifyObservers();
		return this.result;
	}

	public double addLastOperand() {
		if (stackOperands.isEmpty())
			return this.result;

		this.currOperand = stackOperands.pop();
		this.result = this.lastOperand + this.currOperand;
		this.lastOperand = this.result;

		this.notifyObservers();
		return this.result;
	}

	public double subLastOperand() {
		if (stackOperands.isEmpty())
			return this.result;

		this.currOperand = stackOperands.pop();
		this.result = this.lastOperand - this.currOperand;
		this.lastOperand = this.result;

		this.notifyObservers();
		return this.result;
	}

	public double multLastOperand() {
		if (stackOperands.isEmpty())
			return this.result;

		this.currOperand = stackOperands.pop();
		this.result = this.lastOperand * this.currOperand;
		this.lastOperand = this.result;

		this.notifyObservers();
		return this.result;
	}

	public double divLastOperand() {
		if (stackOperands.isEmpty())
			return this.result;

		this.currOperand = stackOperands.pop();
		if (this.currOperand == 0) {
			this.currOperand = 1;
		}

		this.result = this.lastOperand / this.currOperand;
		this.lastOperand = this.result;

		this.notifyObservers();
		return this.result;
	}

	public void setLastOp(double lO) {
		this.lastOperand = lO;
	}
}
