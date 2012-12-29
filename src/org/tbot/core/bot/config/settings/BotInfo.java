package org.tbot.core.bot.config.settings;

/**
 * This file is part of tBot.
 *
 * tBot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * tBot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with tBot.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @since 1.7
 * @author trDna
 */
public interface BotInfo {


    /**
     * Folder path
     */
    public final String FOLDER_PATH = "C://tBot//";

    /**
     * The path to the JAR.
     */
    public final String JAR_PATH = FOLDER_PATH + "client.jar";


    /**
     * The base URL for Near-Reality
     */
    public final String NEAR_REALITY_URL_BASE = "http://www.nrclient.com/webclient/";
}
