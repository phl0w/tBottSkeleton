package org.tbot.core.net;

import org.tbot.core.bot.config.settings.BotInfo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

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
public class Downloader {

    /**
     * @param url - The url to the file.
     * @param outputFileDir - Output file directory.
     * @param forceDownload - Forces a download.
     */
    public static void downloadFile(String url, String outputFileDir,
                                    boolean forceDownload){

        try{
            if (forceDownload) {
                StringBuffer sb = new StringBuffer(url);
                sb.append("?dl=1");
                url = sb.toString();
            }

            File f = new File(BotInfo.FOLDER_PATH);
            f.mkdirs();

            BufferedInputStream in = new BufferedInputStream(
                    new URL(url).openStream());
            FileOutputStream fos = new FileOutputStream(outputFileDir);

            BufferedOutputStream bout = new BufferedOutputStream(fos, 100);
            byte[] data = new byte[100];
            int x = 0;
            while ((x = in.read(data, 0, 100)) >= 0) {
                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
