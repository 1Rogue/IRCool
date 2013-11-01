package rel.rogue.ircool;


/**
 *
 * @author Spencer
 */
public class Utils {
    
    private static Config settings = new Config();
    
    public static String format (String message) {
        if (settings.enabletime()) {
            message = getTimeStamp() + "  " + message;
        }
        message = message + "\n";
        return message;
    }
    public static void print (String channel, String message) {
        message = format(message);
        if ((rel.rogue.ircool.components.ChannelList.getActiveChannel().equals(channel)) || channel.equals("§current")) {
            printCurrent(message);
        }
        else {
            printBackground(channel, message);
        }
    }
    
    public static void printBackground (String channel, String message) {
        System.out.print(channel + ": " + message);
        rel.rogue.ircool.components.ChannelList.write(channel, message);
    }
    
    public static void printCurrent (String message) {
        System.out.print(rel.rogue.ircool.components.ChannelList.getActiveChannel() + ": " + message);
        MainGUI.getTextArea().append(message);
        MainGUI.getTextArea().setCaretPosition(MainGUI.getTextArea().getDocument().getLength());
    }
    public static void printConsole (String message) {
        message = format(message);
        System.out.print("Console: " + message);
        if (rel.rogue.ircool.components.ChannelList.getActiveChannel().equals("@@console")) {
            printCurrent(message);
        }
        else {
            rel.rogue.ircool.components.ChannelList.write("@@console", message);
        }
    }
    public static void printMsg (String channel, String sender, String message) {
        print(channel, "<" + sender + "> " + message);
    }
    public static void printPrivMsg (String partner, String message, boolean sender) {
        if (sender) {
            print("§current", "* To " + partner + ": " + message);
        }
        else {
            print("§current", "* From " + partner + ": " + message);
        }
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
                String[] channel = rel.rogue.ircool.parsers.ChannelParser.getChannelNames(set);
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
        Utils.printConsole("Attempting to join " + chan.getName());
        rel.rogue.ircool.IRCool.getUser().joinChannel(chan.getName());
        rel.rogue.ircool.components.ChannelList.addChan(chan);
        //rel.rogue.ircool.MainGUI.updateChannelList();
    }
    
    public static org.pircbotx.Channel getChan (String chan) {
        return rel.rogue.ircool.IRCool.getUser().getChannel(chan);
    }
    
    static boolean isOP(String activeChan, String user) {
        if (rel.rogue.ircool.IRCool.getUser().getUser(user).getChannelsOpIn().contains(getChan(activeChan))) {
            return true;
        }
        return false;
    }
    static boolean isVoice(String activeChan, String user) {
        if (rel.rogue.ircool.IRCool.getUser().getUser(user).getChannelsVoiceIn().contains(getChan(activeChan))) {
            return true;
        }
        return false;
    }
    
    public static String getFullUser (org.pircbotx.User user) {
        return user.getNick() + "!" + user.getLogin() + "@" + user.getHostmask();
    }
    
    /**
     * 
     * Used for returning system time.
     * 
     * @return 
     */
    
    public static String getTimeStamp() {
        return new java.text.SimpleDateFormat(settings.getTimeConfig()).format(new java.util.Date()).toString();
    }
}
