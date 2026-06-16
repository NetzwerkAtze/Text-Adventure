package day;

import entity.Player;
import output.Output;

import java.util.Scanner;

public class Day {
    public static int day = 0;
    Scanner scanner = new Scanner(System.in);

    public Day() {
        day = day + 1;
    }

    public void cicle(Player player) {
        checkHunger(player);
        accessInventory(player);
        // presented with event like fight or something
        // player chooses to engage event or disengage
        // play even / consequences of disengaging
        // event over sun goes down access to items again chance to eat or heal -> sleep
        // next day
    }

    public static int getDay() {
        return day;
    }

    public void checkHunger(Player player) {
        int dmg = player.starving();
        if (dmg > 0)
            Output.starving(dmg);
        else
            Output.notStarving();
    }

    public void accessInventory(Player player) {
        Output.accessInventory();
        Output.yesNo();
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input <= 2 && input > 0)
                    break;
            }
            Output.noValidValue();
            scanner.nextLine();
        }
        if (input == 1) {
            player.getInventory().showItems();
            chooseItem(player);
        } else
            return;
    }

    public void chooseItem(Player player) {
        Output.chooseItem(player);
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input <= player.getInventory().size() + 1 && input > 0)
                    break;
            }
            Output.noValidValue();
            scanner.nextLine();
        }
        if (input <= player.getInventory().size() + 1) {
            player.getInventory().get(input - 1).use(player);
        } else
            return;
    }
}
