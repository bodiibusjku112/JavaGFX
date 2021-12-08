package Main;

import Main.Listeners.WrapMouseListener;
import Main.Listeners.WrapMouseMotionListener;
import Main.Listeners.WrapMouseWheelListener;

import javax.swing.JPanel;
import java.awt.event.*;

public class DrawCanvas extends JPanel {
    Mouse mouse;
    int width;
    int height;
    int windowedWidth;
    int windowedHeight;

    public DrawCanvas() {
        super();
        this.mouse = new Mouse();
    }

    public DrawCanvas(int width, int height) {
        this();
        setSize(width, height);
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void addListeners() {
        addMouseListener(new WrapMouseListener(this));
        addMouseMotionListener(new WrapMouseMotionListener(this));
        addMouseWheelListener(new WrapMouseWheelListener(this));
    }
}
