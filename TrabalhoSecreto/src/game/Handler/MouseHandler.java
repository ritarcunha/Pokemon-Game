package game.Handler;

import game.Game;
import game.Player.Player;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;

import java.awt.event.MouseWheelEvent;

public class MouseHandler implements org.academiadecodigo.simplegraphics.mouse.MouseHandler {

    private Mouse mouse;
    private Player p1;

    public MouseHandler(Player p1) {
        mouse = new Mouse(this);
        this.p1 = p1;
        createMouseEvents();
    }

    public void createMouseEvents() {
        MouseEvent mouseEventClick = new MouseEvent(0, 0, MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {//mouseEvent guarda a posiçao em que o mouse foi clicado. Este metodo que e chamado quando clicas no rato
        if (Game.inMenu) { // o metodo inMenu comeca a true e quando clicamos passa a false
            Game.inMenu = false;
        }
        if (Game.inBattle) {
            if (p1.chooseElement(mouseEvent.getX(), mouseEvent.getY())) {//
                p1.setChosing(false);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
