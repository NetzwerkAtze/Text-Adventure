package combat;

import entity.Entity;
import output.Output;

import java.util.Scanner;

public class Combat {
    public static final int RESULT_WIN = 1;
    public static final int RESULT_LOSS = 2;
    public static final int RESULT_FLED = 0;
    public static void fightHelper(Entity player, Entity enemy, int action){
            player.useAbility(action-1, enemy);
            enemy.useAbility(0, player);
    }
    /*

     */
    public static int fight(Entity player, Entity enemy, Scanner scanner){
        while (player.isAlive() && enemy.isAlive()) {
            Output.healthBars(player.getCharacterClass().getName(), player.getName(), player.getHp(), enemy.getName(), enemy.getHp());
            Output.chooseAction();
            for (int i = 0; i < player.fleeIndex()-1; i ++) {
                int index = i + 1;
                Output.displayAbility(index, player.getAbility(i).getName());
            }
            Output.displayAbility(player.fleeIndex(),"Flee");
            int input;
            while (true) {
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                    if (input == player.fleeIndex()) {
                        Output.youFled();
                        return RESULT_FLED;
                    }
                    if (input > player.getAbilities().size()) {
                        Output.noValidValue();
                    }
                    else {
                        fightHelper(player, enemy, input);
                        if (player.isAlive())
                            player.processEndOfTurn();
                        if (enemy.isAlive())
                            enemy.processEndOfTurn();
                        break;
                    }
                }
            }
        }
        if (!enemy.isAlive()) {
            Output.slain(enemy.getName());
            return RESULT_WIN;
        }
        else {
            Output.youDied();
            return RESULT_LOSS;
        }
    }
}
