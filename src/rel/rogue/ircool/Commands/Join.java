package rel.rogue.ircool.Commands;


/**
 *
 * @author Spencer
 */
public class Join extends rel.rogue.ircool.CommandExec {

    @Override
    public void onCommand(String[] args) {
       rel.rogue.ircool.Utils.joinChan(rel.rogue.ircool.Utils.getChan(args[0]));
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
