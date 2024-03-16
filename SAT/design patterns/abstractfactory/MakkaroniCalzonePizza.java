package abstractfactory;

import java.util.ArrayList;

public class MakkaroniCalzonePizza extends CalzonePizza {

	public MakkaroniCalzonePizza() {
		super();
		this.toppings = new ArrayList<String>(3);
		this.name = "Makkaroni Calzone";
	}

	@Override
	public void prepare() {
		this.toppings.clear();
		
		System.out.println("Preparing 6 min " + name + " Pizza");
		
		this.toppings.add(0, "Chili Cheese");
		this.toppings.add(1, "Dönerfleisch");
		this.toppings.add(2, "Cheese");
	}

	@Override
	public void bake() {
		System.out.println("Backing 30 min at 350° " + name);
	}

}
