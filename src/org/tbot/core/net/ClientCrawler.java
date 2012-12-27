package org.tbot.core.net;

import java.io.IOException;

/**
 * @author trDna
 */

public class ClientCrawler {

    private String urlToClient;

    public ClientCrawler(){
        try {
            System.out.println("Downloading...");
            Downloader.downloadFile("http://www.nrclient.com/webclient/client.jar", "C://Test//client.jar", false);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
