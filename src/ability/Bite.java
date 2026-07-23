package ability;

import entity.Entity;



public class Bite implements Ability {
    private static final double ATTACK_MODIFIER = 1;
    private static final String NAME = "Bite";

    @Override
    public void use(Entity user, Entity target) {
        System.out.println(user.getName() + " bit you and deals " + (int) (user.getAttack() * ATTACK_MODIFIER) + "dmg!");
        target.takeDamage((int) (user.getAttack() * ATTACK_MODIFIER));
    }
    @Override
    public String getName() {
        return NAME;
    }
}
