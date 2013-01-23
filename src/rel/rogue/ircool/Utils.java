package rel.rogue.ircool;

import java.util.Calendar;

/**
 *
 * @author Spencer
 */
public class Utils {
    
    private static Config settings = new Config();
    private static String time = "[" + getTime() + "] ";
    
    public static String format (String message) {
        if (settings.enabletime()) {
            message = time + "  " + message;
        }
        message = message + "\n";
        return message;
    }
    public static void print (String channel, String message) {
        message = format(message);
        System.out.print(channel + ": " + message);
        MainGUI.write(channel, message);
        MainGUI.getTextArea().append(message);
        MainGUI.getTextArea().setCaretPosition(MainGUI.getTextArea().getDocument().getLength());
    }
    public static void printCurrent (String message) {
        message = format(message);
        System.out.print(MainGUI.getActiveChannel() + ": " + message);
        if (MainGUI.getTextArea() != null) {
            MainGUI.getTextArea().append(message);
            MainGUI.getTextArea().setCaretPosition(MainGUI.getTextArea().getDocument().getLength());
        }
        else {
            System.err.println("Cannot append message to Text Area!");
        }
    }
    public static void printConsole (String message) {
        message = format(message);
        System.out.print("Console: " + message);
        MainGUI.write("@@console", message);
        
    }
    public static void printMsg (String channel, String sender, String message) {
        print(channel, "<" + sender + "> " + message);
    }
    public static void printAction (String channel, String sender, String action) {
        print(channel, "* " + sender + " " + action);
    }
    public static void joinDefaultChans(String chans) {
        String[] temp = chans.split("(, |,)");
        for (int i=0; i<temp.length; i++) {
            Utils.joinChan(temp[i]);
        }
    }
    public static void joinChan (String chan) {
        Utils.printCurrent("Attempting to join " + chan);
        rel.rogue.ircool.IRCool.getUser().joinChannel(chan);
        rel.rogue.ircool.MainGUI.addChan(chan);
        MainGUI.updateChannelList();
    }
    
    /**
     * 
     * Used for temporary command in EventHandler class.
     * 
     * @param s
     * @return 
     */
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
    
    /**
     * 
     * Used for returning system time.
     * 
     * @deprecated
     * @return 
     */
    public static String getTime() {
        int hour = Calendar.HOUR;
        int minute = Calendar.MINUTE;
        return hour + ":" + minute;
    }
}
