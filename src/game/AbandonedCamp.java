package game;

import combat.Combat;
import entity.Entity;
import entity.Player;
import entity.SkeletalMage;
import items.Food;
import output.Output;

import java.util.Scanner;

public class AbandonedCamp extends Event {

    public void trigger(Player player, Scanner scanner) {
        Output.abandonedCamp();
        Output.chooseOptions("Fight","Leave");
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input == Output.OPTION_ONE) {
                    //Kampf
                    Entity skelet = new SkeletalMage();
                    int result = Combat.fight(player, skelet, scanner);
                    if (result == Combat.RESULT_WIN) {
                        int ringPower = 5;
                        Output.skeletWin(ringPower);
                        player.increaseAttack(ringPower);
                        player.getInventory().addItem(new Food("Old Cured Meat", 2));
                    }
                    break;
                } else if (input == Output.OPTION_TWO) {
                    //flucht
                    Output.abandonedLeave();

                    break;
                } else
                    Output.noValidValue();
            }
        }
    }
}
