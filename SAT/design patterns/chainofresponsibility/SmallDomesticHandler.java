package chainofresponsibility;

public class SmallDomesticHandler extends OrderHandler {

	public SmallDomesticHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleOrder(Order o) {
		if (this.checkSmallDomestic(o)) {
			o.setPrice(4.25);
			System.out.print("\thandled by SmallDomesticHandler");
		}

		if (this.getNextHandler() != null) {
			this.getNextHandler().handleOrder(o);
		}
	}

	private boolean checkSmallDomestic(Order o) {
		return o.isDomestic() && (o.getLength() <= 30 && o.getWidth() <= 30 && o.getHeight() <= 15)
				&& o.getWeight() < 2;
	}

}
