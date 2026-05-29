package items;

import entity.Entity;

public class Food extends Item {
    private String name = "food";
    private int hungerValue = 2;

    public String getName() {
        return name;
    }
    public int getHungerValue() {
        return hungerValue;
    }
}
