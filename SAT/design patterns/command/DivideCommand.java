package command;

public class DivideCommand implements ICommandWithUndo {

	private Taschenrechner taschenrechner;
	
	public DivideCommand(Taschenrechner t) {
		this.taschenrechner = t;
	}

	@Override
	public void ausfuehren() {
		taschenrechner.div();
	}

	@Override
	public void undo() {
		taschenrechner.multLastOperand();
	}

}
