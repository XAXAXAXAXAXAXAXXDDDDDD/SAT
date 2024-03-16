package chainofresponsibility;

public class HugeDomesticHandler extends OrderHandler {

	public HugeDomesticHandler(Handler oneF) {
		super(oneF);
	}

	@Override
	public void handleOrder(Order o) {
		if (this.checkHugeDomestic(o)) {
			o.setPrice(25.5);
			System.out.print("\thandled by HugeDomesticHandler");
		}

		if (this.getNextHandler() != null) {
			this.getNextHandler().handleOrder(o);
		}
	}

	private boolean checkHugeDomestic(Order o) {
		return o.isDomestic() && (o.getLength() <= 60 && o.getWidth() <= 30 && o.getHeight() <= 15)
				&& o.getWeight() > 5;
	}

}

