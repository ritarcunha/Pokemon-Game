package game.Handler;

import game.Player.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

    public class PlayerHandler implements KeyboardHandler {

        public Keyboard keyboard;
        public Player player;


        public PlayerHandler(Player player) {
            this.player = player;
            keyboard = new Keyboard(this);
            createKeyboardEvents();
        }

        public void createKeyboardEvents() {
            KeyboardEvent keyboardEventRight = new KeyboardEvent();
            keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
            keyboard.addEventListener(keyboardEventRight);

            KeyboardEvent keyboardEventLeft = new KeyboardEvent();
            keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
            keyboard.addEventListener(keyboardEventLeft);

            KeyboardEvent keyboardEventSpace = new KeyboardEvent();
            keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
            keyboard.addEventListener(keyboardEventSpace);

            KeyboardEvent keyboardEventUp = new KeyboardEvent();
            keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
            keyboard.addEventListener(keyboardEventUp);

            KeyboardEvent keyboardEventDown = new KeyboardEvent();
            keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
            keyboard.addEventListener(keyboardEventDown);
        }


        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_RIGHT:
                    player.changeRight();
                    break;
                case KeyboardEvent.KEY_LEFT:
                    player.changeLeft();
                    break;
                case KeyboardEvent.KEY_SPACE:
                    System.exit(1);
                    break;
                case KeyboardEvent.KEY_UP:
                    player.changeUp();
                    break;
                case KeyboardEvent.KEY_DOWN:
                    player.changeDown();
                    break;
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
}
