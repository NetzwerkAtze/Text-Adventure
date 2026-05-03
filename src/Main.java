import ability.BasicAttack;
import ability.HeavyAttack;
import combat.Combat;
import entity.Entity;

public class Main {
    public static void main(String[] args) {

        Entity spieler = new Entity("Spieler", 100, 10);
        Entity gegner = new Entity("Kobold", 50, 26);
        spieler.addAbility(new HeavyAttack());
        gegner.addAbility(new BasicAttack());
        Combat.fight(spieler, gegner);
    }
}