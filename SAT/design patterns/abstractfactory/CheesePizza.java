package abstractfactory;

public class CheesePizza extends Pizza {

	public CheesePizza() {
		this.name = "Cheese";
	}
	
	@Override
	public void prepare() {
		System.out.println("Preparing 5 min " + name + " Pizza");
	}

	@Override
	public void bake() {
		System.out.println("Backing 25 min at 350° " + name);
	}
	
}
