
import entity.Entity;
import entity.Warrior;
import game.Gameloop;

public class Main {
    public static void main(String[] args) {
        Gameloop game = new Gameloop();
        game.playTitle();
        Entity player = new Entity(game.chooseName(), 100, 10);
        Entity enemy = new Entity("Kobold", 200, 6);
        enemy.setCharacterClass(new Warrior());
        player.setCharacterClass(game.chooseClass());
        //game.playIntro();
        game.fight(player, enemy);
    }
}