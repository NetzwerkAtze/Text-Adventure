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
        System.out.println("You have " + size() + "/" + getInventorySize() + " inventory space.");
        if (this.isEmpty())
            System.out.println("You have no items.");
        else {
            Iterator<Item> it = this.iterator();
            int i = 1;
            while (it.hasNext()) {
                System.out.println("Item " + i + ": " + it.next().getName());
                i++;
            }
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
