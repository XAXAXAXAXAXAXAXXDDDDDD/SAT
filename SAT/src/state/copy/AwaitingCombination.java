package state.copy;


// only copy file
public class AwaitingCombination extends State {

	private Controller m_controller;

	private static AwaitingCombination m_instance;

	public AwaitingCombination(Controller c) {
		this.m_controller = c;
	}

	public static State enter(Controller c) {
		if (m_instance == null) {
			m_instance = new AwaitingCombination(c);
		}
		return m_instance;
	}

	@Override
	public void combinationEntered() {
		if (m_controller.getLastEnteredPassword().equals(m_controller.getCorrectPassword())) {
			m_controller.changeState(Closed.enter(m_controller));
		} else {
			errorEntered();
		}
	}

	@Override
	public void errorEntered() {
		m_controller.changeState(Locked.enter(m_controller));
	}

}
