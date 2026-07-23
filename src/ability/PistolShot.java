package ability;

import entity.Entity;

public class PistolShot implements Ability {
    private static final double ATTACK_MODIFIER = 3;
    private static final String NAME = "Pistol Shot";
    private int ammuniton;

    public PistolShot(int ammuniton) {
        this.ammuniton = ammuniton;
    }

    @Override
    public void use(Entity user, Entity target) {
        if (ammuniton > 0) {
            System.out.println(user.getName() + " shoots with his pistol and deals " + (int) (user.getAttack() * ATTACK_MODIFIER) + "dmg!");
            target.takeDamage((int) (user.getAttack() * ATTACK_MODIFIER));
            ammuniton--;
        }
        else {
            System.out.println("You pull the trigger, but nothing happens. The revolver is empty. Panic takes over, and you freeze for a moment.");
        }
    }
    @Override
    public String getName() {
        return NAME;
    }
}
