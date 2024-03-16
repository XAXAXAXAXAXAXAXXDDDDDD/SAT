package visitor;

import java.util.LinkedList;
import java.util.List;

public class FreshVegetable extends Item{


    public FreshVegetable(double price) {
        this.price = price;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public List<Item> getProducts() {
        List<Item> freshVegetableItems = new LinkedList<>();

        freshVegetableItems.add(this);
        return freshVegetableItems;
    }

    @Override
    public String toString() {
        String formattedPrice = String.format("%.2f", price); // 2 Nachkommastellen formatiert
        return "FreshVegetable price: " + formattedPrice + "€";
    }
}
