package decorator;

public class Meat extends Ingredient {

	public Meat(Sandwich wrappee) {
		super(wrappee);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toppings() {
		return sandwichWrappee.toppings() + " with Meat";
	}

	@Override
	public double getCost() {
		return sandwichWrappee.getCost() + 0.6;
	}

}
