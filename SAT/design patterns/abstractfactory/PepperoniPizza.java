package abstractfactory;

public class PepperoniPizza extends Pizza {

	public PepperoniPizza() {
		this.name = "Pepperoni";
	}

	@Override
	public void prepare() {
		System.out.println("Preparing 4 min " + name + " Pizza");
	}

	@Override
	public void bake() {
		System.out.println("Backing 27 min at 350° " + name);
	}

}
