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
import java.util.logging.Handler;

public class Game {

    public final static int DISTANCE = 32;
    public static boolean inBattle = false;
    public static boolean chosing = false;
    public static boolean inMenu = true;
    private Sound sound = new Sound();

    //Player p11= new Player(new Position(0,0), "Mon",this);

    LinkedList<TeamRocket> link1 = new LinkedList<>();
    private Player p1 = new Player(new Position(0, 0), "Mon", this);

    Picture pic1 = new Picture(0, 0, "resources/batalha.png");
    Picture pic2 = new Picture(0, 0, "resources/MASTERCODER-ezgif.com-added-text.png");
    Picture pic3 = new Picture(0, 0, "resources/MASTERCODER-ezgif.com-added-text (1).png");

    Picture pic4 = new Picture(0, 0, "resources/BattleTimeCerta.png");
    private String[][] field = {{"block", "block", "block", "block", "block", "tree", "block", "block", "tree", "block", "block"},
            {"block", "tree", "block", "block", "block", "block", "block", "TR", "block", "block", "block"},
            {"block", "block", "block", "block", "TR", "block", "block", "block", "block", "block", "tree"},
            {"tree", "block", "block", "block", "block", "block", "tree", "block", "block", "block", "block"},
            {"block", "block", "block", "block", "block", "block", "block", "block", "block", "block", "block"},
            {"block", "monster", "block", "block", "block", "tree", "block", "block", "block", "block", "block"},
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
                if (field[i][j] == "monster"){
                    drawMonster(j,i);
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

    public void drawMonster (int j, int i){
        drawFloor(j, i);
        TeamRocket m1 = new TeamRocket.Monster(new Position(j, i), "Mon");
        link1.add(m1);

    }

    public void menu() throws InterruptedException {
        new MouseHandler(p1);
        while (inMenu) {
            pic2.draw();
            Thread.sleep(300);
            pic3.draw();
            pic2.delete();
            Thread.sleep(300);
            pic3.delete();
        }
    }


    public void init() throws InterruptedException {    //ARADA TENS DE EXPLICAR ISTO! isto o q? A excepção. Ah oops. é so ignorar, o sleep pede para dar trow
        TeamRocket tr;
        sound.play();
        p1.getSpritePlayer().draw();
        new PlayerHandler(p1);
        while (true) {
            tr = p1.colision();
            if (tr != null) {

                colision(tr);

            }
        }
    }

    public void colision(TeamRocket tr) throws InterruptedException {
        inBattle = true;
        Rectangle rectangle= new Rectangle(0,0,field[0].length*DISTANCE,field.length*DISTANCE);
        rectangle.setColor(new Color(255,255,255));
        rectangle.fill();
        pic4.draw();
        Thread.sleep(1200);//ponto de exclamaçao como animacao. Este sleep
        pic4.delete();
        pic1.draw();
        battle(p1, EnemyType.TEAMROCKET);
        Thread.sleep(500);
        link1.remove(tr.death(field));
        rectangle.delete();
        pic1.delete();
        inBattle = false;


    }

    public LinkedList<TeamRocket> getLink1() {
        return this.link1;
    }

    public void battle(Player player, EnemyType enemyType) throws InterruptedException {  //metodo da batalha
        int Plifes = player.getNumberOfLifes();
        int TrLifes = enemyType.getLifes();
        BattleElements PlayerElement;
        BattleElements TRElement;


        while (Plifes != 0 && TrLifes != 0) {
            player.setChosing(true);
            while (player.getChosing()) {
                Thread.sleep(100);
            }
            System.out.println("ola2");
            PlayerElement = TeamRocket.getElement();
            TRElement = TeamRocket.getElement();
            if (PlayerElement.equals(BattleElements.WATER) && TRElement.equals(BattleElements.FIRE)) {
                Plifes--;
            } else if (PlayerElement.equals(BattleElements.FIRE) && TRElement.equals(BattleElements.EARTH)) {
                Plifes--;
            } else if (PlayerElement.equals(BattleElements.EARTH) && TRElement.equals(BattleElements.WATER)) {
                Plifes--;
            } else if (PlayerElement.equals(TRElement)) {
                continue;
            } else {
                TrLifes--;
            }

        }
        if (Plifes < TrLifes) {
            System.out.println("TR won the battle");
        } else {
            System.out.println("Player won the battle");
        }
    }
}