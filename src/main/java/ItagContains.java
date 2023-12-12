import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItagContains {
    public boolean judgeItagContains(String htmlContent) {
        if (!htmlContent.equals("NotMatch")) {
            // itag値とダウンロードURLを抽出する正規表現
            Pattern pattern = Pattern.compile("\"url\":\"(https:[^\"]+)\".*?\"itag\":(\\d+)");
            Matcher matcher = pattern.matcher(htmlContent);
            if (matcher.find()) {
                System.out.println("> Supported.");
                return true;
            }
        }
        System.err.println("> This URL Doesn't Include an itag Value.");
        return false;
    }
}
