package Main;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;



public class Keyboard {

    public static class Event {
        public enum type {
            PRESS,
            RELEASE,
            CHAR,
            UNKNOWN
        }
        private type kType;
        private String kKey;
        private String kChar;
        public Event() {
            this.kChar = "";
            this.kKey = "Unknown";
            this.kType = type.UNKNOWN;
        }
        public Event(type t, KeyEvent e) {
            this();
            this.kKey = translateKey(e.getKeyCode());
            this.kChar = String.valueOf(e.getKeyChar());
            this.kType = t;
        }
    }



    private static int eventQueueLimit = 16;
    private LinkedList<Event> eventQueue;
    private String charString = null;
    private HashMap<String, Boolean> keys = null;

    public Keyboard() {
        keys = new HashMap<>();
        clearKeys();
        clearCharString();
    }

    public void addEvent(Event e) {
        if (eventQueue.size() <= eventQueueLimit) this.eventQueue.add(e);
    }

    public void clearEvents() { eventQueue.clear(); }
    public void clearCharString() { charString = ""; }
    public void clearKeys() { keys.replaceAll((k, v) -> false); }

    public void clear() {
        clearEvents();
        clearCharString();
    }

    public void processEvent() {
        while (!eventQueue.isEmpty()) {
            Event e = eventQueue.removeFirst();
            switch (e.kType) {
                case PRESS: {
                    press(e.kKey);
                    break;
                }
                case RELEASE: {
                    release(e.kKey);
                    break;
                }
                case CHAR: {
                    this.charString += e.kChar;
                }
            }
        }
    }

    public Boolean isKeyPressed(String keyText) {
        Boolean key = false;
        if (keys.containsKey(keyText))
            key = keys.get(keyText);
        return key;
    }

    public void press(String keyText) {
        if (!keys.containsKey(keyText)) return;
        if (keys.get(keyText)) return;
        keys.put(keyText, true);
    }

    public void release(String keyText) {
        if (!keys.containsKey(keyText)) return;
        if (!keys.get(keyText)) return;
        keys.put(keyText, false);
    }

    public Boolean isKeyPressed(int keyCode) {
        return isKeyPressed(translateKey(keyCode));
    }
    public void press(int keyCode) {
        press(translateKey(keyCode));
    }
    public void release(int keyCode) {
        release(translateKey(keyCode));
    }



    /**
     *
     * @param keyCode {@code KeyEvent} key code
     * @return keyText
     * @apiNote {@code 0}: Unknown
     * <p>{@code 1}: Unknown
     * <p>{@code 2}: Unknown
     * <p>{@code 3}: Cancel
     * <p>{@code 4}: Unknown
     * <p>{@code 5}: Unknown
     * <p>{@code 6}: Unknown
     * <p>{@code 7}: Unknown
     * <p>{@code 8}: Backspace
     * <p>{@code 9}: Tab
     * <p>{@code 10}: Enter
     * <p>{@code 11}: Unknown
     * <p>{@code 12}: Clear
     * <p>{@code 13}: Unknown
     * <p>{@code 14}: Unknown
     * <p>{@code 15}: Unknown
     * <p>{@code 16}: Shift
     * <p>{@code 17}: Ctrl
     * <p>{@code 18}: Alt
     * <p>{@code 19}: Pause
     * <p>{@code 20}: Caps Lock
     * <p>{@code 21}: Kana
     * <p>{@code 22}: Unknown
     * <p>{@code 23}: Unknown
     * <p>{@code 24}: Final
     * <p>{@code 25}: Kanji
     * <p>{@code 26}: Unknown
     * <p>{@code 27}: Escape
     * <p>{@code 28}: Convert
     * <p>{@code 29}: No Convert
     * <p>{@code 30}: Accept
     * <p>{@code 31}: Mode Change
     * <p>{@code 32}: Space
     * <p>{@code 33}: Page Up
     * <p>{@code 34}: Page Down
     * <p>{@code 35}: End
     * <p>{@code 36}: Home
     * <p>{@code 37}: Left
     * <p>{@code 38}: Up
     * <p>{@code 39}: Right
     * <p>{@code 40}: Down
     * <p>{@code 41}: Unknown
     * <p>{@code 42}: Unknown
     * <p>{@code 43}: Unknown
     * <p>{@code 44}: Comma
     * <p>{@code 45}: Minus
     * <p>{@code 46}: Period
     * <p>{@code 47}: Slash
     * <p>{@code 48}: 0
     * <p>{@code 49}: 1
     * <p>{@code 50}: 2
     * <p>{@code 51}: 3
     * <p>{@code 52}: 4
     * <p>{@code 53}: 5
     * <p>{@code 54}: 6
     * <p>{@code 55}: 7
     * <p>{@code 56}: 8
     * <p>{@code 57}: 9
     * <p>{@code 58}: Unknown
     * <p>{@code 59}: Semicolon
     * <p>{@code 60}: Unknown
     * <p>{@code 61}: Equals
     * <p>{@code 62}: Unknown
     * <p>{@code 63}: Unknown
     * <p>{@code 64}: Unknown
     * <p>{@code 65}: A
     * <p>{@code 66}: B
     * <p>{@code 67}: C
     * <p>{@code 68}: D
     * <p>{@code 69}: E
     * <p>{@code 70}: F
     * <p>{@code 71}: G
     * <p>{@code 72}: H
     * <p>{@code 73}: I
     * <p>{@code 74}: J
     * <p>{@code 75}: K
     * <p>{@code 76}: L
     * <p>{@code 77}: M
     * <p>{@code 78}: N
     * <p>{@code 79}: O
     * <p>{@code 80}: P
     * <p>{@code 81}: Q
     * <p>{@code 82}: R
     * <p>{@code 83}: S
     * <p>{@code 84}: T
     * <p>{@code 85}: U
     * <p>{@code 86}: V
     * <p>{@code 87}: W
     * <p>{@code 88}: X
     * <p>{@code 89}: Y
     * <p>{@code 90}: Z
     * <p>{@code 91}: Open Bracket
     * <p>{@code 92}: Back Slash
     * <p>{@code 93}: Close Bracket
     * <p>{@code 94}: Unknown
     * <p>{@code 95}: Unknown
     * <p>{@code 96}: NumPad-0
     * <p>{@code 97}: NumPad-1
     * <p>{@code 98}: NumPad-2
     * <p>{@code 99}: NumPad-3
     * <p>{@code 100}: NumPad-4
     * <p>{@code 101}: NumPad-5
     * <p>{@code 102}: NumPad-6
     * <p>{@code 103}: NumPad-7
     * <p>{@code 104}: NumPad-8
     * <p>{@code 105}: NumPad-9
     * <p>{@code 106}: NumPad *
     * <p>{@code 107}: NumPad +
     * <p>{@code 108}: NumPad ,
     * <p>{@code 109}: NumPad -
     * <p>{@code 110}: NumPad .
     * <p>{@code 111}: NumPad /
     * <p>{@code 112}: F1
     * <p>{@code 113}: F2
     * <p>{@code 114}: F3
     * <p>{@code 115}: F4
     * <p>{@code 116}: F5
     * <p>{@code 117}: F6
     * <p>{@code 118}: F7
     * <p>{@code 119}: F8
     * <p>{@code 120}: F9
     * <p>{@code 121}: F10
     * <p>{@code 122}: F11
     * <p>{@code 123}: F12
     * <p>{@code 124}: Unknown
     * <p>{@code 125}: Unknown
     * <p>{@code 126}: Unknown
     * <p>{@code 127}: Delete
     * <p>{@code 128}: Dead Grave
     * <p>{@code 129}: Dead Acute
     * <p>{@code 130}: Dead Circumflex
     * <p>{@code 131}: Dead Tilde
     * <p>{@code 132}: Dead Macron
     * <p>{@code 133}: Dead Breve
     * <p>{@code 134}: Dead Above Dot
     * <p>{@code 135}: Dead Diaeresis
     * <p>{@code 136}: Dead Above Ring
     * <p>{@code 137}: Dead Double Acute
     * <p>{@code 138}: Dead Caron
     * <p>{@code 139}: Dead Cedilla
     * <p>{@code 140}: Dead Ogonek
     * <p>{@code 141}: Dead Iota
     * <p>{@code 142}: Dead Voiced Sound
     * <p>{@code 143}: Dead Semivoiced Sound
     * <p>{@code 144}: Num Lock
     * <p>{@code 145}: Scroll Lock
     * <p>{@code 146}: Unknown
     * <p>{@code 147}: Unknown
     * <p>{@code 148}: Unknown
     * <p>{@code 149}: Unknown
     * <p>{@code 150}: Ampersand
     * <p>{@code 151}: Asterisk
     * <p>{@code 152}: Double Quote
     * <p>{@code 153}: Less
     * <p>{@code 154}: Print Screen
     * <p>{@code 155}: Insert
     * <p>{@code 156}: Help
     * <p>{@code 157}: Meta
     * <p>{@code 158}: Unknown
     * <p>{@code 159}: Unknown
     * <p>{@code 160}: Greater
     * <p>{@code 161}: Left Brace
     * <p>{@code 162}: Right Brace
     * <p>{@code 163}: Unknown
     * <p>{@code 164}: Unknown
     * <p>{@code 165}: Unknown
     * <p>{@code 166}: Unknown
     * <p>{@code 167}: Unknown
     * <p>{@code 168}: Unknown
     * <p>{@code 169}: Unknown
     * <p>{@code 170}: Unknown
     * <p>{@code 171}: Unknown
     * <p>{@code 172}: Unknown
     * <p>{@code 173}: Unknown
     * <p>{@code 174}: Unknown
     * <p>{@code 175}: Unknown
     * <p>{@code 176}: Unknown
     * <p>{@code 177}: Unknown
     * <p>{@code 178}: Unknown
     * <p>{@code 179}: Unknown
     * <p>{@code 180}: Unknown
     * <p>{@code 181}: Unknown
     * <p>{@code 182}: Unknown
     * <p>{@code 183}: Unknown
     * <p>{@code 184}: Unknown
     * <p>{@code 185}: Unknown
     * <p>{@code 186}: Unknown
     * <p>{@code 187}: Unknown
     * <p>{@code 188}: Unknown
     * <p>{@code 189}: Unknown
     * <p>{@code 190}: Unknown
     * <p>{@code 191}: Unknown
     * <p>{@code 192}: Back Quote
     * <p>{@code 193}: Unknown
     * <p>{@code 194}: Unknown
     * <p>{@code 195}: Unknown
     * <p>{@code 196}: Unknown
     * <p>{@code 197}: Unknown
     * <p>{@code 198}: Unknown
     * <p>{@code 199}: Unknown
     * <p>{@code 200}: Unknown
     * <p>{@code 201}: Unknown
     * <p>{@code 202}: Unknown
     * <p>{@code 203}: Unknown
     * <p>{@code 204}: Unknown
     * <p>{@code 205}: Unknown
     * <p>{@code 206}: Unknown
     * <p>{@code 207}: Unknown
     * <p>{@code 208}: Unknown
     * <p>{@code 209}: Unknown
     * <p>{@code 210}: Unknown
     * <p>{@code 211}: Unknown
     * <p>{@code 212}: Unknown
     * <p>{@code 213}: Unknown
     * <p>{@code 214}: Unknown
     * <p>{@code 215}: Unknown
     * <p>{@code 216}: Unknown
     * <p>{@code 217}: Unknown
     * <p>{@code 218}: Unknown
     * <p>{@code 219}: Unknown
     * <p>{@code 220}: Unknown
     * <p>{@code 221}: Unknown
     * <p>{@code 222}: Quote
     * <p>{@code 223}: Unknown
     * <p>{@code 224}: Up
     * <p>{@code 225}: Down
     * <p>{@code 226}: Left
     * <p>{@code 227}: Right
     * <p>{@code 228}: Unknown
     * <p>{@code 229}: Unknown
     * <p>{@code 230}: Unknown
     * <p>{@code 231}: Unknown
     * <p>{@code 232}: Unknown
     * <p>{@code 233}: Unknown
     * <p>{@code 234}: Unknown
     * <p>{@code 235}: Unknown
     * <p>{@code 236}: Unknown
     * <p>{@code 237}: Unknown
     * <p>{@code 238}: Unknown
     * <p>{@code 239}: Unknown
     * <p>{@code 240}: Alphanumeric
     * <p>{@code 241}: Katakana
     * <p>{@code 242}: Hiragana
     * <p>{@code 243}: Full-Width
     * <p>{@code 244}: Half-Width
     * <p>{@code 245}: Roman Characters
     * <p>{@code 246}: Unknown
     * <p>{@code 247}: Unknown
     * <p>{@code 248}: Unknown
     * <p>{@code 249}: Unknown
     * <p>{@code 250}: Unknown
     * <p>{@code 251}: Unknown
     * <p>{@code 252}: Unknown
     * <p>{@code 253}: Unknown
     * <p>{@code 254}: Unknown
     * <p>{@code 255}: Unknown
     */
    private static String translateKey(int keyCode) {
        String keyText = "Unknown";
        switch (keyCode) {
            case 3: {
                keyText = "Cancel";
                break;
            }
            case 8: {
                keyText = "Backspace";
                break;
            }
            case 9: {
                keyText = "Tab";
                break;
            }
            case 10: {
                keyText = "Enter";
                break;
            }
            case 12: {
                keyText = "Clear";
                break;
            }
            case 16: {
                keyText = "Shift";
                break;
            }
            case 17: {
                keyText = "Ctrl";
                break;
            }
            case 18: {
                keyText = "Alt";
                break;
            }
            case 19: {
                keyText = "Pause";
                break;
            }
            case 20: {
                keyText = "Caps Lock";
                break;
            }
            case 21: {
                keyText = "Kana";
                break;
            }
            case 24: {
                keyText = "Final";
                break;
            }
            case 25: {
                keyText = "Kanji";
                break;
            }
            case 27: {
                keyText = "Escape";
                break;
            }
            case 28: {
                keyText = "Convert";
                break;
            }
            case 29: {
                keyText = "No Convert";
                break;
            }
            case 30: {
                keyText = "Accept";
                break;
            }
            case 31: {
                keyText = "Mode Change";
                break;
            }
            case 32: {
                keyText = "Space";
                break;
            }
            case 33: {
                keyText = "Page Up";
                break;
            }
            case 34: {
                keyText = "Page Down";
                break;
            }
            case 35: {
                keyText = "End";
                break;
            }
            case 36: {
                keyText = "Home";
                break;
            }
            case 37: {
                keyText = "Left";
                break;
            }
            case 38: {
                keyText = "Up";
                break;
            }
            case 39: {
                keyText = "Right";
                break;
            }
            case 40: {
                keyText = "Down";
                break;
            }
            case 44: {
                keyText = "Comma";
                break;
            }
            case 45: {
                keyText = "Minus";
                break;
            }
            case 46: {
                keyText = "Period";
                break;
            }
            case 47: {
                keyText = "Slash";
                break;
            }
            case 48: {
                keyText = "0";
                break;
            }
            case 49: {
                keyText = "1";
                break;
            }
            case 50: {
                keyText = "2";
                break;
            }
            case 51: {
                keyText = "3";
                break;
            }
            case 52: {
                keyText = "4";
                break;
            }
            case 53: {
                keyText = "5";
                break;
            }
            case 54: {
                keyText = "6";
                break;
            }
            case 55: {
                keyText = "7";
                break;
            }
            case 56: {
                keyText = "8";
                break;
            }
            case 57: {
                keyText = "9";
                break;
            }
            case 59: {
                keyText = "Semicolon";
                break;
            }
            case 61: {
                keyText = "Equals";
                break;
            }
            case 65: {
                keyText = "A";
                break;
            }
            case 66: {
                keyText = "B";
                break;
            }
            case 67: {
                keyText = "C";
                break;
            }
            case 68: {
                keyText = "D";
                break;
            }
            case 69: {
                keyText = "E";
                break;
            }
            case 70: {
                keyText = "F";
                break;
            }
            case 71: {
                keyText = "G";
                break;
            }
            case 72: {
                keyText = "H";
                break;
            }
            case 73: {
                keyText = "I";
                break;
            }
            case 74: {
                keyText = "J";
                break;
            }
            case 75: {
                keyText = "K";
                break;
            }
            case 76: {
                keyText = "L";
                break;
            }
            case 77: {
                keyText = "M";
                break;
            }
            case 78: {
                keyText = "N";
                break;
            }
            case 79: {
                keyText = "O";
                break;
            }
            case 80: {
                keyText = "P";
                break;
            }
            case 81: {
                keyText = "Q";
                break;
            }
            case 82: {
                keyText = "R";
                break;
            }
            case 83: {
                keyText = "S";
                break;
            }
            case 84: {
                keyText = "T";
                break;
            }
            case 85: {
                keyText = "U";
                break;
            }
            case 86: {
                keyText = "V";
                break;
            }
            case 87: {
                keyText = "W";
                break;
            }
            case 88: {
                keyText = "X";
                break;
            }
            case 89: {
                keyText = "Y";
                break;
            }
            case 90: {
                keyText = "Z";
                break;
            }
            case 91: {
                keyText = "Open Bracket";
                break;
            }
            case 92: {
                keyText = "Back Slash";
                break;
            }
            case 93: {
                keyText = "Close Bracket";
                break;
            }
            case 96: {
                keyText = "NumPad-0";
                break;
            }
            case 97: {
                keyText = "NumPad-1";
                break;
            }
            case 98: {
                keyText = "NumPad-2";
                break;
            }
            case 99: {
                keyText = "NumPad-3";
                break;
            }
            case 100: {
                keyText = "NumPad-4";
                break;
            }
            case 101: {
                keyText = "NumPad-5";
                break;
            }
            case 102: {
                keyText = "NumPad-6";
                break;
            }
            case 103: {
                keyText = "NumPad-7";
                break;
            }
            case 104: {
                keyText = "NumPad-8";
                break;
            }
            case 105: {
                keyText = "NumPad-9";
                break;
            }
            case 106: {
                keyText = "NumPad *";
                break;
            }
            case 107: {
                keyText = "NumPad +";
                break;
            }
            case 108: {
                keyText = "NumPad ,";
                break;
            }
            case 109: {
                keyText = "NumPad -";
                break;
            }
            case 110: {
                keyText = "NumPad .";
                break;
            }
            case 111: {
                keyText = "NumPad /";
                break;
            }
            case 112: {
                keyText = "F1";
                break;
            }
            case 113: {
                keyText = "F2";
                break;
            }
            case 114: {
                keyText = "F3";
                break;
            }
            case 115: {
                keyText = "F4";
                break;
            }
            case 116: {
                keyText = "F5";
                break;
            }
            case 117: {
                keyText = "F6";
                break;
            }
            case 118: {
                keyText = "F7";
                break;
            }
            case 119: {
                keyText = "F8";
                break;
            }
            case 120: {
                keyText = "F9";
                break;
            }
            case 121: {
                keyText = "F10";
                break;
            }
            case 122: {
                keyText = "F11";
                break;
            }
            case 123: {
                keyText = "F12";
                break;
            }
            case 127: {
                keyText = "Delete";
                break;
            }
            case 128: {
                keyText = "Dead Grave";
                break;
            }
            case 129: {
                keyText = "Dead Acute";
                break;
            }
            case 130: {
                keyText = "Dead Circumflex";
                break;
            }
            case 131: {
                keyText = "Dead Tilde";
                break;
            }
            case 132: {
                keyText = "Dead Macron";
                break;
            }
            case 133: {
                keyText = "Dead Breve";
                break;
            }
            case 134: {
                keyText = "Dead Above Dot";
                break;
            }
            case 135: {
                keyText = "Dead Diaeresis";
                break;
            }
            case 136: {
                keyText = "Dead Above Ring";
                break;
            }
            case 137: {
                keyText = "Dead Double Acute";
                break;
            }
            case 138: {
                keyText = "Dead Caron";
                break;
            }
            case 139: {
                keyText = "Dead Cedilla";
                break;
            }
            case 140: {
                keyText = "Dead Ogonek";
                break;
            }
            case 141: {
                keyText = "Dead Iota";
                break;
            }
            case 142: {
                keyText = "Dead Voiced Sound";
                break;
            }
            case 143: {
                keyText = "Dead Semivoiced Sound";
                break;
            }
            case 144: {
                keyText = "Num Lock";
                break;
            }
            case 145: {
                keyText = "Scroll Lock";
                break;
            }
            case 150: {
                keyText = "Ampersand";
                break;
            }
            case 151: {
                keyText = "Asterisk";
                break;
            }
            case 152: {
                keyText = "Double Quote";
                break;
            }
            case 153: {
                keyText = "Less";
                break;
            }
            case 154: {
                keyText = "Print Screen";
                break;
            }
            case 155: {
                keyText = "Insert";
                break;
            }
            case 156: {
                keyText = "Help";
                break;
            }
            case 157: {
                keyText = "Meta";
                break;
            }
            case 160: {
                keyText = "Greater";
                break;
            }
            case 161: {
                keyText = "Left Brace";
                break;
            }
            case 162: {
                keyText = "Right Brace";
                break;
            }
            case 192: {
                keyText = "Back Quote";
                break;
            }
            case 222: {
                keyText = "Quote";
                break;
            }
            case 224: {
                keyText = "Up";
                break;
            }
            case 225: {
                keyText = "Down";
                break;
            }
            case 226: {
                keyText = "Left";
                break;
            }
            case 227: {
                keyText = "Right";
                break;
            }
            case 240: {
                keyText = "Alphanumeric";
                break;
            }
            case 241: {
                keyText = "Katakana";
                break;
            }
            case 242: {
                keyText = "Hiragana";
                break;
            }
            case 243: {
                keyText = "Full-Width";
                break;
            }
            case 244: {
                keyText = "Half-Width";
                break;
            }
            case 245: {
                keyText = "Roman Characters";
                break;
            }
            default: {
                keyText = "Unknown";
            }
        }
        return keyText;
    }
}
