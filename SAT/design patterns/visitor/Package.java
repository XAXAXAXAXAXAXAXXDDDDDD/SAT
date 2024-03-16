package visitor;

import java.util.LinkedList;
import java.util.List;

public class Package extends Product {

	private List<Product> products;

	public Package() {
		products = new LinkedList<Product>();
	}

	public void add(Product p) {
		products.add(p);
	}

	@Override
	public List<Item> getProducts() {
		List<Item> items = new LinkedList<>();

		for (Product p : products)
			items.addAll(p.getProducts());

		return items;
	}

	@Override
	public void accept(Visitor visitor) {
		for (Product p : products)
			p.accept(visitor);
	}

	@Override
	public double getPrice() {
		double totalPrice = 0;

		for (Product p : products)
			totalPrice += p.getPrice();

		return totalPrice;
	}

	@Override
	public String toString() {
		return "\nPackage products  \n" + products;
	}
}
