package abstractfactory;

public class StandardPizzaFactory implements AbstractPizzaFactory {

	@Override
	public Pizza create(String pizzaType) {
		Pizza pizza = null;

		switch (pizzaType) {
		case "Cheese":
			pizza = new CheesePizza();
			break;
		case "Vegetarian":
			pizza = new VegetarianPizza();
			break;
		case "Pepperoni":
			pizza = new PepperoniPizza();
			break;
		case "Calzone":
			pizza = new CalzonePizza();
			break;
		default:
			throw new IllegalArgumentException();
		}

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

	@Override
	public Pizza create(Class<?> pizzaType) throws Exception {
		Pizza pizza = null;

		if (Pizza.class.isAssignableFrom(pizzaType)) {
			pizza = (Pizza) pizzaType.getDeclaredConstructor().newInstance();
		}

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}
