package game.Player;

import game.BattleElements;
import game.Enemies.TeamRocket;
import game.Game;
import game.LinkedList;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.event.MouseEvent;

public class Player {

    private Picture spritePlayer;
    private int animationFrame = 0;
    private final String[] upImages = {"resources/playerMoveChar/u1.png", "resources/playerMoveChar/u2.png"};
    private final String[] downImages = {"resources/playerMoveChar/d1.png", "resources/playerMoveChar/d2.png"};
    private final String[] leftImages = {"resources/playerMoveChar/l1.png", "resources/playerMoveChar/l2.png"};
    private final String[] rightImages = {"resources/playerMoveChar/r1.png", "resources/playerMoveChar/r2.png"};
    private Position pos;
    private String name;
    private BattleElements playerElement = BattleElements.NOELEMENT;
   // private Rectangle rectPlayer;

    private Game game;

    private int numberOfLifes;

    private final int PLAYERSIZE = Game.DISTANCE * 3 / 2;

    public Player(Position pos, String name, Game game) {
        this.pos = pos;
        this.name = name;
        this.spritePlayer = new Picture(pos.getCol() * Game.DISTANCE + ((Game.DISTANCE - PLAYERSIZE) / 2),
                pos.getRow() * Game.DISTANCE + ((Game.DISTANCE - PLAYERSIZE) / 2),
                downImages[0]); // Initial image facing down
        this.game = game;
        this.numberOfLifes = 3;
    }

    public TeamRocket getTR(int i) {
        return (TeamRocket) game.getLink1().get(i);
    }

    public int getNumberOfLifes(){
        return this.numberOfLifes;
    }

    public BattleElements getElement() {
        return playerElement;
    }

    public Picture getSpritePlayer() {
        return spritePlayer;
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
    private void updateSprite(String[] images) {
        spritePlayer.load(images[animationFrame]);
        animationFrame = (animationFrame + 1) % images.length;
    }

    public void changeRight() {
        if (checkMovement(Direction.RIGHT)) {
            spritePlayer.translate(Game.DISTANCE, 0);
            pos.setCol((spritePlayer.getX() + PLAYERSIZE / 2) / Game.DISTANCE);
            updateSprite(rightImages);
        }
    }

    public void changeLeft() {
        if (checkMovement(Direction.LEFT)) {
            spritePlayer.translate(-Game.DISTANCE, 0);
            pos.setCol((spritePlayer.getX() + PLAYERSIZE / 2) / Game.DISTANCE);
            updateSprite(leftImages);
        }
    }

    public void changeUp() {
        if (checkMovement(Direction.UP)) {
            spritePlayer.translate(0, -Game.DISTANCE);
            pos.setRow((spritePlayer.getY() + PLAYERSIZE / 2) / Game.DISTANCE);
            updateSprite(upImages);
        }
    }

    public void changeDown() {
        if (checkMovement(Direction.DOWN)) {
            spritePlayer.translate(0, Game.DISTANCE);
            pos.setRow((spritePlayer.getY() + PLAYERSIZE / 2) / Game.DISTANCE);
            updateSprite(downImages);
        }
    }

    //aqui vai chekar a colisao e caso exista come
    public TeamRocket colision() {

        for (int i = 0; i < game.getLink1().size(); i++) {
            if (pos.getCol() + 1 == getTR(i).getPosTR().getCol() && pos.getRow() == getTR(i).getPosTR().getRow()) {
                return getTR(i);
            } else if (pos.getCol() - 1 == getTR(i).getPosTR().getCol() && pos.getRow() == getTR(i).getPosTR().getRow()) {
                return  getTR(i);

            } else if (pos.getRow() + 1 == getTR(i).getPosTR().getRow() && pos.getCol() == getTR(i).getPosTR().getCol()) {
                return getTR(i);

            } else if (pos.getRow() - 1 == getTR(i).getPosTR().getRow() && pos.getCol() == getTR(i).getPosTR().getCol()) {
                return getTR(i);
            }

        }
        return null;
    }

    public boolean chooseElement(double x, double y) {
        return true;
    }

}

