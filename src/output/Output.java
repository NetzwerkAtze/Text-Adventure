package output;

import entity.CharacterClassType;
import entity.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Output {
    public static final int OPTION_ONE = 1;
    public static final int OPTION_TWO = 2;
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
    public static void payTollNoItems(int dmg) {
        try {
            typeHelper("You have nothing to pay the toll with. The bandits beat you badly before leaving you behind. You take " + dmg + "damage.", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void payToll(String itemName) {
        try {
            typeHelper("You pay the toll with your " + itemName + ". The bandits let you continue your journey without trouble. ", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void injuredTrader() {
        try {
            typeHelper("You come across a wounded merchant lying by the side of the road. Blood seeps from a deep bite wound on his arm. He looks at you with pleading eyes, barely able to speak. Will you help him ?",Color.GREEN);
        } catch (Exception e) {}
    }
    public static void werewolfTransform() {
        try {
            typeHelper("You help the wounded merchant through the forest. With every step, he grows weaker until he suddenly collapses. Moments later, his body begins to change. Bones crack, fur grows, and a werewolf rises before you. It attacks!", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void wolfAttack() {
        try {
            typeHelper("You hear howling in the distance, growing louder with every passing moment. A pack of wolves is closing in on your position. Will you stand your ground and fight, or hide and hope they pass you by?", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void fleeWerewolf(int dmg) {
        try {
            typeHelper("You turn and run, but the werewolf is too fast. Its claws rake across your back before you manage to escape, leaving a deep wound. and you take " + dmg + " damage.", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void banditsArrive() {
        try{
            typeHelper("As you follow the narrow forest path, several armed bandits step out from the trees, blocking your way. Their leader grins as they surround you. They demand a toll. Do you pay or do you fight?", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void banditAttack() {
        try {
            typeHelper("The bandit leader attacks you!", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void findPistol() {
        try {
            typeHelper("As the werewolf's body lies motionless, you search it. Hidden beneath the torn clothing, you discover a revolver with one bullet left.", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void fleeWolfAttack(int dmg) {
        try {
            typeHelper("You try to hide and jump into a bramble bush. The thorns scratch you, and you take " + dmg + " damage.", Color.GREEN);
        } catch (Exception e) {}
    }
    public static void banditWin(int amount) {
        try{
            typeHelper("The bandits retreat, fleeing into the forest. In their haste, one of them drops a powerful-looking amulet. You put it on and feel a surge of vitality flow through your body. You increase your current health by " + amount +".", Color.GREEN);
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
    public static void chooseOptions(String optionOne, String optionTwo) {
        try {
            typeHelper("(1) " + optionOne, Color.GREEN);
            typeHelper("(2) " + optionTwo, Color.GREEN);
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
