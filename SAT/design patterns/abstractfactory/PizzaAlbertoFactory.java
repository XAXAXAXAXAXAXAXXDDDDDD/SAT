package abstractfactory;

public class PizzaAlbertoFactory implements AbstractPizzaFactory {

	public PizzaAlbertoFactory() {

	}

	@Override
	public Pizza create(String pizzaType) {
		Pizza pizza = null;

		switch (pizzaType) {
		case "Cheese":
			pizza = new AlbertoCheesePizza();
			break;
		case "Vegetarian":
			pizza = new AlbertoVegetarianPizza();
			break;
		case "Pepperoni":
			pizza = new PepperoniPizza();
			break;
		case "Calzone":
			pizza = new AlbertoCalzonePizza();
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

		if (pizzaType.getClass().getCanonicalName() == CalzonePizza.class.getCanonicalName()) {
			pizza = AlbertoCalzonePizza.class.getDeclaredConstructor().newInstance();
		} else if (pizzaType.getClass().getCanonicalName() == CheesePizza.class.getCanonicalName()) {
			pizza = AlbertoCheesePizza.class.getDeclaredConstructor().newInstance();
		} else if (pizzaType.getClass().getCanonicalName() == VegetarianPizza.class.getCanonicalName()) {
			pizza = VegetarianPizza.class.getDeclaredConstructor().newInstance();
		} else {
			try {
				pizza = (Pizza) pizzaType.getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				return null;
			}
		}

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}
