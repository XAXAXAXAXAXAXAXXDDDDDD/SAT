package decorator;

public class Client {

	public static void main(String[] args) {

		Sandwich sandwich = new WholeBreadSandwich();
		System.out.println(sandwich.toppings() + " Price: " + sandwich.getCost() + " €");
		
		Sandwich sandwich_Cheese = new Cheese(sandwich);
		System.out.println(sandwich_Cheese.toppings() + " Price: " + sandwich_Cheese.getCost() + " €");
		
		Sandwich sandwich_Cheese_Meat = new Meat(sandwich_Cheese);
		System.out.println(sandwich_Cheese_Meat.toppings() + " Price: " + sandwich_Cheese_Meat.getCost() + " €");
		
		Sandwich sandwich_Cheese_Meat_Pickles = new Pickles(sandwich_Cheese_Meat);
		System.out.println(sandwich_Cheese_Meat_Pickles.toppings() + " Price: " + sandwich_Cheese_Meat_Pickles.getCost() + " €");
		
		Sandwich sandwich_Cheese_Meat_Pickles_Cheese = new Cheese(sandwich_Cheese_Meat_Pickles);
		System.out.println(sandwich_Cheese_Meat_Pickles_Cheese.toppings() + " Price: " + sandwich_Cheese_Meat_Pickles_Cheese.getCost() + " €");
		
		Sandwich sandwich_Cheese_Meat_Pickles_Cheese_Tomato = new Tomato(sandwich_Cheese_Meat_Pickles_Cheese);
		System.out.println(sandwich_Cheese_Meat_Pickles_Cheese_Tomato.toppings() + " Price: " + sandwich_Cheese_Meat_Pickles_Cheese_Tomato.getCost() + " €");
	}

}
