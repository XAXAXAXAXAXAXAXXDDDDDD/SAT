package visitor;

public abstract class Visitor {
	public abstract void visit(FreshVegetable freshVegetable);

	public abstract void visit(CannedItem cannedItem);

	public abstract void visit(Package packageObject);

}
