package commandpattern;

public abstract class ZeroCommand extends Command {

	protected ZeroCommand(Calculator calc) {
		super(calc);
	}

	@Override
	public void execute() {

		executed = true;
		calc.operandStack.push(calculate());

	}

	@Override
	public void undo() {
		if (executed) {
			calc.operandStack.pop();
		}
	}

	@Override
	public String toString() {
		return "" + this.getCmdShortCut() + "() " + executed;
	}
}