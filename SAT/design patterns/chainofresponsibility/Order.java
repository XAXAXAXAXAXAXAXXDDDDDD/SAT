package chainofresponsibility;

enum Adress {
	DOMESTIC, EUROPEAN_UNION, INTERNATIONAL
};

public class Order {

	private Adress adress;
	private double weight;
	private double length;
	private double height;
	private double width;

	private double price;

	public Order(Adress adress, double weight, double length, double height, double width) {
		super();
		this.adress = adress;
		this.weight = weight;
		this.length = length;
		this.height = height;
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public Adress getAdress() {
		return adress;
	}

	public double getWeight() {
		return weight;
	}

	public boolean isDomestic() {
		return Adress.DOMESTIC == this.adress;
	}

	public boolean isInternational() {
		return Adress.INTERNATIONAL == this.adress;
	}

	public boolean isEuropeanUnion() {
		return Adress.EUROPEAN_UNION == this.adress;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order " + "[Weight=" + this.getWeight() + " kg " + ", L=" + this.getLength() + " cm" + ", W="
				+ this.getWidth() + " cm" + ", H=" + this.getHeight() + " cm" + ", " + this.getAdress() + "]";
	}

}
