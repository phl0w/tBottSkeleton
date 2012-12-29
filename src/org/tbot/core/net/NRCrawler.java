package org.tbot.core.net;

import org.tbot.core.bot.config.settings.BotInfo;
import org.tbot.core.bot.config.*;

/**
 * This file is part of tBot.
 * <p/>
 * tBot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * tBot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with tBot.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @author trDna
 * @since 1.7
 */
public class NRCrawler extends Crawler {

    public NRCrawler() {
        super(BotInfo.NEAR_REALITY_URL_BASE);
        Logger.setAppName("NRCrawler");
    }

    /**
     * Automate the main class name so that the bot doesn't need to update that.       *
     * @return The main class name of the JAR.
     */
    public String getMainClassName(){

        //Find the class name.
        String s =  find("<applet style='vertical-align:top' code=\"(.+?)\" name = \"Near-Reality Web-Client\" archive=\"client.jar, Theme.jar, mail.jar, activation.jar\" width=\"765px\" height=\"503px\">", 1);

        //Print out the class name
        Logger.printlnInfo("Main class = " + s);

        return s;
    }

    /**
     * Figure out the JAR direct link for download.
     * @return The JAR's direct link.
     */
    public String getJarURL(){

        //Create a new StringBuilder
        StringBuilder sb = new StringBuilder();

        //Append the website base
        sb.append(BotInfo.NEAR_REALITY_URL_BASE);

        //Find the JAR name
        String s = find("<applet style='vertical-align:top' code=\"client.class\" name = \"Near-Reality Web-Client\" archive=\"(.+?), Theme.jar, mail.jar, activation.jar\" width=\"765px\" height=\"503px\">", 1);

        //Append that name to the StringBuilder
        sb.append(s);

        //Print out the URL
        Logger.printlnInfo("Suspected URL = " + sb.toString());

        //Return the String, which is the direct link to the JAR.
        return sb.toString();
    }

}
