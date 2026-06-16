
import combat.Combat;
import entity.Entity;
import entity.Player;
import entity.Warrior;
import game.Gameloop;

public class Main {
    public static void main(String[] args) {
        Gameloop game = new Gameloop();
        game.playTitle();
        Player player = new Player(game.chooseName());
        player.setCharacterClass(game.chooseClass());
        game.playIntro();
    }
}