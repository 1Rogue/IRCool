package rel.rogue.ircool;

/**
 *
 * @author Spencer
 */
public class EventHandler extends org.pircbotx.hooks.ListenerAdapter {
    
    org.pircbotx.PircBotX user = IRCool.getUser();
    rel.rogue.ircool.Config settings = new rel.rogue.ircool.Config();
    
    /**
     * Grabs private messages for printing
     * 
     * @param event
     */
    @Override
    public void onPrivateMessage(org.pircbotx.hooks.events.PrivateMessageEvent event) {
        Utils.printPrivMsg(event.getUser().getNick(), event.getMessage(), false);
    }
    /**
     * Used for passing messages to client.
     * 
     * @param event 
     */
    @Override
    public void onMessage(org.pircbotx.hooks.events.MessageEvent event) {
        Utils.printMsg(event.getChannel().getName(), event.getUser().getNick(), event.getMessage());
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
            MainGUI.setUsers();
            //MainGUI.clearUsers(event.getChannel());
            //
            /*if (settings.enableAutoJoin() && user.) {
                user.joinChannel(event.getChannel().getName());
            }*/
        }
        else {
            Utils.print(event.getChannel().getName(), event.getSource().getNick() + " has kicked " + event.getRecipient().getNick() + " from " + event.getChannel().getName() + ". (" + event.getReason() + ")");
            MainGUI.setUsers();
            //MainGUI.removeUser(event.getChannel(), event.getRecipient().getNick());
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
    
    @Override
    public void onJoin(org.pircbotx.hooks.events.JoinEvent event) {
        if (event.getUser().getNick().equals(user.getNick())) {
            MainGUI.setUsers();
            rel.rogue.ircool.components.ChannelList.getChannelList().setSelectedValue(event.getChannel().getName(), true);
            rel.rogue.ircool.components.ChannelList.setNewChan(event.getChannel().getName());
            while (event.getChannel().getTopic().equals("")) {
                if (!event.getChannel().getTopic().equals("")) {
                    Utils.print(event.getChannel().getName(), "* Now talking in " + event.getChannel().getName());
                    Utils.print(event.getChannel().getName(), "* Topic for " + event.getChannel().getName() + " is: \"" + event.getChannel().getTopic() + "\"");
                    Utils.print(event.getChannel().getName(), "* Topic set by " + event.getChannel().getTopicSetter() + " on " + new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z").format(event.getChannel().getTopicTimestamp()));
                }
            }
            rel.rogue.ircool.components.ChannelList.updateChannelList();
        }
        else {
            Utils.print(event.getChannel().getName(), "* " + event.getUser().getNick() + " (" + Utils.getFullUser(event.getUser()) + ") has joined " + event.getChannel().getName());
        }
        //MainGUI.addUser(event.getChannel(), event.getUser().getNick());
    }
    
    @Override
    public void onPart(org.pircbotx.hooks.events.PartEvent event) {
        if (!event.getUser().getNick().equals(user.getNick())) {
            MainGUI.setUsers();
        }
        else {
            MainGUI.clearUsers(event.getChannel());
        }
        //MainGUI.removeUser(event.getChannel(), event.getUser().getNick());
    }
}
