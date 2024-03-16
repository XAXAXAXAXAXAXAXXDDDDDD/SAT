package visitor;

import java.util.LinkedList;
import java.util.List;

public class CannedItem extends Item{

    public CannedItem(double price) {
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public List<Item> getProducts() {
        List<Item> cannedItems = new LinkedList<>();

        cannedItems.add(this);
        return cannedItems;
    }


    @Override
    public String toString() {
        String formattedPrice = String.format("%.2f", price); // 2 Nachkommastellen formatiert
        return "CannedItem price: " + formattedPrice + "€";
    }
}
