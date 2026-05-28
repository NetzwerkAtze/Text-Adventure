package ability.effect;

import entity.Entity;

public class Bleed implements Effect {
    private int duration = 3;
    private static final String NAME = "Bleed";

    @Override
    public void onTurnEnd(Entity entity) {
        int dmg = 5;
        entity.takeDamage(dmg);
        System.out.println(entity.getName() + " bleeds and loses " + dmg + " HP");
        duration--;
    }
    @Override
    public String getName(){
        return NAME;
    }
    @Override
    public boolean isExpired() {
        return duration == 0;
    }
}
