package decorator;

public class Pickles extends Ingredient {

	public Pickles(Sandwich wrappee) {
		super(wrappee);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toppings() {
		return sandwichWrappee.toppings() + " with Pickles";
	}

	@Override
	public double getCost() {
		return sandwichWrappee.getCost() + 0.1;
	}

}
