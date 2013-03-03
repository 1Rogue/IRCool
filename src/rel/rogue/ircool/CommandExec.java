package rel.rogue.ircool;

/**
 *
 * @author Spencer
 */
public abstract class CommandExec {
    
    protected ClassLink CL = new ClassLink();
    protected IRCool client = new IRCool();
    protected Utils Utils = CL.getUtils();
    protected org.pircbotx.PircBotX user = client.getUser();
    protected MainGUI gui = CL.getMainGUI();
    protected rel.rogue.ircool.components.ChannelList chanList = CL.getChanList();
    
    public abstract void onCommand (String[] args);
    
    public abstract String[] getTriggers();
    
    public abstract String getUsage();
    
    public abstract boolean takesArgs();
    
    public abstract boolean requiresArgs();
}
