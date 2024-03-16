package chainofresponsibility;

public abstract class FrankierungsHandler implements Handler {

	private Handler nextHandler;

	public FrankierungsHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public Handler getNextHandler() {
		return nextHandler;
	}

	public void handleOrder(Order o) {
		System.out.print(getFrankierung(o));
		if (this.getNextHandler() != null) {
			this.getNextHandler().handleOrder(o);
		}
	}

	protected abstract String getFrankierung(Order o);

}
