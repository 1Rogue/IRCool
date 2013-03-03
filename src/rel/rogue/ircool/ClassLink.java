package rel.rogue.ircool;

/**
 *
 * @author Spencer
 */
public class ClassLink {
    private IRCool IRCool;
    private Config Config = new Config();
    private MainGUI MainGUI = new MainGUI();
    private EventHandler EventHandler = new EventHandler();
    private CommandHandler CommandHandler = new CommandHandler();
    private Utils Utils = new Utils();
    private rel.rogue.ircool.parsers.ChannelParser ChannelParser = new rel.rogue.ircool.parsers.ChannelParser();
    private rel.rogue.ircool.components.ChannelList chanList = new rel.rogue.ircool.components.ChannelList();
    //private CommmandExec CommandExec = new CommandExec();
    
    public void connectClasses(IRCool main) {
        IRCool = main;
        IRCool.link(Config, EventHandler, CommandHandler, Utils, chanList);
        MainGUI.link(IRCool, Utils, Config, CommandHandler, chanList);
        CommandHandler.link(Utils);
        Utils.link(IRCool, ChannelParser, Config, chanList, MainGUI);
        EventHandler.link(IRCool, Utils, MainGUI, chanList, Config);
        chanList.link(ChannelParser, MainGUI);
    }
    
    //If all else fails (or if there's an abstract class), we have some getters
    public IRCool getIRCool() {
        return IRCool;
    }
    
    public Config getConfig() {
        return Config;
    }
    
    public MainGUI getMainGUI() {
        return MainGUI;
    }
    
    public EventHandler getEventHandler() {
        return EventHandler;
    }
    
    public CommandHandler getCommandHandler() {
        return CommandHandler;
    }
    
    public Utils getUtils() {
        return Utils;
    }
    
    public rel.rogue.ircool.components.ChannelList getChanList() {
        return chanList;
    }

}
