/*
 * Copyright (C) 2013 Spencer Alderman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package rel.rogue.ircool.channels;

import java.util.Set;
import org.pircbotx.Channel;
import org.pircbotx.User;
import rel.rogue.ircool.MainGUI;
import rel.rogue.ircool.Utils;

/**
 *
 * @since
 * @author 1Rogue
 * @version
 */
public class IRChannel {
    
    protected Channel main;
    protected Set<Character> modes;
    protected String topic;
    protected String topicSetter;
    protected String topicTime;
    protected Set<User> users;
    protected Set<User> ops;
    protected Set<User> voiced;
    protected String buffer;
    protected String chanName;

    public IRChannel(Channel chan) {
        main = chan;
        chanName = chan.getName();
    }

    public Set<Character> getModes() {
        return modes;
    }
    
    public void addUser(User per) {
        if (per.getChannelsOpIn().contains(main)) {
            
        }
    }
    
    public void write(String message) {
        
    }
    
    public void write(String user, String message) {
        
    }

    public void debugOutput() {
        Utils.print(this.chanName, "* Now talking in " + this.chanName);
        Utils.print(this.chanName, "* Topic for " + this.chanName + " is: \"" + this.topic + "\"");
        Utils.print(this.chanName, "* Topic set by " + this.topicSetter + " on " + this.topicTime);
    }
}
/*
 * public static void printBackground (String channel, String message) {
        System.out.print(channel + ": " + message);
        rel.rogue.ircool.components.ChannelList.write(channel, message);
    }
    
    public static void printCurrent (String message) {
        System.out.print(rel.rogue.ircool.components.ChannelList.getActiveChannel() + ": " + message);
        MainGUI.getTextArea().append(message);
        MainGUI.getTextArea().setCaretPosition(MainGUI.getTextArea().getDocument().getLength());
    }
 */
