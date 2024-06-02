package game.Enemies;

import game.Player.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Arada extends TeamRocket {

    Rectangle aradaRect;

    public Arada(Position pos,String npcName){
        super(pos, "Arada");// so preciso de definir as variaveis diferentes da TeamRocket porque tudo o resto é herdado (o novo quadrado ja esta no construtor do super)
    }


}
