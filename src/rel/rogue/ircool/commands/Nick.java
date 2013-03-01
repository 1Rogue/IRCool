package rel.rogue.ircool.commands;

import rel.rogue.ircool.CommandExec;

/**
 *
 * @author Spencer
 */
public class Nick extends CommandExec {

    @Override
    public void onCommand(String[] args) {
        user.changeNick(args[0]);
    }

    @Override
    public String[] getTriggers() {
        return new String[] {
            "nick",
            "name"
        };
    }

    @Override
    public String getUsage() {
        return "NICK <new nick>, sets your nickname.";
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
