package game;

import ability.PistolShot;
import combat.Combat;
import entity.Player;
import entity.Werewolf;
import output.Output;

import java.util.Scanner;

public class InjuredTrader extends Event {

    public void trigger(Player player, Scanner scanner) {
        Output.injuredTrader();
        Output.yesNo();
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input == Output.YES) {
                    //Kampf
                    Output.werewolfTransform();
                    Werewolf werewolf = new Werewolf();
                    int result = Combat.fight(player, werewolf, scanner);
                    if (result == Combat.RESULT_WIN) {
                        Output.findPistol();
                        int ammunition = 1;
                        player.addAbility(new PistolShot(ammunition));
                    }
                    break;
                }else if (input == Output.NO) {
                    //flucht
                    int dmg;
                    if (player.getHp() > 20)
                        dmg = 20;
                    else
                        dmg = player.getHp() - 1;
                    Output.fleeWerewolf(dmg);
                    player.takeDamage(dmg);
                    break;
                } else
                    Output.noValidValue();
            }
        }
    }
}
