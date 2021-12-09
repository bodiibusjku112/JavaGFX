package Main.Listeners;

import Main.Graphics.DrawCanvas;
import Main.Mouse;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class WrapMouseWheelListener implements MouseWheelListener {
    Mouse mouse;
    DrawCanvas component;

    public WrapMouseWheelListener(DrawCanvas component) {
        this.component = component;
        this.mouse = this.component.getMouse();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
//        System.out.println("mouseWheelMoved: " + e);
    }
}
