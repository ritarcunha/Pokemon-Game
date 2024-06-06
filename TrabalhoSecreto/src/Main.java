import game.Game;

public class Main {
    public static void main(String[] args) throws InterruptedException {//so ta a dizer q se o sleep der erro fecha o programa
        Game game1= new Game();
        game1.menu();
        game1.draw();
        game1.init();
    }
}