package items;

import entity.Player;

public class Food extends Item {
    private String name = "food";
    private int foodValue = 2;

    public String getName() {
        return name;
    }
    public int getFoodValue() {
        return foodValue;
    }
    public boolean use(Player player) {
        if (player.isHungry()) {
            player.setHunger(foodValue);
            System.out.println("You eat " + name + " and restore to " + player.getHunger() + " hunger.");
            return true;
        }
        else {
            System.out.println("You are not hungry.");
            return false;
        }
    }
}
