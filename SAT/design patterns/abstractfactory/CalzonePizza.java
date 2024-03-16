package abstractfactory;

public class CalzonePizza extends Pizza {

	public CalzonePizza() {
		this.name = "Calzone";
	}

	@Override
	public void prepare() {
		System.out.println("Preparing 6 min " + name + " Pizza");
	}

	@Override
	public void bake() {
		System.out.println("Backing 30 min at 350° " + name);
	}

	@Override
	public void cut() {
		System.out.println("No Cut " + name);
	}

	@Override
	public void box() {
		System.out.println("Choosing special box for " + name);
	}
	
}
