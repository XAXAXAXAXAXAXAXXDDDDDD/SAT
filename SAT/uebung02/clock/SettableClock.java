package clock;

public class SettableClock extends Clock {

	public SettableClock(int hour, int minute, int second) {
		super(hour, minute, second);
	}

	public void setTime(int hour, int minute) {
		checkInvariants();

		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException();
		}
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException();
		}

		this.hour = hour;
		this.minute = minute;

		assert this.getHour() == hour && this.getMinute() == minute && this.getSecond() == 0
				: "Uhrzeit wurde nicht korrekt gesetzt";

		checkInvariants();
	}

	@Override
	protected void checkInvariants() {
		super.checkInvariants();
	}
}
