package state.copy;

public class Opened extends State {
	
	private Controller m_controller;
	private static Opened m_instance;

	public Opened(Controller c) {
		this.m_controller = c;
	}
	
	public static State enter(Controller c) {
		if (m_instance == null) {
			m_instance = new Opened(c);
		}
		return m_instance;
	}
	
	@Override
	public void close() {
		m_controller.changeState(Closed.enter(m_controller));
	}
}
