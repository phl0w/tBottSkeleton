package org.tbot.core;

import org.tbot.core.bot.config.Logger;
import org.tbot.core.bot.config.settings.BotInfo;
import org.tbot.core.bot.config.settings.UpdaterConfiguration;
import org.tbot.core.bot.loader.Updater;
import org.tbot.core.net.Downloader;
import org.tbot.core.net.NRCrawler;


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
 * This is supposed to be a skeleton for a bot.
 *
 * TODO:
 * - Work in progress.
 *
 *
 * @since 1.7
 * @author trDna
 */
public class Boot{


    public static void main(String[]args){
        Logger.setAppName("Boot");
        Logger.printlnInfo("Starting up...");

        if(!(args.length == 0)){

            if(args[0].equals("-nrforceload")){

                Logger.setAppName("nrforceload");
                Logger.printlnInfo("Forcing Near Reality load..");

                Logger.setAppName("Boot");

                NRCrawler nrCrawler = new NRCrawler();

                String clazzName = nrCrawler.getMainClassName();

                String jarURL = nrCrawler.getJarURL();

                Logger.setAppName("Downloader");
                Logger.printlnInfo("Downloading JAR....");

                Downloader.downloadFile(jarURL, BotInfo.JAR_PATH, false);
                Logger.printlnInfo("Download complete.");

                Updater u = new Updater(BotInfo.JAR_PATH, UpdaterConfiguration.ADAPT);
            }

        }

    }


}
