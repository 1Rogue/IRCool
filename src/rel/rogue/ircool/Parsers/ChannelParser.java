package rel.rogue.ircool.Parsers;

/**
 *
 * @author Spencer
 */
public class ChannelParser {
    
    java.util.ArrayList<String> temp = new java.util.ArrayList<>();
    
    public static String[] getChannelNames(java.util.Set<org.pircbotx.Channel> set) {
        Object[] chanlist = set.toArray();
        String[] chans = new String[chanlist.length];
        for (int i=0; i<chanlist.length; i++) {
            chans[i] = getChannelName(chanlist[i]);
        }
        return chans;
    }
    
    public static String[] getChannelNames(java.util.HashMap<String, String> set) {
        Object[] chanlist = set.keySet().toArray();
        String[] chans = new String[chanlist.length];
        for (int i=0; i<chanlist.length; i++) {
            chans[i] = getChannelName(chanlist[i]);
        }
        return chans;
    }
    
    private static String getChannelName(Object channel) {
        String chan = channel.toString();
        chan = chan.split(", ")[0];
        chan = chan.substring(13);
        return chan;
    }
    
    public static String[] getChannelUsers(java.util.Set<org.pircbotx.User> set) {
        Object[] people = set.toArray();
        String[] newlist = new String[people.length];
        for (int i=0; i<people.length; i++) {
            newlist[i] = getUserName(people[i].toString());
        }
        return newlist;
    }
    
    public static String getUserName(Object username) {
        String name = username.toString();
        name = name.split(", ")[0];
        name = name.substring(10);
        return name;
        
    }
    
}
