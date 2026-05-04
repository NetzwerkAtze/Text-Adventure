package entity;

import ability.Ability;
import ability.Effect;

import java.util.LinkedList;
import java.util.List;

public class Entity {

    private String name;
    private int hp;
    private int attack;
    private List<Ability> abilities;
    private PlayerClass playerClass;
    private List<Effect> effects;

    public Entity(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        abilities = new LinkedList<>();
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
    public void processStartOfTurn() {
        if (effects.isEmpty())
            return;
        for (int i = effects.size() -1 ; i >= 0; i--) {
            if (effects.get(i).isExpired())
                effects.remove(i);
            else
                effects.get(i).onTurnStart(this);
        }
    }
    public void processEndOfTurn() {
        if (effects.isEmpty())
            return;
        for (int i = effects.size() -1 ; i >= 0; i--) {
            if (effects.get(i).isExpired())
                effects.remove(i);
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
}
