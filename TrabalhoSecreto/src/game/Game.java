package game;

import game.Enemies.Arada;
import game.Player.Handler;
import game.Player.Player;
import game.Player.Position;
import game.Enemies.TeamRocket;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    public final static int DISTANCE=30;
    LinkedList link1= new LinkedList();

    private String [] [] field = {{"block", "block", "block", "block"},
                          {"block", "block", "block", "block"},
                          {"block", "block", "block", "block"},
                          {"block", "block", "block", "block"}};
                          //criamos uma matriz para o campo de jogo

    public void draw(){                             //field.length da me a quantidade de arrays
        for(int i=0;i < field.length;i++){         //Aqui percorremos cada fila da matriz (array dos arrays)
            for(int j=0; j<field[i].length; j++){        //Aqui percorremos cada posição da matriz (cada String do array)
                Rectangle rectangle= new Rectangle(j*DISTANCE,i*DISTANCE, DISTANCE, DISTANCE);
                      rectangle.draw();

            }
        }
    }

    public void init(){
        Player p1= new Player(new Position(0,0), "Mon",this);
        TeamRocket t1= new Arada(new Position(3,3),"mastercoder") ;
        link1.add(t1);
        new Handler(p1);
        while(true){
        }


    }
        public LinkedList getLink1 (){
            return this.link1;
        }








}
