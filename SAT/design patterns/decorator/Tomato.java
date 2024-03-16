package decorator;

public class Tomato extends Ingredient {

	public Tomato(Sandwich wrappee) {
		super(wrappee);
	}

	@Override
	public String toppings() {
		return sandwichWrappee.toppings() + " with Tomato";
	}

	@Override
	public double getCost() {
		return sandwichWrappee.getCost() + 0.2;
	}

}
