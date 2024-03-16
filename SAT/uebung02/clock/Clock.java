package clock;

public class Clock {

	protected int hour;
	protected int minute;
	protected int second;

	public Clock(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;

		// hier bereits?
		checkInvariants();
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	public void tick() {
		checkInvariants();

		int previous_Hour = hour;
		int previous_Minute = minute;
		int previous_Second = second;

		this.second++;
		if (this.second >= 60) {
			this.minute++;
			this.second = 0;

			if (this.minute >= 60) {
				this.hour++;
				this.minute = 0;

				if (this.hour >= 24) {
					this.hour = 0;
				}
			}
		}

		// Postcondition: ist die Uhrzeit richtig weiter geschaltet? (um 1 Sekunde
		// erhöht)
		assert (getSecond() == (previous_Second + 1) && (getMinute() == previous_Minute && getHour() == previous_Hour))
				|| (getSecond() == 0 && getMinute() == (previous_Minute + 1) && getHour() == previous_Hour)
				|| (getSecond() == 0 && getMinute() == 0 && getHour() == (previous_Hour + 1))
				: "Uhrzeit nicht korrekt erhöht!!";

		checkInvariants();
	}

	protected void checkInvariants() {
		assert hour < 24 : hour;
		assert hour >= 0 : hour;

		assert minute < 60 : minute;
		assert minute >= 0 : minute;

		assert second < 60 : second;
		assert second >= 0 : second;
	}

	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
}
