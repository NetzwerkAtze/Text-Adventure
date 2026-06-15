package entity;

import items.Food;

public class Player extends Entity {
    protected int hunger;
    protected int maxHunger = 5;

    public Player(String name, int hp, int attack) {
        super(name, hp, attack);
        hunger = maxHunger;
        inventory.add(new Food()); // starting Supply
    }
    public boolean isHungry() { return hunger < maxHunger;}
    public boolean isStarving() {
        return hunger == 0;
    }
    public int starving() {
        hunger = Math.max(hunger - 2, 0);
        if (isStarving()) {
            int dmg = getHp() / 5;
            takeDamage(dmg);
            return dmg;
        }
        return 0;
    }
    public int getHunger() {
        return hunger;
    }
    public void setHunger(int foodValue) {
        hunger = Math.min(hunger + foodValue, maxHunger);
    }
}
