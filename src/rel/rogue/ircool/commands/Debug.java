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
package rel.rogue.ircool.commands;

import org.pircbotx.Channel;
import rel.rogue.ircool.IRCool;
import rel.rogue.ircool.Utils;

/**
 *
 * @since @author 1Rogue
 * @version
 */
public class Debug extends rel.rogue.ircool.CommandExec {

    @Override
    public void onCommand(String[] args) {
        Channel currentChan = IRCool.getUser().getChannel(rel.rogue.ircool.components.ChannelList.getActiveChannel());
        Utils.print(currentChan.getName(), "* Now talking in " + currentChan.getName());
        Utils.print(currentChan.getName(), "* Topic for " + currentChan.getName() + " is: \"" + currentChan.getTopic() + "\"");
        Utils.print(currentChan.getName(), "* Topic set by " + currentChan.getTopicSetter() + " on " + new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z").format(currentChan.getTopicTimestamp()));
    }

    @Override
    public String[] getTriggers() {
        return new String[]{
            "debug"
        };
    }

    @Override
    public String getUsage() {
        return "DEBUG prints currently needed debug info";
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
