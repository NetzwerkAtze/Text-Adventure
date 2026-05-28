package output;

import entity.Entity;
import entity.PlayerClassType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Output {

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
            System.out.println("Choose your Class!");
            Thread.sleep(500);
            System.out.println();
            System.out.println("    (1) " + PlayerClassType.WARRIOR);
            Thread.sleep(500);
            System.out.println("    (2) " + PlayerClassType.MAGE);
            Thread.sleep(500);
            System.out.println("    (3) " + PlayerClassType.RANGER);
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
    }
    public static void typeText(List<String> lines, Color color) throws IOException, InterruptedException {
        for (String line : lines) {
            typeHelper(line, color);
            Thread.sleep(500);
        }
    }
}
