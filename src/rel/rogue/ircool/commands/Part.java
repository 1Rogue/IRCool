package rel.rogue.ircool.commands;

/**
 *
 * @author Spencer
 */
public class Part extends rel.rogue.ircool.CommandExec {

    @Override
    public void onCommand(String[] args) {
        if (!args[0].equals("")) {
            if (args[0].startsWith("#") && user.getChannels().contains(Utils.getChan(args[0]))) {
                if (args.length > 1) {
                    String build = "";
                    for (int i=1; i<args.length; i++) {
                        build += args[i];
                    }
                    user.partChannel(Utils.getChan(args[0]), build);
                }
                else {
                    user.partChannel(Utils.getChan(args[0]));
                }
            }
            else {
                String build = "";
                for (int i=0; i<args.length; i++) {
                    build += args[i];
                }
                user.partChannel(Utils.getChan(chanList.getActiveChannel()), build);
            }
        }
        else {
            user.partChannel(Utils.getChan(chanList.getActiveChannel()));
        }
    }

    @Override
    public String[] getTriggers() {
        return new String[] {
            "part",
            "leave"
        };
    }

    @Override
    public String getUsage() {
        return "PART: leaves current channel, or leaves a channel provided.";
    }

    @Override
    public boolean takesArgs() {
        return true;
    }

    @Override
    public boolean requiresArgs() {
        return false;
    }
}
