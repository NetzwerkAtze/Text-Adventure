import entity.Entity;
import entity.Player;
import entity.Warrior;
import game.Gameloop;

public class Test {
    public static void main(String[] args) {
        Gameloop game = new Gameloop();
        Player player = new Player(game.chooseName(), 100, 10);
        Entity enemy = new Entity("Kobold", 200, 6);
        enemy.setCharacterClass(new Warrior());
        player.setCharacterClass(game.chooseClass());
        game.accessInventory(player);
    }
}
