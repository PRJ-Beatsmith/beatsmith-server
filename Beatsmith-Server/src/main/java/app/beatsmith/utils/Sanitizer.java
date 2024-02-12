package app.beatsmith.utils;

import org.apache.commons.text.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class Sanitizer {
    public static String cleanIt(String arg0) {
        final String stage1 =  StringEscapeUtils.escapeHtml4(arg0);
        final String stage2 = StringEscapeUtils.escapeEcmaScript(stage1);
        return Jsoup.clean(stage2, Safelist.basic());
    }


}
