package entity;

import ability.Ability;
import ability.effect.Effect;
import items.Inventory;
import items.Item;

import java.util.LinkedList;
import java.util.List;

public class Entity {

    protected String name;
    protected CharacterClass characterClass;
    protected int hp;
    protected int attack;
    protected List<Ability> abilities;
    protected List<Effect> effects;
    protected Inventory inventory;

    public Entity(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        abilities = new LinkedList<>();
        effects = new LinkedList<>();
        inventory = new Inventory();
    }
    public boolean isAlive(){
        return hp > 0;
    }
    public void takeDamage(int dmg) {
        hp = hp - dmg < 0 ? 0 : hp - dmg;
    }
    public void setCharacterClass(CharacterClass pc) {
        abilities.clear();
        characterClass = pc;
        pc.applyTo(this);
    }
    public CharacterClass getCharacterClass() {
        return characterClass;
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
    public void heal(int value) { // add later
    }
}
