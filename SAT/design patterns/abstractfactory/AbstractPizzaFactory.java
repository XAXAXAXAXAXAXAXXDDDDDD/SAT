package abstractfactory;

public interface AbstractPizzaFactory {

	public Pizza create(String pizzaName);

	public Pizza create(Class<?> pizzaType) throws Exception;

}
