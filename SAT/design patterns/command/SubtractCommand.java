package command;

public class SubtractCommand implements ICommandWithUndo {

	private Taschenrechner taschenrechner;
	
	public SubtractCommand(Taschenrechner t) {
		this.taschenrechner = t;
	}

	@Override
	public void ausfuehren() {
		taschenrechner.sub();
	}

	@Override
	public void undo() {
		taschenrechner.addLastOperand();
	}

}
