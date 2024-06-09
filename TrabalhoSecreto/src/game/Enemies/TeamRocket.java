
package game.Enemies;

import java.awt.*;

import Background.Field;
import game.Alive;
import game.BattleElements;
import game.Game;
import game.Player.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.omg.CORBA.StringHolder;

public abstract class TeamRocket implements Alive {

    private Position pos;
    private final String TR = "resources/TR1.png";
    private Picture NPC;
    private String npcName;
    private final int NPCSIZE = Game.DISTANCE;
    private BattleElements element;

    private Game game;

    private int numberOfLifes;

    private Picture [] array;

    public TeamRocket(Position pos, String npcName, int numberOfLifes, String tr) {//quando criarmos uma instancia do TeamRocket temos de definir uma posição diferente (a outra ponta da grid)

        this.pos = pos;
        this.npcName = npcName;
        this.NPC = new Picture(pos.getCol() * Game.DISTANCE + ((Game.DISTANCE - NPCSIZE) / 2),
                pos.getRow() * Game.DISTANCE + ((Game.DISTANCE - NPCSIZE) / 2),
                tr);
        NPC.draw();

        this.numberOfLifes = numberOfLifes;
        this.array=new Picture [getNumberOfLifes()];
        this.game=game;

    }

    public abstract void drawTR();

    public abstract void deleteTR();

    public abstract void drawMessage();

    public abstract void deleteMessage();

    public void drawLifes(){// como já definimos este metodo com tudo o que ha para fazer, os filhos nao precisam de ter o metodo na sua classe

        for (int i=0; i<getNumberOfLifes(); i++){
            Picture pok= new Picture(i*40+10,5,"resources/Pokeball.png" );// cada pokeball tem cerca de 32 de comprimento, por isso e so incrementar mais um bocadinho no x
            array[i]=pok;
            pok.draw();
        }
    }

    @Override
    public void deleteLifes() {


                System.out.println("Apaguei uma vida");
                array[numberOfLifes-1].delete();
            numberOfLifes--;

            }





    public Position getPosTR() {
        return this.pos;
    }

    public int getNumberOfLifes() {
        return this.numberOfLifes;
    }


    public static BattleElements getElement() {
        int randomNumber = (int) (Math.random() * 3) + 1;
        if (randomNumber == 1) {
            return BattleElements.EARTH;
        } else if (randomNumber == 2) {
            return BattleElements.FIRE;
        } else {
            return BattleElements.WATER;
        }

    }


    public TeamRocket death(String[][] field) {
        NPC.delete();
        field[getPosTR().getRow()][getPosTR().getCol()] = "block";
        return this;
    }

    public static class Monster extends TeamRocket{

        public Picture message= new Picture(30, Game.chooseYE.getY(),"resources/MonsterWon.png");

        public Monster(Position pos, String npcName, String tr) {
            super(pos, npcName, 1, tr);
        }
        public void drawTR(){
            //battlePic.draw();
        }

        public void deleteTR(){
            //battlePic.delete();
        }

        @Override
        public void drawMessage() {
           message.draw();
        }

        public void deleteMessage(){
            message.delete();
        }



        //Faze-los aparecer na grid
    }


}
