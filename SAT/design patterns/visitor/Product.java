package visitor;

import java.util.List;

public abstract class Product {

	public abstract void accept(Visitor v);

	public abstract double getPrice();

	public abstract List<Item> getProducts();

}
