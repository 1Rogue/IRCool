package rel.rogue.ircool.commands;


/**
 *
 * @author Spencer
 */
public class Me extends rel.rogue.ircool.CommandExec {

    @Override
    public void onCommand(String[] args) {
        String send = "";
        for (int i=0; i<args.length-1; i++) {
            send = send + args[i] + " ";
        }
        send = send + args[args.length-1];
        user.sendAction(rel.rogue.ircool.MainGUI.getActiveChannel(), send);
        rel.rogue.ircool.Utils.printAction("§current", user.getNick(), send);
    }

    @Override
    public String[] getTriggers() {
        return new String[] {
            "me",
            "emote",
            "e"
        };
    }

    @Override
    public String getUsage() {
        return "ME <action>, sends the action to the current channel (actions are written in the 3rd person, like /me jumps)";
    }

    @Override
    public boolean takesArgs() {
        return true;
    }

    @Override
    public boolean requiresArgs() {
        return true;
    }

}
