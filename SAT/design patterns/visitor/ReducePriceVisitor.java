package visitor;

import java.util.List;

public class ReducePriceVisitor extends Visitor {

	private double decreaseAmount;

	public ReducePriceVisitor(double amount) {
		if (amount > 0)
			this.decreaseAmount = amount;
		else
			this.decreaseAmount = 0;
	}

	@Override
	public void visit(FreshVegetable freshVegetable) {
		if (freshVegetable.price - decreaseAmount >= 0)
			freshVegetable.price -= decreaseAmount;
	}

	@Override
	public void visit(CannedItem cannedItem) {
		if (cannedItem.price - decreaseAmount >= 0)
			cannedItem.price -= decreaseAmount;
	}

	@Override
	public void visit(Package packageObject) {
		List<Item> items = packageObject.getProducts();

		for (Item i : items) {
			if (i.price - decreaseAmount >= 0) // reduzierter Betrag darf nicht größer als item Preis sein
				i.price -= decreaseAmount;
		}
	}

	@Override
	public String toString() {
		return "decreasedAmount: " + decreaseAmount + "€";
	}
}
