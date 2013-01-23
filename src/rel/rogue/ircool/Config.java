package rel.rogue.ircool;

/**
 *
 * @author Spencer
 */
public class Config {
    
    //TO-DO convert priv variables to configuration in program
    private boolean timestamps = true;
    private String defaultnick = "Ralph";
    private String username = "IRCool";
    private String network = "irc.esper.net";
    private String port = "6667";
    private String defaultChans = "#Rogue, #ae97";
    
    public boolean enabletime () {
        return timestamps;
    }
    
    /*public String[] getDefaultChannels() {
        //String[] chans = defaultchannels.toArray(new String[0]);
        String[] chans = new String[defaultchannels.size()];
        defaultchannels.toArray(chans);
        return chans;
    }*/
    
    public String getNetwork() {
        return network;
    }
    
    public String getDefaultNick() {
        return defaultnick;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getDefaultChans() {
        return defaultChans;
    }
}
