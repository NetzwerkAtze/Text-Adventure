package ability;

import entity.Entity;

public class BasicAttack implements Ability {
    @Override
    public void use(Entity user, Entity target) {
        System.out.println(user.getName() +  " greift " + target.getName() + " an!");
        target.takeDamage(user.getAttack());
        System.out.println(target.getName() + " hat noch " + target.getHp() + " HP.");
    }
}
