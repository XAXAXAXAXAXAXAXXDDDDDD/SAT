package abstractfactory;

public class PizzaOnlineStore {

	protected AbstractPizzaFactory pizzaFactory;

	public PizzaOnlineStore(AbstractPizzaFactory pizzaFactory) {
		this.pizzaFactory = pizzaFactory;
	}

	public Pizza orderPizza(String pizzaType) {

		Pizza pizza = pizzaFactory.create(pizzaType);

		return pizza;
	}

	public Pizza orderPizzaReflection(Class<?> class1) {

		Pizza pizza = null;
		
		try {
			pizza = pizzaFactory.create(class1);
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}

		return pizza;
	}
}
