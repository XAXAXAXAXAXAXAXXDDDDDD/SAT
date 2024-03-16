package visitor;

public class Main {
	public static void main(String[] args) {

		Package p1 = new Package();
		Package p2 = new Package();

		FreshVegetable fv1 = new FreshVegetable(0.99);
		CannedItem ci1 = new CannedItem(1.90);
		p1.add(fv1);
		p1.add(ci1);

		FreshVegetable fv2 = new FreshVegetable(0.55);
		CannedItem ci2 = new CannedItem(2.34);
		p2.add(fv2);
		p2.add(ci2);

		// Package2 in P1 hinzufügen
		p1.add(p2);

		System.out.println(p1 + "\n");

		// CheapestItem
		Visitor cheapestItemVisitor = new CheapestItemVisitor();
		p1.accept(cheapestItemVisitor);
		System.out.println(cheapestItemVisitor);

		// ReducePrice
		Visitor reducePriceVisitor = new ReducePriceVisitor(0.13);
		p1.accept(reducePriceVisitor);
		System.out.println(reducePriceVisitor);

		System.out.print("\n--- price after decrease ---");
		System.out.println(p1);
	}
}