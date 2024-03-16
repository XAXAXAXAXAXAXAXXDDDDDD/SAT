package abstractfactory;

public class PizzaMakkaroniFactory implements AbstractPizzaFactory {

	public PizzaMakkaroniFactory() {

	}

	@Override
	public Pizza create(String pizzaType) {
		Pizza pizza = null;

		switch (pizzaType) {
		case "Cheese":
			pizza = new MakkaroniCheesePizza();
			break;
		case "Vegetarian":
			pizza = new MakkaroniVegetarianPizza();
			break;
		case "Pepperoni":
			pizza = new PepperoniPizza();
			break;
		case "Calzone":
			pizza = new MakkaroniCalzonePizza();
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
			pizza = MakkaroniCalzonePizza.class.getDeclaredConstructor().newInstance();
		} else if (pizzaType.getClass().getCanonicalName() == CheesePizza.class.getCanonicalName()) {
			pizza = MakkaroniCheesePizza.class.getDeclaredConstructor().newInstance();
		} else if (pizzaType.getClass().getCanonicalName() == VegetarianPizza.class.getCanonicalName()) {
			pizza = MakkaroniVegetarianPizza.class.getDeclaredConstructor().newInstance();
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
