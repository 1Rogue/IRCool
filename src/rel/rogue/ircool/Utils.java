package rel.rogue.ircool;

import java.util.Calendar;

/**
 *
 * @author Spencer
 */
public class Utils {
    
    private static Config settings = new Config();
    private static String time = "[" + getTime() + "] ";
    
    public static void print (String s) {
        if (settings.enabletime()) {
            System.out.print(time);
        }
        System.out.println(s);
    }
    public static void printMsg (String sender, String message) {
        print("<" + sender + "> " + message);
    }
    public static void printAction (String sender, String action) {
        print("* " + sender + " " + action);
    }
    public static String vowel (String s) {
        if (s.startsWith("a") ||
                s.startsWith("A") ||
                s.startsWith("e") ||
                s.startsWith("E") ||
                s.startsWith("i") ||
                s.startsWith("I") ||
                s.startsWith("o") ||
                s.startsWith("O") ||
                s.startsWith("u") ||
                s.startsWith("U")) {
            return "an";
        }
        else {
            return "a";
        }
    }
    public static String getTime() {
        int hour = Calendar.HOUR;
        int minute = Calendar.MINUTE;
        return hour + ":" + minute;
    }
}
