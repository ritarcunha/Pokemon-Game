import game.Game;
import game.Sound;

public class Main {
    public static void main(String[] args) {
        Game game1= new Game();
        game1.draw();
        game1.init();
        game1.playMusic(0);
    }
}