package entity;

import ability.Ability;
import ability.effect.Effect;
import items.Food;
import items.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Entity {

    private String name;
    private int hp;
    private int attack;
    private List<Ability> abilities;
    private PlayerClass playerClass;
    private List<Effect> effects;
    private List<Item> inventory;
    private int inventorySize;
    private int maxInventorySize = 8;
    private int hunger;
    private int maxHunger = 5;

    public Entity(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        abilities = new LinkedList<>();
        effects = new LinkedList<>();
        inventory = new ArrayList<>();
        inventorySize = maxInventorySize;
        hunger = maxHunger;
    }

    public void setPlayerClass(PlayerClass pc) {
        abilities.clear();
        playerClass = pc;
        pc.applyTo(this);
    }
    public PlayerClass getPlayerClass() {
        return playerClass;
    }
    public boolean isAlive(){
        return hp > 0;
    }
    public void takeDamage(int dmg) {
        hp = hp - dmg < 0 ? 0 : hp - dmg;
    }
    public void addEffect(Effect effect) {
        if (effect == null)
            System.out.println("Effekt kann nicht null sein");
        else
            effects.add(effect);
    }
    public void processEndOfTurn() {
        if (effects.isEmpty())
            return;
        for (int i = effects.size() -1 ; i >= 0; i--) {
            if (effects.get(i).isExpired()) {
                System.out.println(getName()+ " is no longer under the effect of " + effects.get(i).getName());
                effects.remove(i);
            }
            else
                effects.get(i).onTurnEnd(this);
        }
    }
    public void addAbility(Ability ability) {
        if (ability == null)
            System.out.println("Ability kann nicht null sein");
        else
            abilities.add(ability);
    }
    public void useAbility(int index, Entity target) {
        if (index >= 0 && index < abilities.size())
            abilities.get(index).use(this, target);
        else
            System.out.println("Kein gültiger Index");
    }
    public Ability getAbility(int index) {
        return abilities.get(index);
    }
    public int fleeIndex() {
        return abilities.size() + 1;
    }
    public int getHp() {
        return hp;
    }
    public int getAttack() {
        return attack;
    }
    public String getName() {
        return name;
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
    public void heal(int value) { // add later
    }
}
