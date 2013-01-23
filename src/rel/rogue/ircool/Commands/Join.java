package rel.rogue.ircool.Commands;

import rel.rogue.ircool.Utils;

/**
 *
 * @author Spencer
 */
public class Join extends rel.rogue.ircool.CommandExec {

    @Override
    public void onCommand(String[] args) {
       Utils.joinChan(args[0]);
    }

    @Override
    public String[] getTriggers() {
        return new String[] {
            "join"
        };
    }

    @Override
    public String getUsage() {
        return "USAGE: JOIN <channel>, joins a channel";
    }

}
