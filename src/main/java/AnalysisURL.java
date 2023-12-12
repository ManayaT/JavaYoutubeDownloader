import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalysisURL {
    public String getURL(String htmlContent, ArrayList<String> itagList) {
        // itag値とダウンロードURLを抽出する正規表現
        Pattern pattern = Pattern.compile("\"url\":\"(https:[^\"]+)\".*?\"itag\":(\\d+)");
        Matcher matcher = pattern.matcher(htmlContent);

        while (matcher.find()) {
            String url = matcher.group(1);
            // itagの値を走査
            for (String element : itagList) {
                if (url.contains("itag=" + element)) {
                    // URL内の \u0026 を & に置換 -> 指定した itag の値が一致したのでループを終了
                    return url.replace("\\u0026", "&");
                }
            }
        }
        return "NotMatch";
    }
}
