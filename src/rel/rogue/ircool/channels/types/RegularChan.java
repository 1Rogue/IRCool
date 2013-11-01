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
package rel.rogue.ircool.channels.types;

import org.pircbotx.Channel;
import org.pircbotx.User;
import rel.rogue.ircool.channels.IRChannel;

/**
 *
 * @since @author 1Rogue
 * @version
 */
public class RegularChan extends IRChannel {

    public RegularChan(Channel chan) {
        super(chan);
        for (char mode : chan.getMode().substring(1).toCharArray()) {
            modes.add(mode);
        }
        topic = chan.getTopic();
        topicSetter = chan.getTopicSetter();
        topicTime = new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z").format(chan.getTopicTimestamp());
        users = chan.getUsers();
        for (User per : users) {
            setTag(per, chan);
        }
    }

    private void setTag(User per, Channel chan) {
        if (per.getChannelsOpIn().contains(chan)) {
            ops.add(per);
            return;
        }
        if (per.getChannelsVoiceIn().contains(chan)) {
            voiced.add(per);
        }
    }
}
