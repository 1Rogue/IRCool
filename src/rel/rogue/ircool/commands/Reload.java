package rel.rogue.ircool.commands;

/**
 *
 * @author Spencer
 */
public class Reload extends rel.rogue.ircool.CommandExec {

    @Override
    public void onCommand(String[] args) {
        rel.rogue.ircool.MainGUI.updateChannelList();
    }

    @Override
    public String[] getTriggers() {
        return new String[] {
            "reload"
        };
    }

    @Override
    public String getUsage() {
        return "RELOAD: Reloads the Channel List and User List";
    }

    @Override
    public boolean takesArgs() {
        return false;
    }

    @Override
    public boolean requiresArgs() {
        return false;
    }

}
