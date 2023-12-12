import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class AllByte {
    public long getAllByte (String inputUrl){
        try {
            // HTTP接続
            URL url = new URL(inputUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            // 総バイト量を取得
            long contentLength = connection.getContentLength();
            if (contentLength == -1) {
                System.err.println("> Couldn't Get Content Size.");
            }
            // 接続解除
            connection.disconnect();
            return contentLength;
        } catch (IOException e) {
            System.err.println("> Couldn't Get Content Size.");
            return -1;
        }
    }
}
