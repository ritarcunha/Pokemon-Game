package game.Handler;

import game.Game;
import game.Methods;
import game.Player.Player;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
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
        createKeyboardEvents();
    }

    public void createKeyboardEvents() {
        MouseEvent mouseEventClick = new MouseEvent(0, 0, MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (Game.inMenu) {
            Game.inMenu = false;
        }
        if (Game.inBattle) {
            if (p1.chooseElement(mouseEvent.getX(), mouseEvent.getY())) {
                System.out.println("ola");
                Game.chosing = false;
            }
        }
        System.out.println("X " + mouseEvent.getX() + " Y " + mouseEvent.getY());

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
