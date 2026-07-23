package game;

import combat.Combat;
import entity.Player;
import entity.WolfPack;
import items.Food;
import output.Output;

import java.util.Scanner;

public class WolfAttack extends Event {

    public void trigger(Player player, Scanner scanner) {
        Output.wolfAttack(); // string output in der output klasse
        Output.chooseOptions("Fight", "Hide");
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input == Output.OPTION_ONE) {
                    //Kampf
                    WolfPack wolfPack = new WolfPack();
                    int result = Combat.fight(player, wolfPack, scanner);
                    if (result == Combat.RESULT_WIN) {
                        Output.receiveItem("Wolf meat");
                        int wolfMeatValue = 3;
                        //evtl. später frage ob inventory full ist ergänzen und fallunterscheidung
                        player.getInventory().addItem(new Food("Wolf meat", wolfMeatValue));
                    }
                    break;
                } else if (input == Output.OPTION_TWO) {
                    //flucht
                    int dmg;
                    if (player.getHp() > 10)
                        dmg = 10;
                    else
                        dmg = player.getHp() - 1;
                    Output.fleeWolfAttack(dmg);
                    player.takeDamage(dmg);
                    break;
                } else
                    Output.noValidValue();
            }
        }
    }
}
