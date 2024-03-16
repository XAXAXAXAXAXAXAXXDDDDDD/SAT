package chainofresponsibility;

public class InternationalHandler extends OrderHandler {

	public InternationalHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleOrder(Order o) {
		if (this.checkInternationalHandler(o)) {
			o.setPrice(30);
			System.out.print("\thandled by InternationalHandler");
		}

		if (this.getNextHandler() != null) {
			this.getNextHandler().handleOrder(o);
		}
	}

	private boolean checkInternationalHandler(Order o) {
		return o.isInternational() && (o.getLength() <= 150 && o.getWidth() <= 60 && o.getHeight() <= 70)
				&& o.getWeight() < 70;
	}

}
