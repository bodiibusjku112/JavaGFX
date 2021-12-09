package Main;

import Main.Graphics.DrawCanvas;
import Main.Listeners.WrapKeyListener;
import Main.Listeners.WrapWindowAdapter;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame {
    int width;
    int height;
    int displayWidth = 1366;
    int displayHeight = 768;
    int windowedWidth;
    int windowedHeight;
    DrawCanvas canvas;
    Boolean fullscreen = false;
    Keyboard keyboard;
    Mouse mouse;

    public Window(String name, int width, int height) {
        super(name);

        this.setSize(width, height);
        canvas = new DrawCanvas(width, height);
        canvas.setPreferredSize(new Dimension(width, height));
        this.add(canvas);
        this.pack();
        this.windowedWidth = (int)this.getSize().getWidth();
        this.windowedHeight = (int)this.getSize().getHeight();

        this.setResizable(false);
        this.setFocusTraversalKeysEnabled(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Insets insets = this.getInsets();
        this.setSize(width + insets.right + insets.left, height + insets.top + insets.bottom);
        canvas.setLocation(insets.right, insets.top);

        this.keyboard = new Keyboard();
        this.mouse = canvas.getMouse();

        addListeners();

        System.out.println(this.getInsets());
    }

    private void addListeners() {

        addKeyListener(new WrapKeyListener(this));
        addWindowListener(new WrapWindowAdapter());
        canvas.addListeners();
    }

    public int run() {
        while(true) {

            if (keyboard.isKeyPressed("Escape")) break;
            if (keyboard.isKeyPressed("F5")) toggleFullscreen();
            if (mouse.isButtonPressed("AMB1")) break;
        }
        return 0;
    }

    public void toggleFullscreen() {
        this.setUndecorated(!this.isUndecorated());
        if (fullscreen) {
            this.width = displayWidth;
            this.height = displayHeight;
            this.setAlwaysOnTop(true);
        }
        else {
            this.width = windowedWidth;
            this.height = windowedHeight;
            this.setAlwaysOnTop(false);
        }
    }

    public Keyboard getKeyboard() {
        return this.keyboard;
    }
}
