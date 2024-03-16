package decorator;

public class Cheese extends Ingredient {

	public Cheese(Sandwich wrappee) {
		super(wrappee);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toppings() {
		return sandwichWrappee.toppings() + " with Cheese";
	}

	@Override
	public double getCost() {
		return sandwichWrappee.getCost() + 0.5;
	}

}
