package state.copy;

public abstract class State {

	public void combinationEntered() {
		System.out.print("Keine Eingabe!");
	}

	public void lock() {
		System.out.print("Abschließprozess nicht startbar!");
	}

	public void startUnlock() {
		System.out.print("Öffnungsprozess nicht startbar!");
	}

	public void close() {
		System.out.print("Schließen nicht möglich!");
	}

	public void open() {
		System.out.print("Öffnen nicht möglich!");
	}

	public void errorEntered() {
		System.out.print("Keine Eingabe!");
	}
}
