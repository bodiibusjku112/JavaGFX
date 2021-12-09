package Main.Listeners;

import Main.Keyboard;
import Main.Window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WrapKeyListener implements KeyListener {
    Keyboard keyboard;
    Window component;

    public WrapKeyListener(Window component) {
        this.component = component;
        this.keyboard = this.component.getKeyboard();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyboard.addEvent(new Keyboard.Event(Keyboard.Event.type.PRESS, e));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyboard.addEvent(new Keyboard.Event(Keyboard.Event.type.RELEASE, e));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keyboard.addEvent(new Keyboard.Event(Keyboard.Event.type.CHAR, e));
    }
}
