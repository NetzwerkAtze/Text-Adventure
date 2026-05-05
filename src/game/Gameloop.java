package game;

import combat.Combat;
import entity.*;
import story.Color;
import story.Story;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gameloop {
    Scanner scanner = new Scanner(System.in);

    public void playTitle() {
        try {
            Story.typeText(Files.readAllLines(Paths.get("lore/start.txt")), Color.GREEN);
        } catch (Exception e) {}
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
        System.out.println("Choose your Class!");
        System.out.println();
        System.out.println("    (1) " + PlayerClassType.WARRIOR);
        System.out.println("    (2) " + PlayerClassType.MAGE);
        System.out.println("    (3) " + PlayerClassType.RANGER);
        System.out.println();
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
    public void playIntro() {
        try {
            Story.typeText(Files.readAllLines(Paths.get("lore/intro.txt")), Color.BLUE);
        } catch (Exception e) {}
    }

    public void fight(Entity player, Entity enemy){
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println(player.getName() + ": " + player.getHp() + " HP       " + enemy.getName()+ ": " + enemy.getHp() + " HP");
            System.out.println("Choose your next action: ");
            System.out.println("    (1) Attack");
            System.out.println("    (2) " + player.getAbility(1).getName());
            System.out.println("    (3) Flee");
            int input = scanner.nextInt();;
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
