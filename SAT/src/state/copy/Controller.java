package state.copy;
import java.util.Scanner;

public class Controller {
	
	private State m_state;
	private String lastEnteredPassword;
	private final String CORRECT_PASSWORD = "schwubidub123";
	
	private static Scanner input = new Scanner(System.in);
	
	public Controller() {
		this.m_state = Closed.enter(this);
		this.lastEnteredPassword = "";
	}
	
	public void changeState(State newState) {
		this.m_state = newState;
	}

	public void run() {
		
	}

	public String getLastEnteredPassword() {
		return lastEnteredPassword;
	}

	public void setLastEnteredPassword(String lastEnteredPassword) {
		this.lastEnteredPassword = lastEnteredPassword;
	}
	
	public String getCorrectPassword() {
		return CORRECT_PASSWORD;
	}
	
	public void openGarage() {
		m_state.open();
	}
	
	public void closeGarage() {
		m_state.close();
	}
	
	public void lockGarage() {
		m_state.lock();
	}
	
	public void unlockGarage() {
		m_state.startUnlock();
	}
}
