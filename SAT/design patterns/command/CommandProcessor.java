package command;

import java.util.Stack;

public class CommandProcessor {

	Stack<ICommandWithUndo> undoCommandHistory;
	Stack<ICommandWithUndo> redoCommandHistory;

	public CommandProcessor() {
		undoCommandHistory = new Stack<ICommandWithUndo>();
		redoCommandHistory = new Stack<ICommandWithUndo>();
	}

	public void befehlAusfuehren(ICommand c) {
		if (ICommandWithUndo.class.isAssignableFrom(c.getClass())) {
			undoCommandHistory.push((ICommandWithUndo) c);
		}
		c.ausfuehren();
	}

	public void undoLetztenBefehl() {
		if (!undoCommandHistory.isEmpty()) {
			ICommandWithUndo c = undoCommandHistory.pop();
			c.undo();
			redoCommandHistory.push(c);
		}
	}

	public void redoLetztenBefehl() {
		if (!redoCommandHistory.isEmpty()) {
			ICommandWithUndo c = redoCommandHistory.pop();
			c.ausfuehren();
			undoCommandHistory.push(c);
		}
	}

}
