package day;

import entity.Player;
import game.*;
import output.Output;

import java.util.List;
import java.util.Scanner;

public class Day {
    public static int day = 0;
    public static List<Event> earlyEvents = List.of(new WolfAttack());
    public static List<Event> lateEvents = List.of(new Bandits(), new InjuredTrader(), new AbandonedCamp());
    Scanner scanner;

    public Day(Scanner scanner) {
        day = day + 1;
        this.scanner = scanner;
    }

    public void cicle(Player player) {
        if (day > 1) {
        checkHunger(player);
        accessInventory(player);
        }
        if (day <= earlyEvents.size()) {
            earlyEvents.get(day - 1).trigger(player, scanner);
        }
        else {
            lateEvents.get(day - 1 - earlyEvents.size()).trigger(player, scanner);
        }
        player.decreaseHunger();
        Output.dayOver();
        accessInventory(player);
        Output.sleep();
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
        Output.clearInputBuffer(scanner);
        int input;
        while (true) {
            scanner.reset();
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
        }
    }

    public void chooseItem(Player player) {
        Output.chooseItem(player);
        Output.clearInputBuffer(scanner);
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input == player.getInventory().size())
                    return;
                if (input < player.getInventory().size() && input > 0)
                    break;
            }
            Output.noValidValue();
            scanner.nextLine();
        }
        if (input <= player.getInventory().size()) {
            player.getInventory().get(input - 1).use(player);
        }
    }
}
