
package game.Enemies;

import java.awt.*;

import Background.Field;
import game.BattleElements;
import game.Game;
import game.Player.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class TeamRocket {

    private Position pos;
    private final String TR = "resources/TR1.png";
    private Picture NPC;
    private String npcName;
    private final int NPCSIZE = Game.DISTANCE;
    private BattleElements element;

    private int numberOfLifes;


    public TeamRocket(Position pos, String npcName) {//quando criarmos uma instancia do TeamRocket temos de definir uma posição diferente (a outra ponta da grid)

        this.pos = pos;
        this.npcName = npcName;
        this.NPC = new Picture(pos.getCol() * Game.DISTANCE + ((Game.DISTANCE - NPCSIZE) / 2),
                pos.getRow() * Game.DISTANCE + ((Game.DISTANCE - NPCSIZE) / 2),
                TR);
        NPC.draw();
<<<<<<< HEAD
        this.element = element;

        this.numberOfLifes = 3;
=======
        this.numberOfLifes = numberOfLifes;
>>>>>>> 5f18d6734cff3d6c8a14bfa694912cb58c385ab9
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

        private int numberOfLifes=1;

        public Monster(Position pos, String npcName) {
            super(pos, npcName);
        }

        //Faze-los aparecer na grid
    }


}
