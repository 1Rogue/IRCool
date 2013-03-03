package rel.rogue.ircool;


/**
 *
 * @author Spencer
 */
public class Utils {
    
    private IRCool client;
    private rel.rogue.ircool.parsers.ChannelParser chanParser;
    private Config settings;
    private rel.rogue.ircool.components.ChannelList chanList;
    private MainGUI gui;
    
    public void link (IRCool irc, rel.rogue.ircool.parsers.ChannelParser cp, Config cf, rel.rogue.ircool.components.ChannelList cl, MainGUI mg) {
        client = irc;
        chanParser = cp;
        settings = cf;
        chanList = cl;
        gui = mg;
    }
    
    public String format (String message) {
        if (settings.enabletime()) {
            message = getTimeStamp() + "  " + message;
        }
        message = message + "\n";
        return message;
    }
    public void print (String channel, String message) {
        message = format(message);
        if ((chanList.getActiveChannel().equals(channel)) || channel.equals("§current")) {
            printCurrent(message);
        }
        else {
            printBackground(channel, message);
        }
    }
    
    public void printBackground (String channel, String message) {
        System.out.print(channel + ": " + message);
        gui.write(channel, message);
    }
    
    public void printCurrent (String message) {
        System.out.print(chanList.getActiveChannel() + ": " + message);
        gui.getTextArea().append(message);
        gui.getTextArea().setCaretPosition(gui.getTextArea().getDocument().getLength());
    }
    public void printConsole (String message) {
        message = format(message);
        System.out.print("Console: " + message);
        gui.write("@@console", message);
        
    }
    public void printMsg (String channel, String sender, String message) {
        print(channel, "<" + sender + "> " + message);
    }
    public void printPrivMsg (String partner, String message, boolean sender) {
        if (sender) {
            print("§current", "* To " + partner + ": " + message);
        }
        else {
            print("§current", "* From " + partner + ": " + message);
        }
    }
    public void printAction (String channel, String sender, String action) {
        print(channel, "* " + sender + " " + action);
    }
    public void printAction (String action) {
        print("§current", "* " + action);
    }
    
    public void printToSet (java.util.Set<org.pircbotx.Channel> set, String message, String parse) {
        switch (parse) {
            case "name":
                String[] channel = chanParser.getChannelNames(set);
                for (int i = 0; i<channel.length; i++) {
                    this.print(channel[i], message);
                }
                break;
            default:
                this.printConsole("Error grabbing printToSet parsing variable");
        }
    }
    public void joinDefaultChans(String chans) {
        String[] temp = chans.split("(, |,)");
        for (int i=0; i<temp.length; i++) {
            this.joinChan(getChan(temp[i]));
        }
    }
    public void joinChan (org.pircbotx.Channel chan) {
        this.printConsole("Attempting to join " + chan.getName());
        client.getUser().joinChannel(chan.getName());
        chanList.addChan(chan);
        //rel.rogue.ircool.MainGUI.updateChannelList();
    }
    
    public org.pircbotx.Channel getChan (String chan) {
        return client.getUser().getChannel(chan);
    }
    
    public boolean isOP(String activeChan, String user) {
        if (client.getUser().getUser(user).getChannelsOpIn().contains(getChan(activeChan))) {
            return true;
        }
        return false;
    }
    public boolean isVoice(String activeChan, String user) {
        if (client.getUser().getUser(user).getChannelsVoiceIn().contains(getChan(activeChan))) {
            return true;
        }
        return false;
    }
    
    public String getFullUser (org.pircbotx.User user) {
        return user.getNick() + "!" + user.getLogin() + "@" + user.getHostmask();
    }
    
    /**
     * 
     * Used for returning system time.
     * 
     * @return 
     */
    
    public String getTimeStamp() {
        return new java.text.SimpleDateFormat(settings.getTimeConfig()).format(new java.util.Date()).toString();
    }
}
