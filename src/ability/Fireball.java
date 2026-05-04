package ability;

import entity.Entity;

public class Fireball implements Ability {
    private static final double ATTACK_MODIFIER = 1.5;
    private static final String NAME = "Fireball";

    @Override
    public void use(Entity user, Entity target) {
        System.out.println(user.getName() +  " casts a Fireball and deals " + (int) (user.getAttack() * ATTACK_MODIFIER) + "dmg!");
        target.takeDamage((int) (user.getAttack() * ATTACK_MODIFIER));
    }
    @Override
    public String getName(){
        return NAME;
    }
}
