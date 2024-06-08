package game.Enemies;

import game.Game;
import game.Player.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Arada extends TeamRocket {

    public Picture message= new Picture(30, Game.chooseYE.getY(),"resources/Mr.AradaWon.png");

    public Arada(Position pos,String npcName, String tr){
        super(pos, "Arada",5, tr);// so preciso de definir as variaveis diferentes da TeamRocket porque tudo o resto é herdado (o novo quadrado ja esta no construtor do super)
    }

    public void drawTR(){
        //battlePic.draw();
    }

    @Override
    public void deleteTR() {
        //battlePic.delete();
    }

    public void drawMessage(){
        message.draw();
    }

    public void deleteMessage(){
        message.delete();
    }

    //vai ter mais vidas que os outros, coloquei 5
}
