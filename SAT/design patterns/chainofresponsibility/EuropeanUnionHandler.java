package chainofresponsibility;

public class EuropeanUnionHandler extends OrderHandler {

	public EuropeanUnionHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleOrder(Order o) {
		if (this.checkEuropeanUnion(o)) {
			o.setPrice(10.5);
			System.out.print("\thandled by EuropeanUnionHandler");
		}

		if (this.getNextHandler() != null) {
			this.getNextHandler().handleOrder(o);
		}
	}

	private boolean checkEuropeanUnion(Order o) {
		return o.isEuropeanUnion() && (o.getLength() <= 80 && o.getWidth() <= 60 && o.getHeight() <= 100)
				&& o.getWeight() < 10;
	}

}
