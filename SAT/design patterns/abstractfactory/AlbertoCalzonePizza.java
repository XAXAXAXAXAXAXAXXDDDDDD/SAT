package abstractfactory;

import java.util.ArrayList;

public class AlbertoCalzonePizza extends CalzonePizza {

	public AlbertoCalzonePizza() {
		super();
		this.name = "Alberto Calzone";
		this.toppings = new ArrayList<String>(3);
	}

	@Override
	public void prepare() {
		this.toppings.clear();

		System.out.println("Preparing 6 min " + name + " Pizza");

		this.toppings.add(0, "Cucumber");
		this.toppings.add(1, "Radish");
		this.toppings.add(2, "Cheese");
	}

	@Override
	public void bake() {
		System.out.println("Backing 30 min at 350° " + name);
	}

}
