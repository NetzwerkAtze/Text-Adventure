package ability;

import entity.Entity;

import java.util.Random;

public class AimedShot implements Ability {
    private static final double ATTACK_MODIFIER = 1.5;
    private static final String NAME = "Aimed Shot";

    @Override
    public void use(Entity user, Entity target) {
        System.out.println(user.getName() + " uses Aimed Shot and deals " + (int) (user.getAttack() * ATTACK_MODIFIER) + "dmg!");
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
