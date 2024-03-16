package abstractfactory;

import java.util.ArrayList;

public class AlbertoCheesePizza extends CheesePizza {

	public AlbertoCheesePizza() {
		super();
		this.name = "Alberto Cheese";
		this.toppings = new ArrayList<String>(3);
	}

	@Override
	public void prepare() {
		this.toppings.clear();

		System.out.println("Preparing 5 min 30 sec " + name + " Pizza");

		this.toppings.add(0, "Cucumber");
		this.toppings.add(1, "Dönerfleisch");
		this.toppings.add(2, "Cheese");
	}

	@Override
	public void bake() {
		System.out.println("Backing 21 min at 355° " + name);
	}

}
