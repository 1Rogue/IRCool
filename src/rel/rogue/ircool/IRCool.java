package rel.rogue.ircool;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Spencer
 */
public class IRCool {
    
    private ClassLink CL = new ClassLink();
    private Config settings;
    private org.pircbotx.PircBotX user;
    private EventHandler eventHandler;
    private CommandHandler cmdHand;
    private Utils Utils;
    private rel.rogue.ircool.components.ChannelList chanList;
    
    public static void main (String[] args) {
        new IRCool();
    }
    
    public void link(Config cf, EventHandler eh, CommandHandler ch, Utils ut, rel.rogue.ircool.components.ChannelList cl) {
        settings = cf;
        eventHandler = eh;
        cmdHand = ch;
        Utils = ut;
        chanList = cl;
    }
    
    public IRCool() {
        if (StaticHold.getTest() == 0) {
            CL.connectClasses(this);
            Utils.printConsole("IRCool Constructor called");
            StaticHold.setTest(1);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainGUI window = new MainGUI();
                    window.setVisible(true);
                }
            });
            user = new org.pircbotx.PircBotX();
            this.setup();
            user.setVersion("Beta");
            user.setVerbose(false);
        }
    }
    
    public org.pircbotx.PircBotX getUser() {
        return user;
    }
    
    private void attachListeners() {
        eventHandler = new EventHandler();
        boolean success = user.getListenerManager().addListener(eventHandler);
        if (success) {
            Utils.printConsole("Event System registered");
        } else {
            Utils.printConsole("Problem hooking event system");
        }
    }
    
    private void enableCommands() {
        cmdHand = new CommandHandler();
        cmdHand.setExecutor(new rel.rogue.ircool.commands.Nick());
        cmdHand.setExecutor(new rel.rogue.ircool.commands.Join());
        cmdHand.setExecutor(new rel.rogue.ircool.commands.Part());
        cmdHand.setExecutor(new rel.rogue.ircool.commands.Me());
        cmdHand.setExecutor(new rel.rogue.ircool.commands.Reload());
        cmdHand.setExecutor(new rel.rogue.ircool.commands.Message());
    }
    
    private void setup () {
        //TODO: add a for-loop for reading input from settings box
        user.setName(settings.getDefaultNick());
        user.setLogin(settings.getUsername());
        try {
            user.connect(settings.getNetwork());
        } catch (java.io.IOException | org.pircbotx.exception.IrcException ex) {
            Logger.getLogger(IRCool.class.getName()).log(Level.SEVERE, "General exception caught within IRCool.java (line 53)\n", ex);
        }
        chanList.addChan(Utils.getChan("@@console"));
        this.attachListeners();
        this.enableCommands();
        Utils.joinDefaultChans(settings.getDefaultChans());
    }
    
    public boolean isBanned () {
        return true;
    }
    
    public void disconnectServ() {
        user.setAutoReconnectChannels(true);
        user.disconnect();
    }
    
    public void reconnectServ() {
        try {
            user.connect(settings.getNetwork());
        } catch (java.io.IOException | org.pircbotx.exception.IrcException ex) {
            Logger.getLogger(IRCool.class.getName()).log(Level.SEVERE, "General exception caught within IRCool.java (line 82)\n", ex);
        }
    }
}
