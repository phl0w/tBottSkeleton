package org.tbot.core.net;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * This is a simple web crawler which uses regular expressions to find information.
 *
 * @since 1.7
 * @author trDna
 */
public class Crawler {

    public StringBuffer sb = new StringBuffer("");

    public Crawler(final String URL){

        final BufferedReader URL_BUFFERED_READER;

        try{

            {
                final URL URL_LINK = new URL(URL);
                URL_BUFFERED_READER = new BufferedReader(new InputStreamReader(URL_LINK.openStream()));
            }
            String tmp = "";

            while((tmp = URL_BUFFERED_READER.readLine()) != null){
                sb.append(tmp);
                sb.append("\n");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public String getContents(){
        return sb.toString();
    }

    public StringBuffer getContentBuffer(){
        return sb;
    }

    public String find(final String REGEX, final int GROUP_INDEX){

        final Pattern REGEX_PATTERN = Pattern.compile(REGEX);
        String s;

        BufferedReader br = new BufferedReader(new StringReader(sb.toString()));

        try {
            while((s = br.readLine()) != null){
                Matcher m = REGEX_PATTERN.matcher(s);

                if(m.find()){
                    return m.group(GROUP_INDEX);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Crawler getCurrentInstance(){
        return this;
    }
}


