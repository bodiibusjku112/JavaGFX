package Main.Listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WrapWindowAdapter extends WindowAdapter {
    public WrapWindowAdapter() {
        super();
    }
    public void windowOpened(WindowEvent e) {
        System.out.println("Window Opened Event");
    }

    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing Event");
    }

    public void windowClosed(WindowEvent e) {
        System.out.println("Window Close Event");
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("Window Iconified Event");
    }

    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window Deiconified Event");
    }

    public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated Event");
    }

    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window Deactivated Event");
    }

    public void windowStateChanged(WindowEvent e) {
        System.out.println("Window State Changed Event");
    }

    public void windowGainedFocus(WindowEvent e) {
        System.out.println("Window Gained Focus Event");
    }

    public void windowLostFocus(WindowEvent e) {
        System.out.println("Window Lost Focus Event");
    }
}
