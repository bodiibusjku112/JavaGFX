package Main.Listeners;

import Main.Graphics.DrawCanvas;
import Main.Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WrapMouseListener implements MouseListener {
    Mouse mouse;
    DrawCanvas component;

    public WrapMouseListener(DrawCanvas component) {
        this.component = component;
        this.mouse = this.component.getMouse();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Canvas Size: " + component.getSize());
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("mousePressed: " + e.getButton());
        mouse.press(e.getButton());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("mouseReleased: " + e.getButton());
        mouse.release(e.getButton());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered: " + e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited: " + e);
    }
}
