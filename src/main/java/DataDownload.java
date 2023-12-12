import java.io.*;
import java.net.URL;

public class DataDownload {
    public boolean getData(String downloadUrl, long allByte, String filePath, String extension) {
        try {
            URL getVideoUrl = new URL(downloadUrl); // これは必須かつtryで囲わないといけない

            InputStream in = getVideoUrl.openStream();
            BufferedInputStream data = new BufferedInputStream(in);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filePath + extension));

            byte[] buffer = new byte[1048576];
            int bytesRead;
            int barLength = 50;
            long totalBytes = 0;

            String format = "\r[%-" + barLength + "s] %3d%%.";

            // ダウンロード処理
            if (allByte != -1){
                // 書き込み
                while ((bytesRead = data.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                    totalBytes += bytesRead;
                    // プログレスバーの表示
                    System.out.printf(format, "=".repeat((int)(barLength * ((double)totalBytes / allByte))) + ">", (totalBytes * 100) / allByte);
                }
            } else {
                while ((bytesRead = data.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                    totalBytes += bytesRead;
                    System.out.printf("\r> Downloaded %.1f MB.", ((double)totalBytes/1000)/1000);
                }
            }

            // 解放
            in.close();
            data.close();
            out.close();

            return true;
        } catch (IOException e){
            System.err.println("\n> 書き込み中にエラーが発生しました.");
            return false;
        }
    }
}
