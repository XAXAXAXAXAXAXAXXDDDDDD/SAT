package time;

public class TimeContainer {

	public static TimeDisplay CreateTimeDisplay() {
		return new TimeDisplay(new DefaultTimeProvider());
	}

	public static TimeDisplay CreateMidNightTimeDisplay() {
		return new TimeDisplay(new MidnightTimeProvider());
	}

}
