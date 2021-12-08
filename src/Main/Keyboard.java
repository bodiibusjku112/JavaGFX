package Main;

import java.util.HashMap;

public class Keyboard {
    HashMap<String, Boolean> keys = null;

    public Keyboard() {
        keys = new HashMap<>();
        reset();
    }

    public Boolean isKeyPressed(int keyCode) {
        return isKeyPressed(translateKey(keyCode));
    }

    public Boolean isKeyPressed(String keyText) {
        Boolean key = false;
        try {
            key = keys.get(keyText);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return key;
    }

    public void press(int keyCode) {
        press(translateKey(keyCode));
    }

    public void press(String keyText) {
        if (!keys.containsKey(keyText)) return;
        keys.put(keyText, true);
    }

    public void release(int keyCode) {
        release(translateKey(keyCode));
    }

    public void release(String keyText) {
        if (!keys.containsKey(keyText)) return;
        keys.put(keyText, false);
    }

    public void reset() {
        int range = 256;
        for (int i = 0; i < range; i++) {
            keys.put(translateKey(i), false);
        }
    }

    /**
     *
     * @param keyCode {@code KeyEvent} key code
     * @return keyText
     * @apiNote {@code 0}: Unknown
     * {@code 1}: Unknown
     * {@code 2}: Unknown
     * {@code 3}: Cancel
     * {@code 4}: Unknown
     * {@code 5}: Unknown
     * {@code 6}: Unknown
     * {@code 7}: Unknown
     * {@code 8}: Backspace
     * {@code 9}: Tab
     * {@code 10}: Enter
     * {@code 11}: Unknown
     * {@code 12}: Clear
     * {@code 13}: Unknown
     * {@code 14}: Unknown
     * {@code 15}: Unknown
     * {@code 16}: Shift
     * {@code 17}: Ctrl
     * {@code 18}: Alt
     * {@code 19}: Pause
     * {@code 20}: Caps Lock
     * {@code 21}: Kana
     * {@code 22}: Unknown
     * {@code 23}: Unknown
     * {@code 24}: Final
     * {@code 25}: Kanji
     * {@code 26}: Unknown
     * {@code 27}: Escape
     * {@code 28}: Convert
     * {@code 29}: No Convert
     * {@code 30}: Accept
     * {@code 31}: Mode Change
     * {@code 32}: Space
     * {@code 33}: Page Up
     * {@code 34}: Page Down
     * {@code 35}: End
     * {@code 36}: Home
     * {@code 37}: Left
     * {@code 38}: Up
     * {@code 39}: Right
     * {@code 40}: Down
     * {@code 41}: Unknown
     * {@code 42}: Unknown
     * {@code 43}: Unknown
     * {@code 44}: Comma
     * {@code 45}: Minus
     * {@code 46}: Period
     * {@code 47}: Slash
     * {@code 48}: 0
     * {@code 49}: 1
     * {@code 50}: 2
     * {@code 51}: 3
     * {@code 52}: 4
     * {@code 53}: 5
     * {@code 54}: 6
     * {@code 55}: 7
     * {@code 56}: 8
     * {@code 57}: 9
     * {@code 58}: Unknown
     * {@code 59}: Semicolon
     * {@code 60}: Unknown
     * {@code 61}: Equals
     * {@code 62}: Unknown
     * {@code 63}: Unknown
     * {@code 64}: Unknown
     * {@code 65}: A
     * {@code 66}: B
     * {@code 67}: C
     * {@code 68}: D
     * {@code 69}: E
     * {@code 70}: F
     * {@code 71}: G
     * {@code 72}: H
     * {@code 73}: I
     * {@code 74}: J
     * {@code 75}: K
     * {@code 76}: L
     * {@code 77}: M
     * {@code 78}: N
     * {@code 79}: O
     * {@code 80}: P
     * {@code 81}: Q
     * {@code 82}: R
     * {@code 83}: S
     * {@code 84}: T
     * {@code 85}: U
     * {@code 86}: V
     * {@code 87}: W
     * {@code 88}: X
     * {@code 89}: Y
     * {@code 90}: Z
     * {@code 91}: Open Bracket
     * {@code 92}: Back Slash
     * {@code 93}: Close Bracket
     * {@code 94}: Unknown
     * {@code 95}: Unknown
     * {@code 96}: NumPad-0
     * {@code 97}: NumPad-1
     * {@code 98}: NumPad-2
     * {@code 99}: NumPad-3
     * {@code 100}: NumPad-4
     * {@code 101}: NumPad-5
     * {@code 102}: NumPad-6
     * {@code 103}: NumPad-7
     * {@code 104}: NumPad-8
     * {@code 105}: NumPad-9
     * {@code 106}: NumPad *
     * {@code 107}: NumPad +
     * {@code 108}: NumPad ,
     * {@code 109}: NumPad -
     * {@code 110}: NumPad .
     * {@code 111}: NumPad /
     * {@code 112}: F1
     * {@code 113}: F2
     * {@code 114}: F3
     * {@code 115}: F4
     * {@code 116}: F5
     * {@code 117}: F6
     * {@code 118}: F7
     * {@code 119}: F8
     * {@code 120}: F9
     * {@code 121}: F10
     * {@code 122}: F11
     * {@code 123}: F12
     * {@code 124}: Unknown
     * {@code 125}: Unknown
     * {@code 126}: Unknown
     * {@code 127}: Delete
     * {@code 128}: Dead Grave
     * {@code 129}: Dead Acute
     * {@code 130}: Dead Circumflex
     * {@code 131}: Dead Tilde
     * {@code 132}: Dead Macron
     * {@code 133}: Dead Breve
     * {@code 134}: Dead Above Dot
     * {@code 135}: Dead Diaeresis
     * {@code 136}: Dead Above Ring
     * {@code 137}: Dead Double Acute
     * {@code 138}: Dead Caron
     * {@code 139}: Dead Cedilla
     * {@code 140}: Dead Ogonek
     * {@code 141}: Dead Iota
     * {@code 142}: Dead Voiced Sound
     * {@code 143}: Dead Semivoiced Sound
     * {@code 144}: Num Lock
     * {@code 145}: Scroll Lock
     * {@code 146}: Unknown
     * {@code 147}: Unknown
     * {@code 148}: Unknown
     * {@code 149}: Unknown
     * {@code 150}: Ampersand
     * {@code 151}: Asterisk
     * {@code 152}: Double Quote
     * {@code 153}: Less
     * {@code 154}: Print Screen
     * {@code 155}: Insert
     * {@code 156}: Help
     * {@code 157}: Meta
     * {@code 158}: Unknown
     * {@code 159}: Unknown
     * {@code 160}: Greater
     * {@code 161}: Left Brace
     * {@code 162}: Right Brace
     * {@code 163}: Unknown
     * {@code 164}: Unknown
     * {@code 165}: Unknown
     * {@code 166}: Unknown
     * {@code 167}: Unknown
     * {@code 168}: Unknown
     * {@code 169}: Unknown
     * {@code 170}: Unknown
     * {@code 171}: Unknown
     * {@code 172}: Unknown
     * {@code 173}: Unknown
     * {@code 174}: Unknown
     * {@code 175}: Unknown
     * {@code 176}: Unknown
     * {@code 177}: Unknown
     * {@code 178}: Unknown
     * {@code 179}: Unknown
     * {@code 180}: Unknown
     * {@code 181}: Unknown
     * {@code 182}: Unknown
     * {@code 183}: Unknown
     * {@code 184}: Unknown
     * {@code 185}: Unknown
     * {@code 186}: Unknown
     * {@code 187}: Unknown
     * {@code 188}: Unknown
     * {@code 189}: Unknown
     * {@code 190}: Unknown
     * {@code 191}: Unknown
     * {@code 192}: Back Quote
     * {@code 193}: Unknown
     * {@code 194}: Unknown
     * {@code 195}: Unknown
     * {@code 196}: Unknown
     * {@code 197}: Unknown
     * {@code 198}: Unknown
     * {@code 199}: Unknown
     * {@code 200}: Unknown
     * {@code 201}: Unknown
     * {@code 202}: Unknown
     * {@code 203}: Unknown
     * {@code 204}: Unknown
     * {@code 205}: Unknown
     * {@code 206}: Unknown
     * {@code 207}: Unknown
     * {@code 208}: Unknown
     * {@code 209}: Unknown
     * {@code 210}: Unknown
     * {@code 211}: Unknown
     * {@code 212}: Unknown
     * {@code 213}: Unknown
     * {@code 214}: Unknown
     * {@code 215}: Unknown
     * {@code 216}: Unknown
     * {@code 217}: Unknown
     * {@code 218}: Unknown
     * {@code 219}: Unknown
     * {@code 220}: Unknown
     * {@code 221}: Unknown
     * {@code 222}: Quote
     * {@code 223}: Unknown
     * {@code 224}: Up
     * {@code 225}: Down
     * {@code 226}: Left
     * {@code 227}: Right
     * {@code 228}: Unknown
     * {@code 229}: Unknown
     * {@code 230}: Unknown
     * {@code 231}: Unknown
     * {@code 232}: Unknown
     * {@code 233}: Unknown
     * {@code 234}: Unknown
     * {@code 235}: Unknown
     * {@code 236}: Unknown
     * {@code 237}: Unknown
     * {@code 238}: Unknown
     * {@code 239}: Unknown
     * {@code 240}: Alphanumeric
     * {@code 241}: Katakana
     * {@code 242}: Hiragana
     * {@code 243}: Full-Width
     * {@code 244}: Half-Width
     * {@code 245}: Roman Characters
     * {@code 246}: Unknown
     * {@code 247}: Unknown
     * {@code 248}: Unknown
     * {@code 249}: Unknown
     * {@code 250}: Unknown
     * {@code 251}: Unknown
     * {@code 252}: Unknown
     * {@code 253}: Unknown
     * {@code 254}: Unknown
     * {@code 255}: Unknown
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
