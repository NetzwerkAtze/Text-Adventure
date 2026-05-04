package combat;

import entity.Entity;

public class Combat {
    public static void fight(Entity player, Entity enemy, int action){
            player.useAbility(action-1, enemy);
            enemy.useAbility(0, player);
    }
}
