package downloader;

import java.io.File;
import java.net.URL;
import com.github.axet.vget.VGet;

import java.util.*;

class YoutubeDownloader {

    String path;

    YoutubeDownloader(String pathToDownload){
        path = pathToDownload;
    }

    String downloadUrl = null;
    Set<String> link = new LinkedHashSet<>();

    public void getVideo(String downloadFromURL)
        throws Exception{
        //downloadFromURL = s;

        //downloadUrl = "https://www.youtube.com/" + s.substring(30, s.length() - 1);
        downloadUrl = downloadFromURL;
        System.out.println(downloadUrl + "............[OK]");

        VGet v = new VGet(new URL(downloadUrl), new File(path));
        v.download();
        System.out.println("Download from: " + downloadUrl + " complete");
        System.out.println();
    }
}
