package output;

import entity.CharacterClassType;
import entity.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Output {
    public static final int YES = 1;
    public static final int NO = 2;
    public static void receiveItem(String name) {
        try {
            typeHelper("You receive  " + name + " and add it to your inventory.", Color.GREEN);
        } catch (Exception e) {}

    }
    public static void slain(String name) {
        try {
            typeHelper("You have slain " + name + "!", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void youDied() {
        try {
            typeHelper("You died!", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void youFled() {
        try {
            typeHelper("You have fled the fight!", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void healthBars(String className, String playerName, int playerHP, String enemyName, int enemyHP) {
        try {
            typeHelper(className +" " + playerName + ": " + playerHP + " HP     " + enemyName + ": " + enemyHP +  " HP", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void chooseAction() {
        try {
            typeHelper("Choose your next action: ", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void displayAbility(int number, String name) {
        try {
            typeHelper("    ("+number+") "+ name, Color.GREEN);
        } catch (Exception e) {}
    }
    public static void wolfAttack() {
        try {
            typeHelper("You hear howling in the distance, growing louder with every passing moment. A pack of wolves is closing in on your position. Will you stand your ground and fight, or hide and hope they pass you by?", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void fleeWolfAttack(int dmg) {
        try {
            typeHelper("You try to hide and jump into a bramble bush. The thorns scratch you, and you take " + dmg + " damage.", Color.GREEN);
        } catch (Exception e) {}
    }

    public static void displayItem(int number, String name) {
        try {
            typeHelper("Item " + number + " " + name, Color.GREEN);
        } catch (Exception e) {}
    }
    public static void chooseItem(Player player) {
        try {
            typeHelper("Please enter Number of item to use", Color.GREEN);
            typeHelper("Enter " + (player.getInventory().size() + 1) + " to quit.", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void accessInventory() {
        try {
        typeHelper("Do you want to access your inventory?", Color.GREEN);

        } catch (Exception e) {}
    }
    public static void chooseName(){
        try {
            typeHelper("Choose your Name: ", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void noValidValue(){
        try {
            typeHelper("No valid value!", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void yesNo() {
        try {
            typeHelper("(1) Yes", Color.GREEN);
            typeHelper("(2) No", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void starving( int dmg) {
        try {
        typeHelper("You wake with a hollow ache in your stomach as hunger gnaws at your strength. Starvation deals " + dmg + " damage.", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void notStarving() {
        try {
            typeHelper("You wake feeling rested, the first light of dawn creeping across the room.", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void playTitle() {
        try {
            Output.typeText(Files.readAllLines(Paths.get("lore/start.txt")), Color.GREEN);
        } catch (Exception e) {}
    }
    public static void playIntro() {
        try {
            Output.typeText(Files.readAllLines(Paths.get("lore/intro.txt")), Color.BLUE);
        } catch (Exception e) {}
    }
    public static void chooseClass() {
        try {
            System.out.println("Choose your Class: ");
            Thread.sleep(500);
            System.out.println();
            System.out.println("    (1) " + CharacterClassType.WARRIOR);
            Thread.sleep(500);
            System.out.println("    (2) " + CharacterClassType.MAGE);
            Thread.sleep(500);
            System.out.println("    (3) " + CharacterClassType.RANGER);
            System.out.println();
        } catch (Exception e) {}
    }
    public static void typeHelper(String text, Color color) throws InterruptedException {
        String chosenColor = "";
        if (color == Color.RED)
            chosenColor = "\u001B[31m";
        else if (color == Color.GREEN)
            chosenColor = "\u001B[32m";
        else if (color == Color.YELLOW)
            chosenColor = "\u001B[33m";
        else if (color == Color.BLUE)
            chosenColor = "\u001B[34m";
        if (color != Color.NONE) {
            for (char c : text.toCharArray()) {
                System.out.print(chosenColor + c);
                Thread.sleep(100);
            }
        }
        else {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                Thread.sleep(100);
            }
        }
        System.out.println("\u001B[0m");
        Thread.sleep(500);
    }
    public static void typeText(List<String> lines, Color color) throws IOException, InterruptedException {
        for (String line : lines) {
            typeHelper(line, color);
            Thread.sleep(500);
        }
    }
}
