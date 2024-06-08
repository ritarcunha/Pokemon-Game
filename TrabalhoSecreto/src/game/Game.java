package game;

import Background.Field;
import game.Enemies.*;
import game.Handler.MouseHandler;
import game.Handler.PlayerHandler;
import game.Player.Player;
import game.Player.Position;
import game.Sound.Sound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.omg.PortableServer.THREAD_POLICY_ID;
import sun.awt.windows.ThemeReader;
import sun.nio.cs.ext.EUC_CN;

import java.util.TreeMap;

public class Game {

    public final static int DISTANCE = 32;
    public static boolean inBattle = false;
    public static boolean chosing = false;
    public static boolean inMenu = true;
    private Sound sound = new Sound();

    //Player p11= new Player(new Position(0,0), "Mon",this);

    LinkedList<TeamRocket> link1 = new LinkedList<>();
    private Player p1 = new Player(new Position(0, 0), "Mon", this);

    public static final Picture picBatalha = new Picture(0, 0, "resources/batalha.png");
    public static final Picture chooseYE= new Picture(picBatalha.getWidth() * 1/5,picBatalha.getHeight() * 3/4 ,"resources/ChooseYE.png");
    public static final Picture picWater = new Picture(picBatalha.getWidth() * 3/4, chooseYE.getMaxY(), "resources/Water.png");
    public static final Picture picFlame = new Picture(25,chooseYE.getMaxY() + 7,"resources/Flame.png");
    public static final Picture picLeaf = new Picture(picBatalha.getWidth()*2/5,chooseYE.getMaxY(),"resources/leaf.png" );
    public static final Picture pok= new Picture( 15,15,"resources/Pokeball.png");
    Picture picMenu1 = new Picture(0, 0, "resources/MASTERCODER-ezgif.com-added-text.png");
    Picture picMenu2 = new Picture(0, 0, "resources/MASTERCODER-ezgif.com-added-text (1).png");



    Picture picBattleTime = new Picture(0, 0, "resources/BattleTimeCerta.png");
    private String[][] field = {{"block", "block", "block", "block", "block", "tree", "block", "block", "tree", "block", "block"},
            {"block", "tree", "block", "block", "block", "block", "block", "MA", "block", "block", "block"},
            {"block", "block", "monster", "block", "AN", "block", "block", "block", "block", "block", "tree"},
            {"tree", "block", "block", "block", "block", "block", "tree", "block", "block", "monster", "block"},
            {"block", "block", "block", "block", "block", "block", "block", "block", "block", "block", "block"},
            {"block", "monster", "block", "block", "block", "tree", "monster", "block", "block", "block", "block"},
            {"block", "block", "block", "block", "block", "block", "block", "block", "block", "block", "block"},
            {"block", "block", "ME", "block", "block", "tree", "block", "block", "tree", "block", "block"},
            {"monster", "block", "block", "block", "block", "block", "block", "block", "tree", "block", "Arada"}};
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
                if (field[i][j] == "Arada") {
                    drawTR(j, i,EnemyType.EU);
                }
                if (field[i][j] == "ME") {
                    drawTR(j, i, EnemyType.MENDANHA);
                }
                if (field[i][j] == "MA") {
                    drawTR(j, i, EnemyType.MARGARIDA);
                }
                if (field[i][j] == "AN") {
                    drawTR(j, i, EnemyType.ANDREIA);
                }
                if (field[i][j] == "monster"){
                    drawTR(j,i,EnemyType.MONSTER);
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


    public void drawTR(int j, int i, EnemyType enemyType) {
        drawFloor(j, i);
        switch (enemyType){
            case EU:
                TeamRocket t1 = new Arada(new Position(j, i), "mastercoder","resources/TR1.png"); //no construtor ja esta definido as propriedades e metodos de desenhar o retangilo
            link1.add(t1);
                break;
            case ANDREIA:
                TeamRocket t2= new Andreia (new Position(j, i), "mastercoder","resources/TR1.png") ;
                link1.add(t2);
                break;
            case MENDANHA:
                TeamRocket t3 = new Mendanha(new Position(j, i), "mastercoder", "resources/TR1.png") ;
                link1.add(t3);
                break;
            case MONSTER:
                TeamRocket t4 = new TeamRocket.Monster(new Position(j, i), "mastercoder","resources/D_Walk.png");
                link1.add(t4);
                break;
            case MARGARIDA:
                TeamRocket t5 = new Margarida(new Position(j, i), "mastercoder","resources/TR1.png");
                link1.add(t5);
                break;
        }
    }


    public void menu() throws InterruptedException {
        new MouseHandler(p1);
        while (inMenu) {
            picMenu1.draw();
            Thread.sleep(300);
            picMenu2.draw();
            picMenu1.delete();
            Thread.sleep(300);
            picMenu2.delete();
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
                Thread.sleep(500);
                colision(tr);

            }
        }
    }

    public void colision(TeamRocket tr) throws InterruptedException {
        inBattle = true;
        Rectangle rectangle= new Rectangle(0,0,field[0].length*DISTANCE,field.length*DISTANCE);
        rectangle.setColor(new Color(255,255,255));
        rectangle.fill();
        picBattleTime.draw();
        Thread.sleep(1200);//ponto de exclamaçao como animacao. Este sleep
        picBattleTime.delete();
        picBatalha.draw();
        battle(tr);
        Thread.sleep(1500);
        tr.deleteTR();
        link1.remove(tr.death(field));
        rectangle.delete();
        picBatalha.delete();
        inBattle = false;
        tr.deleteMessage();
        p1.deletePlayerMessage();


    }

    public void deleteElements (){
        picLeaf.delete();
        picFlame.delete();
        picWater.delete();
        chooseYE.delete();
    }

    public void drawElements(){
        chooseYE.draw();
        picWater.draw();
        picFlame.draw();
        picLeaf.draw();
    }

    public void drawLifes(TeamRocket teamRocket) {
    pok.draw();
    }

    public void drawLifes() {

    }

    public LinkedList<TeamRocket> getLink1() {
        return this.link1;
    }

    public void battle(TeamRocket tr ) throws InterruptedException {  //metodo da batalha
        int Plifes = p1.getNumberOfLifes();
        int TrLifes = tr.getNumberOfLifes();
        drawLifes();
        drawLifes(tr);
        BattleElements PlayerElement;
        BattleElements TRElement;
        while (Plifes != 0 && TrLifes != 0) {
            p1.setChosing(true);
            drawElements();
            tr.drawTR();
            System.out.println(chooseYE.getMaxY() + 7);
            while (p1.getChosing()) {
                Thread.sleep(100);
            }
            deleteElements();
            //mensagem de quem ganhou a ronda!!!
            Thread.sleep(1500);
            System.out.println(PlayerElement = p1.getElement());
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
        deleteElements();
        if (Plifes < TrLifes) {
            tr.drawMessage();

        } else {
            p1.drawPlayerMessage();
        }
    }
}