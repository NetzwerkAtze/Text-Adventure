package game;

import combat.Combat;
import entity.*;

import java.util.Scanner;

public class Gameloop {
    Scanner scanner = new Scanner(System.in);

    public int input() {
        return scanner.nextInt();
    }
    public String chooseName(){
        System.out.println("Choose your Name: ");
        return scanner.next();
    }
    public PlayerClass chooseClass(){
        System.out.println("Choose your Class!");
        System.out.println();
        System.out.println("    (1) " + PlayerClassType.WARRIOR);
        System.out.println("    (2) " + PlayerClassType.MAGE);
        System.out.println("    (3) " + PlayerClassType.RANGER);
        System.out.println();
        int input = input();
        while (input > PlayerClassType.values().length || input < 1) {
            System.out.println("No valid input.");
            input = input();
        }
        if (input == PlayerClassType.WARRIOR.getId()) {
            System.out.println("You are a Warrior!");
            return new Warrior();
        }
        if (input == PlayerClassType.MAGE.getId()) {
            System.out.println("You are a Mage!");
            return new Warrior();
        }
        System.out.println("You are a Ranger!");
        return new Ranger();
    }

    public void fight(Entity player, Entity enemy){
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println(player.getName() + ": " + player.getHp() + " HP       " + enemy.getName()+ ": " + enemy.getHp() + " HP");
            System.out.println("Choose your next action: ");
            System.out.println("    (1) Attack");
            System.out.println("    (2) " + player.getAbility(1).getName());
            System.out.println("    (3) Flee");
            int input = input();
            if (input == player.fleeIndex()) {
                System.out.println("You have fled the fight!");
                break;
            }
            Combat.fight(player, enemy, input);
        }
        if (!enemy.isAlive())
            System.out.println("You have slain " + enemy.getName() + "!");
        else
            System.out.println("You died!");
    }
}
