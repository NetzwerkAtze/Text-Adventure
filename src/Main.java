
import entity.Entity;
import entity.Mage;
import entity.Warrior;
import game.Gameloop;

public class Main {
    public static void main(String[] args) {

        Gameloop game = new Gameloop();

        Entity player = new Entity(game.chooseName(), 100, 10);
        Entity enemy = new Entity("Kobold", 50, 26);
        enemy.setPlayerClass(new Warrior());
        player.setPlayerClass(game.chooseClass());
        game.fight(player, enemy);
    }
}