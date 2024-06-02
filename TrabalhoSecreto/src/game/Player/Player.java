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

    private final int PLAYERSIZE=Game.DISTANCE *2/3;

    public Player(Position pos, String name, Game game){
        this.pos=pos;
        this.name=name;
        this.rectPlayer= new Rectangle(pos.getCol()+((Game.DISTANCE-PLAYERSIZE)/2), pos.getRow()+((Game.DISTANCE-PLAYERSIZE)/2) ,PLAYERSIZE,PLAYERSIZE );
        rectPlayer.draw();
        this.game=game;
    }

    public TeamRocket getTR(int i){
        return (TeamRocket)game.getLink1().get(i);//temos de alterar o index
    }


    public boolean checkMovement(Direction direction) {

        for(int i=0;i< game.getLink1().size(); i++){
            switch (direction) {
                case RIGHT:
                    if (pos.getCol() == getTR(i).getPosTR().getCol() - 1 && pos.getRow() == getTR(i).getPosTR().getRow()) // game.getLink1().get(0) ele ate aqui acha que é da classe objeto mas nos queremos comparar com a classe TR, para isso temos de colocar os (TeamRockect)
                        return false;
                    break;
                case LEFT:
                    if (pos.getCol() == getTR(i).getPosTR().getCol() + 1 && pos.getRow() == getTR(i).getPosTR().getRow()) {
                        return false;
                    }
                    break;
                case UP:
                    if (pos.getRow() == getTR(i).getPosTR().getRow() + 1 && pos.getCol() == getTR(i).getPosTR().getCol()) {
                        return false;
                    }
                    break;
                case DOWN:
                    if (pos.getRow() == getTR(i).getPosTR().getRow() - 1 && pos.getCol() == getTR(i).getPosTR().getCol()) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }


    public void changeRight(){
        if(checkMovement(Direction.RIGHT)) {
            rectPlayer.translate(Game.DISTANCE, 0);
            pos.setCol(rectPlayer.getX() / Game.DISTANCE);
        }
    }
    public void changeLeft(){
        if(checkMovement(Direction.LEFT)) {
            rectPlayer.translate(-Game.DISTANCE, 0);
            pos.setCol(rectPlayer.getX() / Game.DISTANCE);
        }
    }

    public void changeUp(){

        if(checkMovement(Direction.UP)) {
            rectPlayer.translate(0, -Game.DISTANCE);
            pos.setRow(rectPlayer.getY() / Game.DISTANCE);
        }
    }

    public void changeDown(){
        if(checkMovement(Direction.DOWN)) {
            rectPlayer.translate(0, Game.DISTANCE);
            pos.setRow(rectPlayer.getY() / Game.DISTANCE);
        }
    }


}
