package rel.rogue.ircool.commands;


/**
 *
 * @author Spencer
 */
public class Join extends rel.rogue.ircool.CommandExec {

    @Override
    public void onCommand(String[] args) {
       Utils.joinChan(Utils.getChan(args[0]));
    }

    @Override
    public String[] getTriggers() {
        return new String[] {
            "join"
        };
    }

    @Override
    public String getUsage() {
        return "JOIN <channel>, joins a channel";
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
