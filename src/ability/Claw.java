package ability;

import ability.effect.Bleed;
import entity.Entity;

import java.util.Random;

public class Claw implements Ability {
    private static final double ATTACK_MODIFIER = 1;
    private static final String NAME = "Claw";

    @Override
    public void use(Entity user, Entity target) {
        System.out.println(user.getName() + " strikes you and deals " + (int) (user.getAttack() * ATTACK_MODIFIER) + "dmg!");
        target.takeDamage((int) (user.getAttack() * ATTACK_MODIFIER));
        Random rng = new Random();
        if (rng.nextInt(4) == 0) {
            System.out.println(target.getName() + " is bleeding!");
            target.addEffect(new Bleed());
        }
    }
    @Override
    public String getName() {
        return NAME;
    }
}
