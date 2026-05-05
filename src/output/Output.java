package output;

import java.io.IOException;
import java.util.List;

public class Output {

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
