package ability;

import entity.Entity;

public class HeavyStrike implements Ability {
    private static final double ATTACK_MODIFIER = 1.5;
    private static final String NAME = "Heavy Strike";

    @Override
    public void use(Entity user, Entity target) {
        System.out.println(user.getName() + " does a Heavy Strike and deals " + (int) (user.getAttack() * ATTACK_MODIFIER) + "dmg!");
        target.takeDamage((int) (user.getAttack() * ATTACK_MODIFIER));
    }
    @Override
    public String getName() {
        return NAME;
    }
}

