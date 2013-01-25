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
        if ((MainGUI.getActiveChannel().equals(channel)) || channel.equals("§current")) {
            printCurrent(message);
        }
        else {
            printBackground(channel, message);
        }
    }
    
    public static void printBackground (String channel, String message) {
        System.out.print(channel + ": " + message);
        MainGUI.write(channel, message);
    }
    
    public static void printCurrent (String message) {
        System.out.print(MainGUI.getActiveChannel() + ": " + message);
        MainGUI.getTextArea().append(message);
        MainGUI.getTextArea().setCaretPosition(MainGUI.getTextArea().getDocument().getLength());
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
    public static void printAction (String action) {
        print("§current", "* " + action);
    }
    
    public static void printToSet (java.util.Set<org.pircbotx.Channel> set, String message, String parse) {
        switch (parse) {
            case "name":
                //TODO make channel parser class, instead of print statement.
                String[] channel = rel.rogue.ircool.Parsers.ChannelParser.getChannelNames(set);
                for (int i = 0; i<channel.length; i++) {
                    Utils.print(channel[i], message);
                }
                break;
            default:
                Utils.printConsole("Error grabbing printToSet parsing variable");
        }
    }
    public static void joinDefaultChans(String chans) {
        String[] temp = chans.split("(, |,)");
        for (int i=0; i<temp.length; i++) {
            Utils.joinChan(getChan(temp[i]));
        }
    }
    public static void joinChan (org.pircbotx.Channel chan) {
        Object[] users = rel.rogue.ircool.Parsers.ChannelParser.getChannelUsers(chan.getUsers());
        Utils.printConsole("Attempting to join " + chan.getName());
        rel.rogue.ircool.IRCool.getUser().joinChannel(chan.getName());
        rel.rogue.ircool.MainGUI.addChan(chan);
        MainGUI.updateChannelList();
    }
    
    public static org.pircbotx.Channel getChan (String chan) {
        return rel.rogue.ircool.IRCool.getUser().getChannel(chan);
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
