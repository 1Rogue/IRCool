package rel.rogue.ircool;
/**
 *
 * @author Spencer
 */
public class EventHandler extends org.pircbotx.hooks.ListenerAdapter {
    
    org.pircbotx.PircBotX user = IRCool.getUser();
    
    
    /**
     * Used for parsing messages to client.
     * Also mostly just a fun little feature for testing the client from the 
     * other side. Will be updated upon finalizing project.
     * 
     * @param event 
     */
    @Override
    public void onMessage(org.pircbotx.hooks.events.MessageEvent event) {
        String message = event.getMessage();
        org.pircbotx.Channel channel = event.getChannel();
        String sender = event.getUser().getNick();
        Utils.print("<" + sender + "> " + message);
        if ((message.toLowerCase().contains("toss me a") || message.toLowerCase().contains("toss me an")) && message.toLowerCase().contains(user.getNick().toLowerCase())) {
            String[] f;
            if (!message.contains("toss me an")) {
                f = message.split("toss me a ");
            }
            else {
                f = message.split("toss me an ");
            }
            String object = f[1];
            user.sendAction(channel, "tosses " + sender + " " + Utils.vowel(object) + " " + object);
            Utils.printAction(user.getNick(), "tosses " + sender + " " + Utils.vowel(object) + " " + object);
        }
    }
    
    
    /**
     * Auto-join, which needs to be made configurable. Also prints kick
     * statements.
     * 
     * @param event 
     */
    @Override
    public void onKick(org.pircbotx.hooks.events.KickEvent event) {
        if (event.getRecipient().getNick().equals(user.getNick())) {
            Utils.print("You have been kicked from " + event.getChannel().getName() + ". (" + event.getReason() + ")");
            user.joinChannel(event.getChannel().getName());
        }
        else {
            Utils.print(event.getSource().getNick() + " has kicked " + event.getRecipient().getNick() + " from " + event.getChannel().getName() + ". (" + event.getReason() + ")");
        }
    }
    
    /**
     * 
     * Used for printing action statements.
     * 
     * @param event 
     */
    @Override
    public void onAction(org.pircbotx.hooks.events.ActionEvent event) {
        Utils.printAction(event.getUser().getNick(), event.getMessage());
    }
    
    /**
     * 
     * Used for printing nick changes.
     * 
     * @param event 
     */
    
    @Override
    public void onNickChange(org.pircbotx.hooks.events.NickChangeEvent event) {
        if (user.getNick().equals(event.getNewNick())) {
            Utils.print("You are now known as " + event.getNewNick());
        }
        else {
            Utils.print(event.getOldNick() + " is now known as " + event.getNewNick());
        }
    }
}
