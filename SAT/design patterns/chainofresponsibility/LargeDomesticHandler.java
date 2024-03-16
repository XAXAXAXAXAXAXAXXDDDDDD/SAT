package chainofresponsibility;

public class LargeDomesticHandler extends OrderHandler {

	public LargeDomesticHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleOrder(Order o) {
		if (this.checkLargeDomestic(o)) {
			o.setPrice(6.75);
			System.out.print("\thandled by LargeDomesticHandler");
		}

		if (this.getNextHandler() != null) {
			this.getNextHandler().handleOrder(o);
		}
	}

	private boolean checkLargeDomestic(Order o) {
		return o.isDomestic() && (o.getLength() <= 60 && o.getWidth() <= 30 && o.getHeight() <= 15)
				&& o.getWeight() <= 5 && o.getWeight() > 2;
	}

}
