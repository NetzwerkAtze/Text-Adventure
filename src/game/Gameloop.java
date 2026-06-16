package game;

import combat.Combat;
import day.Day;
import entity.*;

import output.Output;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gameloop {
    private int day = 0;
    Scanner scanner = new Scanner(System.in);

    public void loop(Player player) {
        while (player.isAlive() && Day.getDay() < 10) {
            Day day = new Day();
        }
        if (!player.isAlive())
            System.out.println("You dead bro");
        else
            System.out.println("You won!");
    }
    public void playTitle() {
        Output.playTitle();
        try {
            System.in.read();
            scanner.nextLine();
        } catch (Exception e) {}
    }
    public void playIntro() {
        Output.playIntro();
        try {
            System.in.read();
            scanner.nextLine();
        } catch (Exception e) {
        }
    }
    public String chooseName(){
        Output.chooseName();
        return scanner.nextLine();
    }
    public CharacterClass chooseClass() throws InputMismatchException {
        Output.chooseClass();
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input <= CharacterClassType.values().length && input > 0)
                    break;
            }
            Output.noValidValue();
            scanner.nextLine();
        }
        if (input == CharacterClassType.WARRIOR.getId()) {
            return new Warrior();
        }
        if (input == CharacterClassType.MAGE.getId()) {
            return new Mage();
        }
        return new Ranger();
    }
}
