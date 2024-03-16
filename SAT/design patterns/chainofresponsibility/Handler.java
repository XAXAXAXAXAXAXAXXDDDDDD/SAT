package chainofresponsibility;

public interface Handler {

	public Handler getNextHandler();
	public void handleOrder(Order o);
	
}
