
import entity.Player;
import game.Gameloop;

public class Main {
    public static void main(String[] args) {
        Gameloop game = new Gameloop();
        game.playTitle();
        Player player = new Player(game.chooseName());
        player.setCharacterClass(game.chooseClass());
        game.playIntro();
        game.loop(player);
    }
}