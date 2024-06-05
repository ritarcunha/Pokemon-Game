package game;

import Background.Field;
import game.Enemies.Arada;
import game.Handler.MouseHandler;
import game.Handler.PlayerHandler;
import game.Player.Player;
import game.Player.Position;
import game.Enemies.TeamRocket;
import game.Sound.Sound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Game {

    public final static int DISTANCE = 30;
    private Sound sound = new Sound();

    LinkedList link1 = new LinkedList();



    Picture p1 = new Picture(0, 0, "resources/batalha.png");

    private String[][] field = {{"block", "block", "block", "block", "block", "tree", "block", "block", "tree", "block", "block"},
            {"block", "tree", "block", "block", "block", "block", "block", "TR", "block", "block", "block"},
            {"block", "block", "block", "block", "TR", "block", "block", "block", "block", "block", "tree"},
            {"tree", "block", "block", "block", "block", "block", "tree", "block", "block", "block", "block"},
            {"block", "block", "TR", "block", "block", "block", "block", "block", "block", "block", "block"},
            {"block", "block", "block", "block", "block", "tree", "block", "block", "block", "block", "block"},
            {"block", "block", "block", "block", "block", "block", "block", "block", "block", "block", "block"},
            {"block", "block", "TR", "block", "block", "tree", "block", "block", "tree", "block", "block"},
            {"block", "block", "block", "block", "block", "block", "block", "block", "tree", "block", "TR"}};
    //criamos uma matriz para o campo de jogo
    //field.length- da me o numero de arrays da matriz e de rows
    //field[0].length- da me o numero de elemnetos de cada um dos array
    //field [i][j].length- da me o comprimento da string de uma determinada posição
    //field[i].length*field.length-da me o numero total de elementos

    public String[][] getField() {
        return this.field;
    }

    public void draw() {                             //field.length da me a quantidade de arrays
        for (int i = 0; i < field.length; i++) {         //Aqui percorremos cada fila da matriz (array dos arrays)
            for (int j = 0; j < field[i].length; j++) {        //Aqui percorremos cada posição da matriz (cada String do array)
                if (field[i][j] == "block") {
                    drawFloor(j, i);
                }
                if (field[i][j] == "tree") {//se tivesse com [i][j]== [1][1] ele iria estar a comparar um bloco com outro bloco
                    drawTree(j, i);
                }

                if (field[i][j] == "TR") {
                    drawTR(j, i);

                }

            }
        }
    }

    public void drawTree(int j, int i) {
        Rectangle rectangle = new Rectangle(j * DISTANCE, i * DISTANCE, DISTANCE, DISTANCE);
        Rectangle rectangle1 = new Rectangle(j * DISTANCE, i * DISTANCE, 20, 20);
        rectangle.setColor(Field.lIGHTBROWN);
        rectangle1.setColor(Color.GREEN);
        rectangle.fill();
        rectangle1.fill();


    }

    public void drawFloor(int j, int i) {
        Rectangle rectangle = new Rectangle(j * DISTANCE, i * DISTANCE, DISTANCE, DISTANCE);
        rectangle.setColor(Field.lIGHTBROWN);
        rectangle.fill();
    }

    public void drawTR(int j, int i) {
        drawFloor(j, i);
        TeamRocket t1 = new Arada(new Position(j, i), "mastercoder"); //no construtor ja esta definido as propriedades e metodos de desenhar o retangilo
        link1.add(t1);

    }

    /*public void drawText (){
           Rectangle rectangle = new Rectangle(j * DISTANCE, i * DISTANCE, DISTANCE, DISTANCE);
           rectangle.setColor(Color.WHITE);
           rectangle.fill();
           drawExclamationpoint();

    } */

       public void drawText (){
           
              Text caixaTeste = new Text(150, 200,"Battle time!");
              caixaTeste.grow(50,50);
              caixaTeste.draw();

       }





    public void drawExclamationpoint() {
        Ellipse c1 = new Ellipse(250,300, 60, 60);
        c1.draw();
        c1.setColor(Color.BLUE);
        c1.fill();
        Rectangle c2 = new Rectangle(260, 130 , DISTANCE+20, DISTANCE * 5);
        c2.setColor(Color.BLUE);
        c2.fill();
    }


    public void init() throws InterruptedException {
        sound.play();
        drawText();
        Player p1= new Player(new Position(0,0), "Mon",this);
        new PlayerHandler(p1);
        new MouseHandler();


        while (true) {
            if (p1.colision()) {

                drawExclamationpoint();
                Thread.sleep(700);//ponto de exclamaçao como animacao
                this.p1.draw();
            }

        }
    }
    public LinkedList getLink1 (){
        return this.link1;
    }
}












