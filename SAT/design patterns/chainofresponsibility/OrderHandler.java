package chainofresponsibility;

public abstract class OrderHandler implements Handler {

	private Handler nextHandler;

	public OrderHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public Handler getNextHandler() {
		return nextHandler;
	}

	public abstract void handleOrder(Order o);
}
