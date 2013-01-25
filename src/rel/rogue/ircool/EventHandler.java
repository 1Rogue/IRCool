package rel.rogue.ircool;

/**
 *
 * @author Spencer
 */
public class EventHandler extends org.pircbotx.hooks.ListenerAdapter {
    
    org.pircbotx.PircBotX user = IRCool.getUser();
    rel.rogue.ircool.Config settings = new rel.rogue.ircool.Config();
    
    
    /**
     * Used for passing messages to client.
     * 
     * @param event 
     */
    @Override
    public void onMessage(org.pircbotx.hooks.events.MessageEvent event) {
        Utils.printMsg(event.getChannel().getName(), event.getUser().getNick(), event.getMessage());
        String users = event.getChannel().getUsers().toString();
        String print = "{";
        /*for (int i=0; i<(users.length - 1); i++) {'
            org.pircbotx.User temp = users[i];
            print = print + users[i] + ", ";
        }
        print = print + users[users.length-1] + "}";*/
        System.out.println("People in chan: " + users);
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
            Utils.print(event.getChannel().getName(), "You have been kicked from " + event.getChannel().getName() + ". (" + event.getReason() + ")");
            //
            /*if (settings.enableAutoJoin() && user.) {
                user.joinChannel(event.getChannel().getName());
            }*/
        }
        else {
            Utils.print(event.getChannel().getName(), event.getSource().getNick() + " has kicked " + event.getRecipient().getNick() + " from " + event.getChannel().getName() + ". (" + event.getReason() + ")");
        }
    }
    
    /**
     * 
     * Grabs event for someone performing /me or an Action, and sends for printing.
     * 
     * @param event 
     */
    @Override
    public void onAction(org.pircbotx.hooks.events.ActionEvent event) {
        Utils.printAction(event.getChannel().getName(), event.getUser().getNick(), event.getMessage());
    }
    
    /**
     * 
     * Grabs event for someone changing nicks, and sends to be printed out.
     * 
     * @param event 
     */
    
    @Override
    public void onNickChange(org.pircbotx.hooks.events.NickChangeEvent event) {
        if (user.getNick().equals(event.getNewNick())) {
            Utils.printToSet(user.getChannels(), "You are now known as " + event.getNewNick(), "name");
        }
        else {
            Utils.printToSet(event.getUser().getChannels(), event.getOldNick() + " is now known as " + event.getNewNick(), "name");
        }
    }
}
