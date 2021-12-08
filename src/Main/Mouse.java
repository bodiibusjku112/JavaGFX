package Main;

import java.util.HashMap;

public class Mouse {
    MouseCoordinates position;
    HashMap<String, Boolean> buttons;

    public Mouse() {
        position = new MouseCoordinates(0, 0);
        buttons = new HashMap<>();
        reset();
    }

    public Mouse(int x, int y) {
        this();
        position.set(x, y);
    }

    public Boolean isButtonPressed(String button) {
        if (!buttons.containsKey(button)) return false;
        return buttons.get(button);
    }

    public Boolean isButtonPressed(int button) {
        return isButtonPressed(translateButton(button));
    }

    public void press(String button) {
        if (!buttons.containsKey(button)) return;
        buttons.put(button, true);
    }

    public void press(int button) {
        press(translateButton(button));
    }

    public void release(String button) {
        if (!buttons.containsKey(button)) return;
        buttons.put(button, false);
    }

    public void release(int button) {
        release(translateButton(button));
    }

    public static String translateButton(int button) {
        switch (button) {
            case 1: return "LMB";
            case 2: return "MMB";
            case 3: return "RMB";
            case 4: return "AMB1";
            case 5: return "AMB2";
            default: return "Unknown";
        }
    }

    public void reset() {
        buttons.put("LMB", false);
        buttons.put("MMB", false);
        buttons.put("RMB", false);
        buttons.put("AMB1", false);
        buttons.put("AMB2", false);
    }
}
