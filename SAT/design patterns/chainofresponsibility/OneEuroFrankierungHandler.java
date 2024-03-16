package chainofresponsibility;

public class OneEuroFrankierungHandler extends FrankierungsHandler {

	public OneEuroFrankierungHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	protected String getFrankierung(Order o) {
		int wholePrice = (int) o.getPrice();
		if (wholePrice > 0) {
			return wholePrice + "x 1€ ";
		} else {
			return "";
		}
	}

}
