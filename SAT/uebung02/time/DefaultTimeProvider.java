package time;

import java.util.Calendar;

public class DefaultTimeProvider implements TimeProvider {
	
	public Calendar getTime() { return  Calendar.getInstance();};

}
