package abstractfactory;

import java.util.*;

public abstract class Pizza {

	protected String name;
	protected ArrayList<String> toppings = new ArrayList<String>();

	public abstract void prepare();

	public abstract void bake();

	public void cut() {
		System.out.println("Cut " + name);
	}

	public void box() {
		System.out.println("Boxing " + name);
	}

	@Override
	public String toString() {
		String pizzaDescription = "----" + this.name + "----\n";
		if (this.toppings != null && !this.toppings.isEmpty()) {
			pizzaDescription += "Toppings: ";
			pizzaDescription += this.toppings.toString();
			pizzaDescription += "\n";
		}
		return pizzaDescription;
	}

}
