package ability;

import ability.effect.Burn;
import entity.Entity;

import java.util.Random;

public class Fireball implements Ability {
    private static final double ATTACK_MODIFIER = 1.5;
    private static final String NAME = "Fireball";

    @Override
    public void use(Entity user, Entity target) {
        System.out.println(user.getName() +  " casts a Fireball and deals " + (int) (user.getAttack() * ATTACK_MODIFIER) + "dmg!");
        target.takeDamage((int) (user.getAttack() * ATTACK_MODIFIER));
        Random rng = new Random();
        if (rng.nextInt(4) == 0) {
            System.out.println(target.getName() + " is burning!");
            target.addEffect(new Burn());
        }
    }
    @Override
    public String getName(){
        return NAME;
    }
}
