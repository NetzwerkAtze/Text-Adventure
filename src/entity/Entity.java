package entity;

import ability.Ability;
import java.util.LinkedList;
import java.util.List;

public class Entity {

    private String name;
    private int hp;
    private int attack;
    private List<Ability> abilities;

    public Entity(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        abilities = new LinkedList<>();
    }
    public boolean isAlive(){
        return hp > 0;
    }
    public void takeDamage(int dmg) {
        hp = hp - dmg < 0 ? 0 : hp - dmg;
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
    public int getHp() {
        return hp;
    }
    public int getAttack() {
        return attack;
    }
    public String getName() {
        return name;
    }
}
