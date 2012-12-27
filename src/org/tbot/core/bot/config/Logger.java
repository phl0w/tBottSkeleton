package org.tbot.core.bot.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

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
public class Logger {

    private static java.util.logging.Logger l = java.util.logging.Logger.getLogger(Logger.class.getSimpleName());

    private static String appName = "AppName";
    private static String consoleName = "Console";

    private static boolean printTrigger = false;

    public static void log(Object msg){
         l.log(Level.INFO, String.valueOf(msg));
    }

    /**
     * For internal use
     * @param text
     */
    public static void printlnAsConsole(String text){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat day = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        System.out.println(">>>" +"[" + consoleName + "]" +  "["+ day.format(date) + "]" + "[" + dateFormat.format(date) + "] "+ text);
    }

    /**
     * Provides a simple printing function. It knows when not to add the
     * details when the print line trigger is true.
     * @param text
     */
    public static void printlnInfo(Object text){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat day = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        if(!printTrigger){
            System.out.println("[" + appName + "]" + "["+ day.format(date) + "]" + "[" + dateFormat.format(date) + "] " + text);
        }else{
            System.out.println(text);
            printTrigger = false;
        }
    }

    /**
     * Provides a simple printing function. The next line after this will be printed on the same line.
     * @param text
     */
    public static void printInfo(Object text){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat day = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        if(!printTrigger){
            System.out.print("[" + appName + "]" + "["+ day.format(date) + "]" + "[" + dateFormat.format(date) + "] " + text);
        } else {
            System.out.print(text);
        }

        printTrigger = true;
    }

    public static void setAppName(String a){
        appName = a;
    }
}
