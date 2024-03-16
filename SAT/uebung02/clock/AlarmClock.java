package clock;

public class AlarmClock extends SettableClock {

	protected AlarmListener alarmListener;
	protected boolean isAlarmOn;
	protected int alarmHour;
	protected int alarmMinute;

	public AlarmClock(int hour, int minute, int second) {
		super(hour, minute, second);
		isAlarmOn = false;

		checkInvariants();
	}

	public void setAlarmTime(int hour, int minute, AlarmListener listener) {
		checkInvariants();
		if (listener == null || hour < 0 || hour >= 24 || minute < 0 || minute >= 60) {
			throw new IllegalArgumentException();
		}

		this.alarmHour = hour;
		this.alarmMinute = minute;
		this.alarmListener = listener;

		checkInvariants();
		assert alarmListener != null && alarmHour == hour && alarmMinute == minute : "Alarm nicht falsch gesetzt";
	}

	public void alarmOn() {
		this.isAlarmOn = true;
	}

	public void alarmOff() {
		this.isAlarmOn = false;
	}

	@Override
	public void tick() {
		checkInvariants();

		if (isAlarmOn) {
			if (this.getHour() == alarmHour && this.minute == alarmMinute) {
				alarmListener.alarm();
			}
		}

		super.tick();

		checkInvariants();
	}

	@Override
	protected void checkInvariants() {
		super.checkInvariants();
	}
}
