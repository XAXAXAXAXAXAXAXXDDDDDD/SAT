package commandpattern;

public class PiCommand extends ZeroCommand {
	
	public PiCommand(Calculator t) {
		super(t);
	}

	protected double calculate() {
		return 3.1415926535897;
	}

	public String getCmdShortCut() {
		return "pi";
	}

}
