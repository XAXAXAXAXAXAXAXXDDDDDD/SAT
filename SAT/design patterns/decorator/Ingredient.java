package decorator;

public abstract class Ingredient implements Sandwich {

	private double cost;
	protected Sandwich sandwichWrappee;

	public Ingredient(Sandwich wrappee) {
		this.sandwichWrappee = wrappee;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Sandwich getSandwichWrappee() {
		return sandwichWrappee;
	}
}
