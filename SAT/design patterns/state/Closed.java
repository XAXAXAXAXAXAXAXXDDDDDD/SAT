package state;

public class Closed implements State {

	private Controller m_controller;
	private static Closed m_instance;

	public Closed(Controller c) {
		this.m_controller = c;
	}

	public static State enter(Controller c) {
		if (m_instance == null)
			m_instance = new Closed(c);
		return m_instance;
	}

	@Override
	public void lock() {
		System.out.println("change state to Locked");
		m_controller.changeState(Locked.enter(m_controller));
	}

	@Override
	public void open() {
		System.out.println("change state to Opened");
		m_controller.changeState(Opened.enter(m_controller));
	}

	@Override
	public void close() {
		System.out.println("door is already closed!");
	}

	@Override
	public void combinationEntered() throws IllegalStateException {
		throw new IllegalStateException("cannot enter combination, door is closed!");
	}

	@Override
	public void errorEntered() throws IllegalStateException {
		throw new IllegalStateException("cannot give error to closed door!");
	}

	@Override
	public void startUnlock() throws IllegalStateException {
		throw new IllegalStateException("door must be locked!");
	}
}
