package org.tbot.core.bot.config.settings;

/**
 * This file is part of tBot.
 *
 * tBot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * tBot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with tBot.  If not, see <http://www.gnu.org/licenses/>.
 *
 * This is a set of configuration flags.
 *
 * @author trDna
 * @since 1.7
 */
public interface UpdaterConfiguration {

    /**
     * Continues even if a critical error is found.
     */
    public final int SAFE_MODE = 1;

    /**
     * Loads the manifest files from a JAR as well as the class files (NOT RECOMMENDED).
     */
    public final int LOAD_META = 2;

    /**
     * Searches for a JAR in a given directory and runs off of it.
     */
    public final int FORCE_CACHE_LOAD = 4;

    /**
     * Adapts to any given RSPS jar, and uses recommended settings.
     */
    public final int ADAPT = 8;

}
