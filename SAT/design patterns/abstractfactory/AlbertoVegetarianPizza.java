package abstractfactory;

import java.util.ArrayList;

public class AlbertoVegetarianPizza extends VegetarianPizza {

	public AlbertoVegetarianPizza() {
		super();
		this.name = "Alberto Vegetarian";
		this.toppings = new ArrayList<String>(3);
	}

	@Override
	public void prepare() {
		this.toppings.clear();		
		
		System.out.println("Preparing 3 min " + name + " Pizza");
		
		this.toppings.add(0, "Cucumber");
		this.toppings.add(1, "Tomato");
		this.toppings.add(2, "Chicken Nuggets");
	}

	@Override
	public void bake() {
		System.out.println("Backing 23 min at 350° " + name);
	}

}
