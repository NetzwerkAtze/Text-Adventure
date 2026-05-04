package entity;

import ability.BasicAttack;
import ability.HeavyStrike;

public class Warrior implements PlayerClass {

    @Override
    public void applyTo(Entity entity) {
        entity.addAbility(new BasicAttack());
        entity.addAbility(new HeavyStrike());
    }
}
