package rel.rogue.ircool.Commands;

import rel.rogue.ircool.MainGUI;
import rel.rogue.ircool.Utils;

/**
 *
 * @author Spencer
 */
public class Message extends rel.rogue.ircool.CommandExec {

    @Override
    public void onCommand(String[] args) {
        String send = "";
        for (int i=1; i<args.length; i++) {
            send += args[i] + " ";
        }
        user.sendMessage(user.getUser(args[0]), send);
        Utils.printPrivMsg(args[0], send, true);
    }

    @Override
    public String[] getTriggers() {
        return new String[] {
            "message",
            "msg",
            "tell",
            "t"
        };
    }

    @Override
    public String getUsage() {
        return "MESSAGE <user> [message] - Sends a user a message in private";
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
