import entity.Entity;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Entity spieler = new Entity("Spieler", 100, 10);
        Entity gegner = new Entity("Kobold", 50, 5);
        spieler.attack(gegner);
        gegner.attack(spieler);
    }
}