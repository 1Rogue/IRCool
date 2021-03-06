package rel.rogue.ircool;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Spencer
 */
public class IRCool {
    
    private static Config settings = new Config();
    private static org.pircbotx.PircBotX user;
    private static EventHandler eventHandler;
    public CommandHandler cmdHand;
    
    public static void main (String[] args) {
        new IRCool();
    }
    
    public IRCool() {
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
    
    public static org.pircbotx.PircBotX getUser() {
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
        cmdHand.setExecutor(new rel.rogue.ircool.commands.Kick());
        cmdHand.setExecutor(new rel.rogue.ircool.commands.Debug());
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
        this.attachListeners();
        this.enableCommands();
        rel.rogue.ircool.components.ChannelList.addChan(Utils.getChan("@@console"));
        Utils.joinDefaultChans(settings.getDefaultChans());
    }
    
    public boolean isBanned () {
        return true;
    }
    
    public static void disconnectServ() {
        user.setAutoReconnectChannels(true);
        user.disconnect();
    }
    
    public static void reconnectServ() {
        try {
            user.connect(settings.getNetwork());
        } catch (java.io.IOException | org.pircbotx.exception.IrcException ex) {
            Logger.getLogger(IRCool.class.getName()).log(Level.SEVERE, "General exception caught within IRCool.java (line 82)\n", ex);
        }
    }
    
    public static void shutdown(int w) {
        for (int i=0; i<MainGUI.getWindows().length; i++) {
            MainGUI.getWindows()[i].dispose();
        }
        System.exit(w);
    }
    
    public IRCool getInstance() {
        return this;
    }
}
