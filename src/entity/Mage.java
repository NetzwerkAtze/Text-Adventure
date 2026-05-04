package entity;

import ability.BasicAttack;
import ability.Fireball;

public class Mage implements PlayerClass{
    @Override
    public void applyTo(Entity entity) {
        entity.addAbility(new BasicAttack());
        entity.addAbility(new Fireball());
    }
}
