import combat.Combat;
import entity.Entity;
import entity.Player;
import entity.Warrior;
import game.Gameloop;

public class Test {
    public static void main(String[] args) {
        Gameloop game = new Gameloop();
        Player player = new Player(game.chooseName());
        Entity enemy = new Entity("Kobold", 200, 6);
        enemy.setCharacterClass(new Warrior());
        player.setCharacterClass(new Warrior());
        Combat.fight(player, enemy);
    }
}
