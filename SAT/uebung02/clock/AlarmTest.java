package clock;

public class AlarmTest {

	public static void main(String[] args) {
		//Clock c = new Clock(0, 0, 0);

		AlarmClock ac = new AlarmClock(0, 0, 0);
		AlarmListener listener = new SpecialForcesAlarmListener() ;

		// Setze Alarmzeit
		ac.setAlarmTime(0, 1, listener);

		// Schalte Alarm an
		ac.alarmOn();

		for (int i = 0; i < 121; i++) {
			ac.tick();
			System.out.println(ac);
		}
	}
}
