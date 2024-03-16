package state.copy;

public class Closed extends State {

	private Controller m_controller;
	private static Closed m_instance;

	public Closed(Controller c) {
		this.m_controller = c;
	}
	
	public static State enter(Controller c) {
		if (m_instance == null) {
			m_instance = new Closed(c);
		}
		return m_instance;
	}
	
	@Override
	public void lock() {
		m_controller.changeState(Locked.enter(m_controller));
	}
	
	@Override
	public void open() {
		m_controller.changeState(Opened.enter(m_controller));
	}
}
