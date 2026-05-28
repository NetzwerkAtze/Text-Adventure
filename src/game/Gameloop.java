package game;

import combat.Combat;
import entity.*;

import output.Output;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gameloop {
    private int day = 0;
    Scanner scanner = new Scanner(System.in);

    public void dayCicle(Entity player) {
        while (player.isAlive()) {
            day++;
            checkHunger(player);

            // acces to inventory (rasten und inventory untersuchen oder aufbrechen -> triggert event)
            // presented with event like fight or something
            // player chooses to engage event or disengage
            // play even / consequences of disengaging
            // event over sun goes down access to items again chance to eat or heal -> sleep
            // next day
        }
    }

    public void playTitle() {
        Output.playTitle();
        try {
            System.in.read();
            scanner.nextLine();
        } catch (Exception e) {}
    }
    public String chooseName(){
        System.out.println("Choose your Name: ");
        return scanner.nextLine();
    }
    public PlayerClass chooseClass() throws InputMismatchException {
        Output.chooseClass();
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input <= PlayerClassType.values().length && input > 0)
                    break;
            }
            System.out.println("No valid value!");
            scanner.nextLine();
        }
        if (input == PlayerClassType.WARRIOR.getId()) {
            return new Warrior();
        }
        if (input == PlayerClassType.MAGE.getId()) {
            return new Mage();
        }
        return new Ranger();
    }
    public void checkHunger(Entity player) {
        int dmg = player.starving();
        if (dmg > 0)
            Output.starving(dmg);
        else
            Output.notStarving();
    }
    public void fight(Entity player, Entity enemy){
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println(player.getPlayerClass().getName() + " " + player.getName() + ": " + player.getHp() + " HP       " + enemy.getName()+ ": " + enemy.getHp() + " HP");
            System.out.println("Choose your next action: ");
            for (int i = 0; i < player.fleeIndex()-1; i ++) {
                int index = i + 1;
                System.out.println("    ("+index+") "+ player.getAbility(i).getName());
            }
            System.out.println("    ("+player.fleeIndex()+") Flee");
            int input = scanner.nextInt();;
            if (input == player.fleeIndex()) {
                System.out.println("You have fled the fight!");
                return;
            }
            Combat.fight(player, enemy, input);
            if (player.isAlive())
                player.processEndOfTurn();
            if (enemy.isAlive())
                enemy.processEndOfTurn();
        }
        if (!enemy.isAlive())
            System.out.println("You have slain " + enemy.getName() + "!");
        else
            System.out.println("You died!");
    }
    public int getDay() {
        return day;
    }
}
