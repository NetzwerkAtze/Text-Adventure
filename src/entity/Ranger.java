package entity;

import ability.AimedShot;
import ability.BasicAttack;
import ability.Fireball;

public class Ranger implements PlayerClass{

    @Override
    public void applyTo(Entity entity) {
        entity.addAbility(new BasicAttack());
        entity.addAbility(new AimedShot());
    }
}
