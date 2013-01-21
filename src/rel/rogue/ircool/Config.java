package rel.rogue.ircool;
/**
 *
 * @author Spencer
 */
public class Config {
    private boolean timestamps = true;
    private java.util.ArrayList<String> defaultchannels = new java.util.ArrayList<>();
    private String defaultnick = "Ralph";
    private String username = "IRCool";
    private String network = "irc.esper.net";
    private String port = "6667";
    
    public boolean enabletime () {
        return timestamps;
    }
    
    public String[] getDefaultChannels() {
        //String[] chans = defaultchannels.toArray(new String[0]);
        String[] chans = new String[defaultchannels.size()];
        defaultchannels.toArray(chans);
        return chans;
    }
    
    public String getNetwork() {
        return network;
    }
    
    public String getDefaultNick() {
        return defaultnick;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setup () {
        //TODO: add a for-loop for reading input from settings box
        defaultchannels.add("#fofftopic");
    }
}
