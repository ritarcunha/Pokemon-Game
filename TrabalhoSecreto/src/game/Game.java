package game;

import Background.Colors;
import game.Enemies.*;
import game.Handler.MouseHandler;
import game.Handler.PlayerHandler;
import game.Player.Player;
import game.Player.Position;
import game.Sound.Sound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.CharArrayWriter;

public class Game {
    private Sound intro =new Sound();
    private Sound world = new Sound();
    private Sound battle =new Sound();

    public final static int DISTANCE = 32;
    public static boolean inBattle = false;
    public static boolean inMenu = true;


    public static final Picture picBatalha = new Picture(0, 0, "resources/batalha.png");
    public static final Picture chooseYE= new Picture(picBatalha.getWidth() * 1/5,picBatalha.getHeight() * 3/4 ,"resources/ChooseYE.png");
    public static final Picture picWater = new Picture(picBatalha.getWidth() * 3/4, chooseYE.getMaxY(), "resources/Water.png");
    public static final Picture picFlame = new Picture(25,chooseYE.getMaxY() + 7,"resources/Flame.png");
    public static final Picture picLeaf = new Picture(picBatalha.getWidth()*2/5,chooseYE.getMaxY(),"resources/leaf.png" );
    public static final Picture picMenu1 = new Picture(0, 0, "resources/MASTERCODER-ezgif.com-added-text.png");
    public static final Picture picMenu2 = new Picture(0, 0, "resources/MASTERCODER-ezgif.com-added-text (1).png");
    public static final Picture picRoundPlayerWon= new Picture(picBatalha.getWidth() * 1/5,picBatalha.getHeight() * 3/4,"resources/Playerwonthisround.png");
    public static final Picture picRoundEnemyWon= new Picture(picBatalha.getWidth() * 1/5,picBatalha.getHeight() * 3/4,"resources/Enemywonthisround.png");
    public static final Picture picRoundDraw= new Picture(picBatalha.getWidth() * 1/5,picBatalha.getHeight() * 3/4,"resources/Itsadraw.png");
    public static final Picture picGO = new Picture(70,70,"resources/GO.png");
    public static final Picture picYW = new Picture(70,70,"resources/YouWin.png");
    public static final Picture picBattleTime = new Picture(70, 70, "resources/BattleTimeCerta.png");

    LinkedList<TeamRocket> link1 = new LinkedList<>();
    private Player p1 = new Player(new Position(0, 7), "Mon", this);
    private String[][] field = {{"TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE"},
                                {"TE", "TE", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "TE"},
                                {"TE", "TE", "TE", "GR", "MR", "GR", "GR", "GR", "GR", "GR", "TE", "MR", "GR", "GR", "GR", "GR", "GR", "TE", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "TE"},
                                {"TE", "TE", "TE", "GR", "GR", "GR", "TE", "GR", "GR", "MR", "GR", "GR", "GR", "GR", "TE", "GR", "MR", "GR", "GR", "GR", "MR", "TE", "GR", "GR", "GR", "GR", "GR", "TE", "TE"},
                                {"TE", "TE", "TE", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "TE", "TE"},
                                {"TE", "TE", "TE", "GR", "GR", "TE", "MR", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "TE", "GR", "TE", "GR", "GR", "TE", "TE", "GR", "TE"},
                                {"TE", "TE", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "GR", "GR", "GR", "TE", "GR", "GR", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "TE", "GR", "GR", "TE"},
                                {"GR", "GR", "GR", "GR", "ME", "GR", "GR", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "MR", "GR", "GR", "GR", "GR", "GR", "TE", "TE", "GR", "GR", "GR", "TE"},
                                {"TE", "TE", "TE", "GR", "GR", "TE", "GR", "GR", "TE", "GR", "AN", "GR", "GR", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "AR", "TE"},
                                {"TE", "TE", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "MR", "TE", "GR", "GR", "GR", "GR", "TE", "GR", "TE", "GR", "GR", "GR", "GR", "TE", "TE", "GR", "GR", "GR", "TE"},
                                {"TE", "TE", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "MA", "GR", "GR", "GR", "GR", "TE", "GR", "GR", "TE", "TE", "GR", "GR", "TE"},
                                {"TE", "TE", "TE", "GR", "TE", "GR", "GR", "GR", "GR", "TE", "GR", "GR", "TE", "GR", "TE", "GR", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "TE", "GR", "TE"},
                                {"TE", "TE", "TE", "GR", "MR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "TE", "TE"},
                                {"TE", "TE", "TE", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "MR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "TE"},
                                {"TE", "TE", "TE", "TE", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "GR", "TE", "TE"},
                                {"TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE", "TE"},
    };
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
                if (field[i][j] == "GR") {
                    drawFloor(j, i);
                }
                if (field[i][j] == "TE") {//se tivesse com [i][j]== [1][1] ele iria estar a comparar um bloco com outro bloco
                    drawTree(j, i);
                }
                if (field[i][j] == "AR") {
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
                if (field[i][j] == "MR"){
                    drawTR(j,i,EnemyType.MONSTER);
                }

            }
        }
    }

    public void drawTree(int j, int i) {
        drawFloor(j,i);
        Picture TE = new Picture(j * DISTANCE, i * DISTANCE, "resources/tree.png");
        TE.draw();
    }

    public void drawFloor(int j, int i) {
        Picture rectangle = new Picture(j * DISTANCE, i * DISTANCE, "resources/Grass2.png");
        rectangle.draw();
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
        intro.setFile("resources/intro.wav");
        intro.play();
        intro.loop();
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
       intro.stop();
       world.setFile("resources/world.wav");
       world.play();
       world.loop();
        TeamRocket tr;
        p1.getSpritePlayer().draw();
        new PlayerHandler(p1);
        while (true) {
            tr = p1.colision();
            if (tr != null) {
                inBattle = true;
                Thread.sleep(500);
                colision(tr);

            }
        }
    }

    public Rectangle[] hideStuff(){
        Rectangle[] bejes = {new Rectangle(44,47,193,38),new Rectangle(44,85,190,5),new Rectangle(325,179,194,60)};
        bejes[0].setColor(Colors.BATALHABEJE);
        bejes[1].setColor(Colors.BATALHABEJE);
        bejes[2].setColor(Colors.BATALHABEJE);
        bejes[0].fill();
        bejes[1].fill();
        bejes[2].fill();
        return bejes;
    }

    public void desHideStuff(Rectangle[] bejes){
        for (Rectangle beje : bejes)
            beje.delete();
    }

    public void colision(TeamRocket tr) throws InterruptedException {
        Rectangle[] bejes;

        world.stop();
        battle.setFile("resources/battle.wav");
        battle.loop();
        Rectangle rectangle= new Rectangle(0,0,field[0].length*DISTANCE,field.length*DISTANCE);
        rectangle.setColor(new Color(255,255,255));
        rectangle.fill();
        picBattleTime.draw();
        Thread.sleep(1200);//ponto de exclamaçao como animacao. Este sleep
        picBattleTime.delete();
        picBatalha.draw();
        //hide name and stuff!!
        bejes = hideStuff();
        tr.drawLifes();
        p1.drawLifes();
        if (!battle(tr)){
            gameOver();
            Thread.sleep(60000);
            System.exit(0);
        }
        else if(battle(tr) && tr instanceof Arada) {
            youWin();
            Thread.sleep(60000);
            System.exit(0);
        }
        Thread.sleep(1500);//quando a batalha acaba
        p1.hideLifes();
        tr.hideLifes();
        tr.deleteTR();
        link1.remove(tr.death(field));
        rectangle.delete();
        desHideStuff(bejes);
        picBatalha.delete();
        inBattle = false;
        tr.deleteMessage();
        p1.deletePlayerMessage();
        p1.deleteTR();
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

    public LinkedList<TeamRocket> getLink1() {
        return this.link1;
    }

    public boolean battle(TeamRocket tr ) throws InterruptedException {  //metodo da batalha

        int Plifes = p1.getNumberOfLifes();
        int TrLifes = tr.getNumberOfLifes();
        BattleElements PlayerElement;
        BattleElements TRElement;
        while (Plifes != 0 && TrLifes != 0) {
            drawElements();
            tr.drawTR();
            p1.drawPlayer();
            p1.setChosing(true);
            System.out.println(chooseYE.getMaxY() + 7);
            while (p1.getChosing()) {
                Thread.sleep(100);
            }
            deleteElements();
            System.out.println(PlayerElement = p1.getElement());
            TRElement = TeamRocket.getElement();
            if (TRElement.equals(BattleElements.WATER) && PlayerElement.equals(BattleElements.FIRE)) {
                Plifes--;
                picRoundEnemyWon.draw();
                Thread.sleep(1500);
                tr.attack(TRElement);
                picRoundEnemyWon.delete();
                p1.deleteLifes();
            } else if (TRElement.equals(BattleElements.FIRE) && PlayerElement.equals(BattleElements.EARTH)) {
                Plifes--;
                picRoundEnemyWon.draw();
                Thread.sleep(1500);
                tr.attack(TRElement);
                picRoundEnemyWon.delete();
                p1.deleteLifes();
            } else if (TRElement.equals(BattleElements.EARTH) && PlayerElement.equals(BattleElements.WATER)) {
                Plifes--;
                picRoundEnemyWon.draw();
                Thread.sleep(1500);
                tr.attack(TRElement);
                picRoundEnemyWon.delete();
                p1.deleteLifes();
            } else if (PlayerElement.equals(TRElement)) {
                picRoundDraw.draw();
                Thread.sleep(1500);
                picRoundDraw.delete();
                continue;
            } else {
                TrLifes--;
                picRoundPlayerWon.draw();
                Thread.sleep(1500);
                p1.attack(PlayerElement);
                picRoundPlayerWon.delete();
                tr.deleteLifes();
            }
        }
        deleteElements();
        if (Plifes < TrLifes) {
            tr.drawMessage();
            battle.stop();
            world.play();
            world.loop();
            return false;
        } else {
            p1.drawPlayerMessage();
            battle.stop();
            world.play();
            world.loop();
            return true;
        }
    }

    private void gameOver(){
        Rectangle rectangle = new Rectangle(0,0,field[0].length*DISTANCE,field.length*DISTANCE);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
        picGO.draw();
    }

    private void youWin(){
        Rectangle rectangle = new Rectangle(0,0,field[0].length*DISTANCE,field.length*DISTANCE);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
        picYW.draw();
    }
}