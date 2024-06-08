package game.Enemies;

import game.Game;
import game.Player.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Mendanha extends TeamRocket {
    public Picture message= new Picture(30, Game.chooseYE.getY(),"resources/MendanhaWon.png");
    private Picture battlePic = new Picture(Game.picBatalha.getWidth() * 2/3,10, "resources/Mandanha.png");
    public Mendanha(Position pos, String npcName, String tr) {
        super(pos, npcName, 3, tr);
    }
    public  void drawTR(){
        battlePic.draw();
    }
    public void deleteTR(){
        battlePic.delete();
    }

    @Override
    public void drawMessage() {
        message.draw();
    }

    public void deleteMessage(){
        message.delete();
    }

}
