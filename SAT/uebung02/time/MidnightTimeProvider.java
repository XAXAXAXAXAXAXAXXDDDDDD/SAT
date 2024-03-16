package time;

import java.util.Calendar;

public class MidnightTimeProvider implements TimeProvider {

	@Override
	public Calendar getTime() {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.AM, 0);

		return c;
	}

}
