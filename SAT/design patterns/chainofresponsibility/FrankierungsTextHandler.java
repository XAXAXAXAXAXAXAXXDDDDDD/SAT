package chainofresponsibility;

public class FrankierungsTextHandler extends FrankierungsHandler {

	public FrankierungsTextHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	protected String getFrankierung(Order o) {
		return " frankiert mit ";
	}

}
