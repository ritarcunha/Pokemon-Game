package game.Enemies;

import java.awt.*;


import game.Game;
import game.Player.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class TeamRocket {
    private Position pos;
    private Rectangle rectNPC;
    private String npcName;
    private final int NPCSIZE=Game.DISTANCE *3/4;

    public TeamRocket(Position pos,String npcName){//quando criarmos uma instancia do TeamRocket temos de definir uma posição diferente (a outra ponta da grid)
        this.pos=pos;
        this.npcName=npcName;
        Rectangle rectNPC= new Rectangle(pos.getCol()*Game.DISTANCE+((Game.DISTANCE-NPCSIZE)/2),pos.getRow()*Game.DISTANCE+((Game.DISTANCE-NPCSIZE)/2),NPCSIZE,NPCSIZE);
        rectNPC.draw();
        rectNPC.setColor(Color.RED);
        rectNPC.fill();
    }

    public Position getPosTR(){
        return this.pos;
    }

    //public Position

}
