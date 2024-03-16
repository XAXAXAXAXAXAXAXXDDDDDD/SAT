/**
 * 
 */
package commandpattern;

/**
 * @author
 */
public abstract class Command implements Cloneable {

	protected Calculator calc;

	protected Command(Calculator calc) {
		this.calc = calc;
	}

	protected boolean executed = false;

	/**
	 * Ausf�hren des Kommandos
	 * 
	 */
	public abstract void execute();

	/**
	 * Ist das Kommando vollst�ndig ausgef�hrt?
	 * 
	 * @return true, falls erforderliche Anzahl an Operatoren verf�gbar und
	 *         Kommando erfolgreich ausgef�hrt worden false, andernfalls
	 * 
	 */
	public boolean hasBeenExecuted() {
		return executed;
	}

	/**
	 * R�ckg�ngig machen des Kommandos
	 */
	public abstract void undo();

	/**
	 * @return Kommando mit allen Operatoren und KommandoShortCut als String
	 */
	public abstract String toString();

	/**
	 * @return Kommandok�rzel als String
	 */
	public abstract String getCmdShortCut();

	/**
	 * @return eigentliche Berechnung des Kommandos; nur f�r Unterklassen
	 *         gedacht
	 */
	protected abstract double calculate();

	/**
	 * @return die Kopie des Kommandos
	 */
	public Command clone() {

		try {
			return (Command) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}