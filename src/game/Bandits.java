package game;

import combat.Combat;
import entity.Bandit;
import entity.Player;
import items.Item;
import output.Output;

import java.util.Scanner;

public class Bandits extends Event {

    public void trigger(Player player, Scanner scanner) {
        Output.banditsArrive();
        Output.chooseOptions("Fight","Pay toll");
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input == Output.OPTION_ONE) {
                    //Kampf
                    Output.banditAttack();
                    Bandit banditLeader = new Bandit();
                    int result = Combat.fight(player, banditLeader, scanner);
                    if (result == Combat.RESULT_WIN) {
                        int pendantPower = 30;
                        Output.banditWin(pendantPower);
                        player.heal(pendantPower);
                    }
                    break;
                }else if (input == Output.OPTION_TWO) {
                    //flucht
                    if (player.getInventory().isEmpty()) {
                        int beatingDmg = 30;
                        Output.payTollNoItems(beatingDmg);
                        player.takeDamage(30);
                    }
                    else {
                        Item item = player.getInventory().remove(0);
                        Output.payToll(item.getName());
                    }
                    break;
                } else
                    Output.noValidValue();
            }
        }
    }
}
