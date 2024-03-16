package abstractfactory;

public class VegetarianPizza extends Pizza {

	public VegetarianPizza() {
		this.name = "Vegetarian";
	}
		
	@Override
	public void prepare() {
		System.out.println("Preparing 3 min " + name + " Pizza");
	}

	@Override
	public void bake() {
		System.out.println("Backing 20 min at 350° " + name);
	}	
}
