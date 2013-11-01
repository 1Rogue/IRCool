package rel.rogue.ircool.commands;

/**
 *
 * @author Spencer
 */
public class Kick extends rel.rogue.ircool.CommandExec {

    @Override
    public void onCommand(String[] args) {
        //TODO add checks for whether or not the user is in the supplied channel
        if (args.length > 1) {
            String send = "";
            for (int i=1; i<args.length-1; i++) {
                send = send + args[i] + " ";
            }
            send = send + args[args.length-1];
            user.kick(user.getChannel(rel.rogue.ircool.components.ChannelList.getActiveChannel()), user.getUser(args[0]), send);
        }
        else {
            user.kick(user.getChannel(rel.rogue.ircool.components.ChannelList.getActiveChannel()), user.getUser(args[0]));
        }
    }

    @Override
    public String[] getTriggers() {
        return new String[] {
            "kick",
            "boot",
        };
    }

    @Override
    public String getUsage() {
        return "KICK <user> [reason] - removes a user from the irc channel";
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
