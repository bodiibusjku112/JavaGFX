package Main.Listeners;

import Main.DrawCanvas;
import Main.Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class WrapMouseMotionListener implements MouseMotionListener {
    Mouse mouse;
    DrawCanvas component;

    public WrapMouseMotionListener(DrawCanvas component) {
        this.component = component;
        this.mouse = this.component.getMouse();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println("mouseDragged: " + e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved: " + e.getPoint());
    }
}
