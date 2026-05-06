package entity;

import ability.BasicAttack;
import ability.Fireball;

public class Mage implements PlayerClass{
    public String name = "Mage";

    @Override
    public void applyTo(Entity entity) {
        entity.addAbility(new BasicAttack());
        entity.addAbility(new Fireball());
    }
    @Override
    public String getName(){
        return name;
    }
}
