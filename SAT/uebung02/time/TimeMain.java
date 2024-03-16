package time;

public class TimeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TimeDisplay t = TimeContainer.CreateTimeDisplay();
		
		System.out.println(t.getCurrentTimeAsHtmlFragment());

	}

}
