package state.copy;

public class Locked extends State {

	private Controller m_controller;
	private static Locked m_instance;
	
	public Locked(Controller c) {
		this.m_controller = c;
	}

	public static State enter(Controller c) {
		if (m_instance == null) {
			m_instance = new Locked(c);
		}
		return m_instance;
	}

	@Override
	public void startUnlock() {		
		m_controller.changeState(AwaitingCombination.enter(m_controller));
	}

}
