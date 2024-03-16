package command;

public class AddCommand implements ICommandWithUndo {

	private Taschenrechner taschenrechner;

	public AddCommand(Taschenrechner t) {
		this.taschenrechner = t;
	}

	@Override
	public void ausfuehren() {
		taschenrechner.add();
	}

	@Override
	public void undo() {
		taschenrechner.subLastOperand();
	}

}
