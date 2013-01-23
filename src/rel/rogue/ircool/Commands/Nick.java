package rel.rogue.ircool.Commands;

import rel.rogue.ircool.CommandExec;

/**
 *
 * @author Spencer
 */
public class Nick extends CommandExec {

    @Override
    public void onCommand(String[] args) {
        System.out.println("Made it to onCommand in the Nick Class!");
        rel.rogue.ircool.IRCool.getUser().setName(args[0]);
    }

    @Override
    public String[] getTriggers() {
        return new String[] {
            "nick"
        };
    }

    @Override
    public String getUsage() {
        return "USAGE: NICK <new nick>, sets your nickname.";
    }
}
