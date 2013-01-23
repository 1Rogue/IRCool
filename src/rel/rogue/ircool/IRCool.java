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
    
    public void attachListeners() {
        eventHandler = new EventHandler();
        boolean success = user.getListenerManager().addListener(eventHandler);
        if (success) {
            Utils.printCurrent("Event System registered");
        } else {
            Utils.printCurrent("Problem hooking event system");
        }
    }
    
    private void enableCommands() {
        this.cmdHand = new CommandHandler();
        this.cmdHand.setExecutor(new rel.rogue.ircool.Commands.Nick());
        this.cmdHand.setExecutor(new rel.rogue.ircool.Commands.Join());
    }
    
    public void setup () {
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
        MainGUI.addChan("@@console");
        Utils.joinDefaultChans(settings.getDefaultChans());
    }
}
