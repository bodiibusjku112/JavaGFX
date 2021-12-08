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
//        String key = KeyEvent.getKeyText(e.getKeyCode());
//        System.out.println("keyPressed (" + e.getKeyCode() + "): " + key);
        keyboard.press(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        String key = KeyEvent.getKeyText(e.getKeyCode());
//        System.out.println("keyReleased: " + KeyEvent.getKeyText(e.getKeyCode()));
        keyboard.release(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("keyTyped: ");
    }
}
