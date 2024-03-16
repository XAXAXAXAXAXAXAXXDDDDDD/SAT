package state;

import java.util.Scanner;

public class Controller {
	private State m_state;

	public Controller() {
		changeState(Closed.enter(this)); // Defaultzustand
	}

	public void changeState(State s) {
		this.m_state = s;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);

		System.out.println("enter state (x = exit): close, open, unlock, combination, error, lock: ");

		while (true) {
			try {
				String s = sc.next();
				if (s.equals("close"))
					this.m_state.close();
				if (s.equals("open"))
					this.m_state.open();
				if (s.equals("unlock"))
					this.m_state.startUnlock();
				if (s.equals("combination"))
					this.m_state.combinationEntered();
				if (s.equals("error"))
					this.m_state.errorEntered();
				if (s.equals("lock"))
					this.m_state.lock();

				if (s.equals("x"))
					break;
				
				System.out.println("enter state ((x = exit): close, open, unlock, combination, error, lock: ");
			} catch (IllegalStateException e) {
				System.out.println("WARNING: " + e.getMessage());
				System.out.println("enter state ((x = exit): close, open, unlock, combination, error, lock: ");
			}
		}

		sc.close();
	}
}
