//mvn exec:java

package downloader;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class YTD {

    public static void main(String[] args) {

        Set<String> link = new LinkedHashSet<>();

        String path = "F:\\Java\\Projects\\Maven\\# 0001 YoutubeDownloader\\downloads";
        String url = "https://www.youtube.com/watch?v=bjh1HWV9RRk&list=PL786bPIlqEjRFPH8Z9IOwJWseG6Dq_Qxb&index=1";

        HTMLParser htmp = new HTMLParser();
        YoutubeDownloader ytd = new YoutubeDownloader(path);

        try {
            link = htmp.getLinks(url);

            System.out.println("Download from:" + url);

            for(String s: link){
                if(s.contains("index=")) {
                    String downloadUrl = "https://www.youtube.com/" + s.substring(30, s.length() - 1);
                    ytd.getVideo(downloadUrl);
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
