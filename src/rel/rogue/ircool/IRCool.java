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
        attachListeners();
        user.setVersion("Beta");
        user.setVerbose(false);
        settings.setup();
        runDefault();
    }
    
    public final void runDefault() {
        user.setName(settings.getDefaultNick());
        user.setLogin(settings.getUsername());
        try {
            user.connect(settings.getNetwork());
        } catch (java.io.IOException | org.pircbotx.exception.IrcException ex) {
            Logger.getLogger(IRCool.class.getName()).log(Level.SEVERE, "General exception caught within IRCool.java (line 39)\n", ex);
        }
        String[] channels = settings.getDefaultChannels();
        for (int i=0;i<channels.length; i++) {
            user.joinChannel(channels[i]);
        }
    }
    
    public static org.pircbotx.PircBotX getUser() {
        return user;
    }
    
    public final void attachListeners() {
        eventHandler = new EventHandler();
        boolean success = user.getListenerManager().addListener(eventHandler);
        if (success) {
            Utils.print("Event System registered");
        } else {
            Utils.print("Problem hooking event system");
        }
    }
}
