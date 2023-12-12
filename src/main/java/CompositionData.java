import java.io.IOException;

public class CompositionData {
    public void Composition (String audioPath, String videoPath, String outputPath){
        // FFmpegコマンドの指定。
        String[] ffmpegCommand = {
                "ffmpeg",
                "-i", videoPath,
                "-i", audioPath,
                "-c:v", "copy",
                "-c:a", "aac",
                outputPath
        };

        try {
            // コマンドの実行
            Process process = Runtime.getRuntime().exec(ffmpegCommand);
            // コマンドの完了まで待機
            int exitCode = process.waitFor();
            // 実行結果の報告
            if (exitCode == 0) {
                System.out.println("  Success.");
            } else {
                System.err.println("  Composition Error.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.err.println("  Not Installed FFmpeg ?.");
        }
    }
}
