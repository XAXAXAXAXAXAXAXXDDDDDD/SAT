package visitor;

public abstract class Item extends Product {
	protected double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "Item price: " + price + "€";
	}
}
