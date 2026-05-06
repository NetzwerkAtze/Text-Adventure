package entity;

import ability.AimedShot;
import ability.BasicAttack;

public class Ranger implements PlayerClass{
    public String name = "Ranger";

    @Override
    public void applyTo(Entity entity) {
        entity.addAbility(new BasicAttack());
        entity.addAbility(new AimedShot());
    }
    @Override
    public String getName() {
        return name;
    }
}
