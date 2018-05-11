package downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

class HTMLParser{
    Document doc;
    String str;
    String url;
    Set<String> link = new LinkedHashSet<>();
    StrParser parser = new StrParser();

    public Set<String> getLinks(String urlForParse)
            throws Exception{
        url = urlForParse;

        doc = Jsoup.connect(url).timeout(3000).get();
        Elements links = doc.getElementsByTag("script");
        for(Element el: links){
            link = parser.parse(el.toString(), "\"webCommandMetadata\":{\"url\":\"/watch?v=", ",");
        }
        return link;
    }
}
