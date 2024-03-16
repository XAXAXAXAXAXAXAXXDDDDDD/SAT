package decorator;

public class WholeBreadSandwich implements Sandwich {

	public WholeBreadSandwich() {

	}

	@Override
	public String toppings() {
		return "Bread";
	}

	@Override
	public double getCost() {
		return 0.5;
	}

}
