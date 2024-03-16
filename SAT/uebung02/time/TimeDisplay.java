package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeDisplay {

	TimeProvider timeProvider;

	public TimeDisplay(TimeProvider timeProvider) {
		this.timeProvider = timeProvider;
	}

	public String getCurrentTimeAsHtmlFragment() {
		return getCurrentTimeAsHtmlFragment(this.timeProvider.getTime());
	}

	public String getCurrentTimeAsHtmlFragment(Calendar currentTime) {
		// übergebene Uhrzeit darf nicht null sein (Anmerkung: Uhrzeit muss auch gültig
		// sein, aber hier wurde die Überprüfung weggelassen)
		if (currentTime == null)
			return "currentTime is null!";

		return simpleDateFormatterAs_HTML(currentTime);
	}

	private boolean isMidnight(Calendar time) {
		int hour = time.get(Calendar.HOUR_OF_DAY); // anstatt Calendar.HOUR (12-Stunden Uhr) => Calendar.HOUR_OF_DAY
													// (24-Stunden Uhr)
		int minute = time.get(Calendar.MINUTE);
		// int second = time.get(Calendar.SECOND); // nicht unbedingt notwendig

		return hour == 0 && minute == 0; // && second == 0
	}

	private String simpleDateFormatterAs_HTML(Calendar time) {
		if (isMidnight(time))
			return "<span class=\"tinyBoldText\">MidNight</span>";
		else {
			SimpleDateFormat formatter = new SimpleDateFormat("E hh:mm:ss a");
			String timeFormatted = formatter.format(time.getTime());
			return "<span class=\"tinyBoldText\">" + timeFormatted + "</span>";
		}
	}
}
