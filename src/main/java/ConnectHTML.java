import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class ConnectHTML {
    public String getHTML (String inputURL) {
        try {
            // Jsoupを使用してウェブページをダウンロード
            Document document = Jsoup.connect(inputURL).get();
            // HTML全体のテキストを返信
            return document.toString();
        } catch (IOException e) {
            System.err.println("> This URL Doesn't Include an itag Value.");
            return "NotMatch";
        }
    }
}
