
package visitor;

import java.util.List;

public class CheapestItemVisitor extends Visitor {
	private Item cheapestItem;

	public Item getCheapestItem() {
		return cheapestItem;
	}

	@Override
	public void visit(FreshVegetable freshVegetable) {
		visitItem(freshVegetable);
	}

	@Override
	public void visit(CannedItem cannedItem) {
		visitItem(cannedItem);
	}

	@Override
	public void visit(Package packageObject) {
		List<Item> items = packageObject.getProducts();
		for (Item i : items)
			visitItem(i);
	}

	private void visitItem(Item item) {
		if (cheapestItem == null || item.getPrice() < cheapestItem.getPrice())
			cheapestItem = item;

	}

	@Override
	public String toString() {
		return "CheapestItem is: " + cheapestItem;
	}
}
