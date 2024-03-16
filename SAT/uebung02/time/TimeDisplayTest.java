package time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeDisplayTest {

	@Test
	void testGetCurrentTimeAsHtmlFragment() {
		TimeDisplay t = TimeContainer.CreateMidNightTimeDisplay();
		assertEquals("<span class=\"tinyBoldText\">MidNight</span>", t.getCurrentTimeAsHtmlFragment());
	}

}
