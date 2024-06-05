package game.Handler;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;

import java.awt.event.MouseWheelEvent;

public class MouseHandler implements org.academiadecodigo.simplegraphics.mouse.MouseHandler {

    private Mouse mouse;

    public MouseHandler() {
        mouse = new Mouse(this);
    }

    public void createKeyboardEvents() {
        MouseEvent mouseEventClick = new MouseEvent(0,0,MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
