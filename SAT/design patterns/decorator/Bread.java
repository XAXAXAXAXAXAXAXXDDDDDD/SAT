package decorator;

public class Bread extends Ingredient {

	public Bread(Sandwich wrappee) {
		super(wrappee);
	}

	@Override
	public String toppings() {
		return sandwichWrappee.toppings() + " with Bread";
	}

	@Override
	public double getCost() {
		return sandwichWrappee.getCost() + 0.5;
	}

}
