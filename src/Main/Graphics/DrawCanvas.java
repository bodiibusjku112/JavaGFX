package Main.Graphics;

import Main.Listeners.WrapMouseListener;
import Main.Listeners.WrapMouseMotionListener;
import Main.Listeners.WrapMouseWheelListener;
import Main.Mouse;

import javax.swing.JPanel;
import java.awt.*;

public class DrawCanvas extends JPanel {
    Mouse mouse;
    int width;
    int height;
    int windowedWidth;
    int windowedHeight;
    Color defaultColor = new Color(0.0f, 0.0f, 0.0f);

    Graphics2D gfx;

    public DrawCanvas() {
        super();
        this.mouse = new Mouse();
        fill();
    }

    public DrawCanvas(int width, int height) {
        this();
        setSize(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        gfx = (Graphics2D) g;
    }

    public void fill() {
        this.setBackground(defaultColor);
    }

    public void fill(Color c) {
        this.setBackground(c);
    }

    public void fill(int r, int g, int b) {
        this.setBackground(new Color(r, g, b));
    }

    public void fill(float r, float g, float b) {
        this.setBackground(new Color(r, g, b));
    }





    public Graphics2D getGfx() {return gfx;}
    public Mouse getMouse() {
        return mouse;
    }

    public void addListeners() {
        addMouseListener(new WrapMouseListener(this));
        addMouseMotionListener(new WrapMouseMotionListener(this));
        addMouseWheelListener(new WrapMouseWheelListener(this));
    }
}
