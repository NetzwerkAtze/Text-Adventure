package entity;

import items.Food;
import items.Item;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player extends Entity {
    protected int inventorySize;
    protected int maxInventorySize = 8;
    protected int hunger;
    protected int maxHunger = 5;

    public Player(String name, int hp, int attack) {
        super(name, hp, attack);
        inventorySize = maxInventorySize;
        hunger = maxHunger;
        inventory.add(new Food()); // starting Supply
    }
    public boolean isHungry() {
        return hunger == 0;
    }
    public int starving() {
        hunger = Math.max(hunger - 2, 0);
        if (isHungry()) {
            int dmg = getHp() / 5;
            takeDamage(dmg);
            return dmg;
        }
        return 0;
    }
    @Override
    public void addItem(Item item) {
        if (inventory.size() < inventorySize) {
            inventory.add(item);
            System.out.println(item.getName() + " added to your inventory.");
        }
        else
            System.out.println("Inventory full");
    }
    public int getInventorySize() {
        return inventorySize;
    }
    public void eat(Food food) {
        hunger = Math.min(hunger + food.getHungerValue(), maxHunger);
    }
}
