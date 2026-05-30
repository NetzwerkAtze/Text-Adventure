package items;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory extends ArrayList<Item> {
    int startingSize = 8;
    int inventorySize;

    public Inventory() {
        inventorySize = startingSize;
    }
    public void showItems(){
        if (this.isEmpty())
            System.out.println("You have no items.");
        Iterator<Item> it = this.iterator();
        while (it.hasNext()) {
            it.next().getName();
        }
    }
    public void addItem(Item item) {
        if (this.size() < inventorySize) {
            this.add(item);
            System.out.println(item.getName() + " added to your inventory.");
        }
        else
            System.out.println("Inventory full");
    }
    public int getInventorySize() {
        return inventorySize;
    }
}
