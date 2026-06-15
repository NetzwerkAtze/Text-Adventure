package entity;

import ability.BasicAttack;
import ability.HeavyStrike;

public class Warrior implements CharacterClass {
    public String name = "Warrior";

    @Override
    public void applyTo(Entity entity) {
        entity.addAbility(new BasicAttack());
        entity.addAbility(new HeavyStrike());
    }
    @Override
    public String getName() {
        return name;
    }
}
