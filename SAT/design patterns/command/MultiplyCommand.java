package command;

public class MultiplyCommand implements ICommandWithUndo {

	private Taschenrechner taschenrechner;
	
	public MultiplyCommand(Taschenrechner t) {
		this.taschenrechner = t;
	}

	@Override
	public void ausfuehren() {
		taschenrechner.mult();
	}

	@Override
	public void undo() {
		taschenrechner.divLastOperand();
	}

}
