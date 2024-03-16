package chainofresponsibility;

public class QuarterEuroFrankierungsHandler extends FrankierungsHandler {

	public QuarterEuroFrankierungsHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	protected String getFrankierung(Order o) {
		if (o.getPrice() - (int) o.getPrice() == 0.75 || o.getPrice() - (int) o.getPrice() == 0.25) {
			return "1x 0,25€ ";
		} else {
			return "";
		}
	}

}
