package rel.rogue.ircool;

/**
 *
 * @author Spencer
 */
public abstract class CommandExec {
    
    public abstract void onCommand (String[] args);
    
    public abstract String[] getTriggers();
    
    public abstract String getUsage();
}