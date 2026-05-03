package combat;

import entity.Entity;

public class Combat {
    public static void fight(Entity a, Entity b){
        int turn = 1;
        while(a.isAlive() && b.isAlive()) {
            System.out.println("--- Runde " + turn + " ---");
            a.useAbility(0, b);
            if (b.isAlive())
                b.useAbility(0, a);
            turn++;
        }
        Entity winner = a.isAlive() ? a : b;
        System.out.println(winner.getName() + " hat gewonnen!");
    }
}
