package ability;

import entity.Entity;

public class BasicAttack implements Ability {
    private static final String NAME = "BasicAttack";

    @Override
    public void use(Entity user, Entity target) {
        System.out.println(user.getName() +  " attacks " + target.getName() + " and deals " + user.getAttack() + "dmg!");
        target.takeDamage(user.getAttack());

    }
    @Override
    public String getName(){
        return NAME;
    }
}
