package downloader;

import java.util.*;

class StrParser{
    private int beginIndex = 0;
    private int endIndex = 0;
    private Set<String> links = new LinkedHashSet<>();

    Set<String> parse(String str, String begin, String end){
        beginIndex = str.indexOf(begin, beginIndex);
        endIndex = str.indexOf(end, beginIndex);
        if(beginIndex == -1 || endIndex == -1 ) return links;
        //System.out.println(str.substring(beginIndex, endIndex));
        links.add(str.substring(beginIndex, endIndex));

        beginIndex++;
        endIndex++;

        return this.parse(str, begin, end);
    }

    @Override
    public int hashCode() {
        int result = beginIndex;
        result = 31 * result + endIndex;
        result = 31 * result + (links != null ? links.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StrParser parser = (StrParser) o;

        if (beginIndex != parser.beginIndex) return false;
        if (endIndex != parser.endIndex) return false;
        return links != null ? links.equals(parser.links) : parser.links == null;
    }
}
