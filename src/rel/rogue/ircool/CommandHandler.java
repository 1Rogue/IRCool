package rel.rogue.ircool;

/**
 *
 * @author Spencer
 */
public class CommandHandler {
    
    java.util.List<CommandExec> commandList = new java.util.ArrayList();

    public void setExecutor(CommandExec cmdExec) {
        this.commandList.remove(cmdExec);
        this.commandList.add(cmdExec);
        System.out.println("Added " + cmdExec.toString() + " to command list!");
    }
    
    public void parseCommand(String command) {
        System.out.println("Made it to parseCommand!");
        command = command.substring(1);
        String[] temp = command.split(" ");
        String comm = temp[0].replace("/", " ");
        String s = "";
        for (int i=1; i<temp.length; i++) {
            s = s + temp[i] + " ";
        }
        temp = s.split(" ");
        sendCommand(comm, temp);
    }
    
    public void sendCommand(String command, String[] args) {
         System.out.println("Made it to sendCommand!");
         CommandExec exec = getExecutor(command);
         
         if (exec == null) {
             System.out.println("Returned null :(");
             
             return;
         }
         
         exec.onCommand(args);
         
    }
    
    public CommandExec getExecutor(String command) {
        command = command.trim();
        for (CommandExec exec : this.commandList) {
            for (String trigs : exec.getTriggers()) {
                trigs = trigs.trim();
                if (trigs.equalsIgnoreCase(command)) {
                    return exec;
                }
            }
        }
        return null;
    }
}
 