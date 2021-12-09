package Main;

import java.awt.*;

public class MouseCoordinates extends  {
    int x = 0;
    int y = 0;

    public MouseCoordinates() {

    }

    public MouseCoordinates(int x, int y) {
        this();
        set(x, y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MouseCoordinates get() {
        return this;
    }
}
