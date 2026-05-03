package ability;

import entity.Entity;

public class HeavyAttack implements Ability {
    private static final double ATTACK_MODIFIER = 1.5;

    @Override
    public void use(Entity user, Entity target) {
        System.out.println(user.getName() +  " greift " + target.getName() + " mit Heavy Attack an!");
        target.takeDamage((int) (user.getAttack() * ATTACK_MODIFIER));
        System.out.println(target.getName() + " hat noch " + target.getHp() + " HP.");
    }
}

