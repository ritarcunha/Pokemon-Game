package game.Enemies;

import java.awt.*;


import game.BattleElements;
import game.Game;
import game.Player.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class TeamRocket {
    private Position pos;
    private Rectangle rectNPC;
    private String npcName;
    private final int NPCSIZE = Game.DISTANCE * 3 / 4;
    private BattleElements element;

    private int numberOfLifes;

    public TeamRocket(Position pos, String npcName, int numberOfLifes) {//quando criarmos uma instancia do TeamRocket temos de definir uma posição diferente (a outra ponta da grid)
        this.pos = pos;
        this.npcName = npcName;
        this.rectNPC = new Rectangle(pos.getCol() * Game.DISTANCE + ((Game.DISTANCE - NPCSIZE) / 2), pos.getRow() * Game.DISTANCE + ((Game.DISTANCE - NPCSIZE) / 2), NPCSIZE, NPCSIZE);
        rectNPC.setColor(Color.RED);
        rectNPC.fill();
        this.element = element;
        this.numberOfLifes = numberOfLifes;
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

    public TeamRocket death() {
        rectNPC.delete();
        return this;
    }




}
