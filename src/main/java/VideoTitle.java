import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoTitle {
    public String getFileName (String htmlContent){
        // 正規表現を使用して動画タイトルを抽出
        Pattern pattern = Pattern.compile("<title>(.*?) - YouTube</title>");
        Matcher matcher = pattern.matcher(htmlContent);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "NoTitle";
        }
    }
}
