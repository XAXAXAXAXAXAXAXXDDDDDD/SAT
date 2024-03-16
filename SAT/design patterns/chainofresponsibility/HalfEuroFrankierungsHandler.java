package chainofresponsibility;

public class HalfEuroFrankierungsHandler extends FrankierungsHandler {

	public HalfEuroFrankierungsHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	protected String getFrankierung(Order o) {
		if (o.getPrice() - (int) o.getPrice() == 0.50) {
			return "1x 0,5€ ";
		} else {
			return "";
		}
	}

}
