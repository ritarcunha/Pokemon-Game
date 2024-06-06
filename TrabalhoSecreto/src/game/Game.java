package game;

import Background.Field;
import game.Enemies.Arada;
import game.Enemies.EnemyType;
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

import java.util.Collection;
import java.util.Collections;

public class Game {

    public final static int DISTANCE = 30;
    public static boolean inBattle = false;
    private Sound sound = new Sound();



    //Player p11= new Player(new Position(0,0), "Mon",this);

    LinkedList<TeamRocket> link1 = new LinkedList<>();




    Picture pic1 = new Picture(0, 0, "resources/batalha.png");

    private String[][] field = {{"block", "block", "block", "block", "block", "tree", "block", "block", "tree", "block", "block"},
            {"block", "tree", "block", "block", "block", "block", "block", "TR", "block", "block", "block"},
            {"block", "block", "block", "block", "TR", "block", "block", "block", "block", "block", "tree"},
            {"tree", "block", "block", "block", "block", "block", "tree", "block", "block", "block", "block"},
            {"block", "block", "block", "block", "block", "block", "block", "block", "block", "block", "block"},
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
        Picture tree = new Picture(j * DISTANCE, i * DISTANCE, "resources/tree.png");
        rectangle.setColor(Field.lIGHTBROWN);
        rectangle.fill();
        tree.draw();


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

       public void drawText (){  //vamos substituir por uma imagem com as letras do pokemon
           
              Text caixaTeste = new Text(150, 200,"Battle time!");
              caixaTeste.grow(50,50);
              caixaTeste.draw();

       }



    /*public void drawExclamationpoint() {
        //Ellipse c1 = new Ellipse(250,300, 60, 60);
       // c1.draw();
        //c1.setColor(Color.BLUE);
        //c1.fill();
        Rectangle c2 = new Rectangle(260, 130 , DISTANCE+20, DISTANCE * 5);
        c2.setColor(Color.BLUE);
        c2.fill();
    }*/


    public void init() throws InterruptedException {    //ARADA TENS DE EXPLICAR ISTO! isto o q? A excepção. Ah oops. é so ignorar, o sleep pede para dar trow
        sound.play();
        drawText();
        Player p1= new Player(new Position(0,0), "Mon",this);
        new PlayerHandler(p1);
        new MouseHandler();
        while (true) {
               colision();

            }

        }


    public void colision () throws InterruptedException{
          Player p1= new Player(new Position(0,0), "Mon",this);
          inBattle = true;
          Thread.sleep(700);//ponto de exclamaçao como animacao. Este sleep
          pic1.draw();
          battle(p1, EnemyType.TEAMROCKET);
          Thread.sleep(700);
          pic1.delete();
          inBattle = false;


    }
    public LinkedList<TeamRocket> getLink1 (){
        return this.link1;
    }
        public void battle (Player player, EnemyType enemyType){  //metodo da batalha
            int Plifes= player.getNumberOfLifes();
            int TrLifes=enemyType.getLifes();
            int rounds=0;
            BattleElements    battleElement1 = TeamRocket.getElement();
            BattleElements    battleElement2 =TeamRocket.getElement();


            while(Plifes!=0 && TrLifes!=0){
                battleElement1 = TeamRocket.getElement();
                battleElement2 = TeamRocket.getElement();
                if(battleElement1.equals(BattleElements.WATER) && battleElement2.equals(BattleElements.FIRE)){
                    Plifes--;
                }
                else if(battleElement1.equals(BattleElements.FIRE) && battleElement2.equals(BattleElements.EARTH)){
                    Plifes--;
                }
                else if(battleElement1.equals(BattleElements.EARTH) && battleElement2.equals(BattleElements.WATER)) {
                   Plifes--;
                }
                else if(battleElement1.equals(battleElement2)){
                        continue;
                    }

                else{
                    TrLifes--;
                }

            }
            if (Plifes<TrLifes){
                System.out.println("TR won the battle");
            }
            else {
                System.out.println("Player won the battle");
            }







    }







}














