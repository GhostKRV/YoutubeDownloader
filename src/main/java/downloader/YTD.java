//mvn exec:java

package downloader;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class YTD {

    public static void main(String[] args) {
        try {
            Set<String> link = new LinkedHashSet<>();
            BufferedReader inputURL = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter playlist URL: ");
            String url = inputURL.readLine();
            //String url = "https://www.youtube.com/watch?v=bjh1HWV9RRk&list=PL786bPIlqEjRFPH8Z9IOwJWseG6Dq_Qxb&index=1";
            String path = "F:\\Java\\Projects\\Maven\\# 0001 YoutubeDownloader\\downloads";
            HTMLParser htmp = new HTMLParser();
            YoutubeDownloader ytd = new YoutubeDownloader(path);
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
