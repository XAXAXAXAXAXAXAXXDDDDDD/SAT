package abstractfactory;

import java.util.ArrayList;

public class MakkaroniCheesePizza extends CheesePizza {

	public MakkaroniCheesePizza() {
		super();
		this.toppings = new ArrayList<String>(3);
		this.name = "Makkaroni Cheese";
	}

	@Override
	public void prepare() {
		this.toppings.clear();

		System.out.println("Preparing 6 min " + name + " Pizza");

		this.toppings.add(0, "Olives");
		this.toppings.add(1, "Mushrooms");
		this.toppings.add(2, "Cheese");
	}

	@Override
	public void bake() {
		System.out.println("Backing 26 min at 350° " + name);
	}

}
