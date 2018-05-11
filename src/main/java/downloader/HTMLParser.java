package downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

class HTMLParser{
    Document doc;           //HTMP
    String str;             //HTMP
    String url;
    Set<String> link = new LinkedHashSet<>();
    StrParser parser = new StrParser();

    public Set<String> getLinks(String urlForParse)
            throws Exception{
        url = urlForParse;
        //String url = "https://www.youtube.com/watch?v=jjr68pehq6A&index=52&list=PLC1og_v3eb4jJtActnUFBXYrTbr7oF6N"; //HTMP
        doc = Jsoup.connect(url).timeout(3000).get();       //HTMP
        Elements links = doc.getElementsByTag("script");    //HTMP
        for(Element el: links){
            link = parser.parse(el.toString(), "\"webCommandMetadata\":{\"url\":\"/watch?v=", ",");
        }
        return link;
    }
}

/*
*/
