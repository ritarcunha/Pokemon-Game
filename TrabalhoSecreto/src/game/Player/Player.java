package game.Player;

import game.Enemies.TeamRocket;
import game.Game;
import game.LinkedList;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {

    private Position pos;
    private String name;
    private Rectangle rectPlayer;

    private Game game;

    private int numberOfLifes;

    private final int PLAYERSIZE = Game.DISTANCE * 2 / 3;

    public Player(Position pos, String name, Game game) {
        this.pos = pos;
        this.name = name;
        this.rectPlayer = new Rectangle(pos.getCol() + ((Game.DISTANCE - PLAYERSIZE) / 2), pos.getRow() + ((Game.DISTANCE - PLAYERSIZE) / 2), PLAYERSIZE, PLAYERSIZE);
        rectPlayer.draw();
        this.game = game;
        this.numberOfLifes=3;
    }

    public TeamRocket getTR(int i) {
        return (TeamRocket) game.getLink1().get(i);
    }

    public int getNumberOfLifes(){
        return this.numberOfLifes;
    }


    public boolean checkMovement(Direction direction) {
        if (Game.inBattle == true)
            return false;
        switch (direction) {
            case RIGHT:
                if (pos.getCol() < game.getField()[0].length - 1 && game.getField()[pos.getRow()][(pos.getCol() + 1)] == "block") {
                    return true;
                }
                break;
            case LEFT:
                if (pos.getCol() > 0 && game.getField()[pos.getRow()][pos.getCol() - 1] == "block") {
                    return true;
                }
                break;
            case UP:
                if (pos.getRow() > 0 && game.getField()[pos.getRow() - 1][pos.getCol()] == "block") {
                    return true;
                }
                break;

            case DOWN:
                if (pos.getRow() < game.getField().length - 1 && game.getField()[pos.getRow() + 1][pos.getCol()] == "block") {
                    return true;
                }
                break;

        }
        return false;
    }


    public void changeRight() {
        if (checkMovement(Direction.RIGHT)) {
            rectPlayer.translate(Game.DISTANCE, 0);
            pos.setCol(rectPlayer.getX() / Game.DISTANCE);
        }
    }

    public void changeLeft() {
        if (checkMovement(Direction.LEFT)) {
            rectPlayer.translate(-Game.DISTANCE, 0);
            pos.setCol(rectPlayer.getX() / Game.DISTANCE);
        }
    }

    public void changeUp() {

        if (checkMovement(Direction.UP)) {
            rectPlayer.translate(0, -Game.DISTANCE);
            pos.setRow(rectPlayer.getY() / Game.DISTANCE);
        }
    }

    public void changeDown() {
        if (checkMovement(Direction.DOWN)) {
            rectPlayer.translate(0, Game.DISTANCE);
            pos.setRow(rectPlayer.getY() / Game.DISTANCE);
        }
    }

    //aqui vai chekar a colisao e caso exista come
    public boolean colision() {

        for (int i = 0; i < game.getLink1().size(); i++) {
            if (pos.getCol() + 1 == getTR(i).getPosTR().getCol() && pos.getRow() == getTR(i).getPosTR().getRow()) {
                game.getLink1().remove(getTR(i).death());
                return true;
            } else if (pos.getCol() - 1 == getTR(i).getPosTR().getCol() && pos.getRow() == getTR(i).getPosTR().getRow()) {
                game.getLink1().remove(getTR(i).death());
                return true;

            } else if (pos.getRow() + 1 == getTR(i).getPosTR().getRow() && pos.getCol() == getTR(i).getPosTR().getCol()) {
                game.getLink1().remove(getTR(i).death());
                return true;

            } else if (pos.getRow() - 1 == getTR(i).getPosTR().getRow() && pos.getCol() == getTR(i).getPosTR().getCol()) {
                game.getLink1().remove(getTR(i).death());
                return true;
            }

        }
        return false;
    }

    public void battle(){


    }

}

