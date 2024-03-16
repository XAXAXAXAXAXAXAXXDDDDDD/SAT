package abstractfactory;

public class PizzaOnlineStoreTest {
	public static void main(String[] args) {

		System.out.println("Standard Pizzen: ");
		PizzaOnlineStore store = new PizzaOnlineStore(new StandardPizzaFactory());

		// IllegalArgumentException
		// Pizza pizza = store.orderPizza("Hallelujah");

		Pizza pizza = store.orderPizza("Cheese");
		System.out.println("We ordered a " + pizza);

		pizza = store.orderPizza("Vegetarian");
		System.out.println("We ordered a " + pizza);

		pizza = store.orderPizza("Pepperoni");
		System.out.println("We ordered a " + pizza);

		pizza = store.orderPizza("Calzone");
		System.out.println("We ordered a " + pizza);

		System.out.println("Makkaroni Pizzen: ");
		store = new PizzaOnlineStore(new PizzaMakkaroniFactory());

		pizza = store.orderPizza("Cheese");
		System.out.println("We ordered a " + pizza);

		pizza = store.orderPizza("Vegetarian");
		System.out.println("We ordered a " + pizza);

		pizza = store.orderPizza("Pepperoni");
		System.out.println("We ordered a " + pizza);

		pizza = store.orderPizza("Calzone");
		System.out.println("We ordered a " + pizza);

		System.out.println("Alberto Pizzen: ");
		store = new PizzaOnlineStore(new PizzaAlbertoFactory());

		pizza = store.orderPizza("Cheese");
		System.out.println("We ordered a " + pizza);

		pizza = store.orderPizza("Vegetarian");
		System.out.println("We ordered a " + pizza);

		pizza = store.orderPizza("Pepperoni");
		System.out.println("We ordered a " + pizza);

		pizza = store.orderPizza("Calzone");
		System.out.println("We ordered a " + pizza);

		System.out.println("-------- Reflection --------");
		try {
			// Class.forName("CalzonePizza")
			// CalzonePizza.class
			pizza = store.orderPizzaReflection(CalzonePizza.class);
			System.out.println("We ordered a " + pizza);

			store = new PizzaOnlineStore(new PizzaAlbertoFactory());
			pizza = store.orderPizzaReflection(MakkaroniCalzonePizza.class);
			System.out.println("We ordered a " + pizza);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
