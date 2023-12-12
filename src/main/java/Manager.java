import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    // 入力URL保持変数
    private String inputUrl;
    public String getInputUrl() {
        return inputUrl;
    }
    public void setInputUrl(String inputUrl) {
        this.inputUrl = inputUrl;
    }

    // 音声データURLの保持変数
    private String audioURL;
    public String getAudioURL() {
        return audioURL;
    }
    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    // 映像データURLの保持変数
    private String videoURL;
    public String getVideoURL() {
        return videoURL;
    }
    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    // 動画データURLの保持変数
    private String movieURL;
    public String getMovieURL() {
        return movieURL;
    }
    public void setMovieURL(String movieURL) {
        this.movieURL = movieURL;
    }

    // HTML保持変数
    private String htmlContent;
    public String getHtmlContent() {
        return htmlContent;
    }
    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    // 音質itag保持リスト
    private ArrayList<String> itagAudioList = new ArrayList<>();
    public ArrayList<String> getItagAudioList() {
        return itagAudioList;
    }
    public void setItagAudioList(ArrayList<String> itagAudioList) {
        this.itagAudioList = itagAudioList;
    }

    // 画質itag保持リスト
    private ArrayList<String> itagVideoList = new ArrayList<>();
    public ArrayList<String> getItagVideoList() {
        return itagVideoList;
    }
    public void setItagVideoList(ArrayList<String> itagVideoList) {
        this.itagVideoList = itagVideoList;
    }

    // 動画itag保持リスト
    private ArrayList<String> itagMovieList = new ArrayList<>();
    public ArrayList<String> getItagMovieList() {
        return itagMovieList;
    }
    public void setItagMovieList(ArrayList<String> itagMovieList) {
        this.itagMovieList = itagMovieList;
    }

    // 入力画質保持変数
    private String inputQuality;
    public String getInputQuality() {
        return inputQuality;
    }
    public void setInputQuality(String inputQuality) {
        this.inputQuality = inputQuality;
    }

    // 拡張子保持変数
    private String extension;
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }

    // 入力された絶対パス保持用変数
    private File workingPath;
    public File getWorkingPath() {
        return workingPath;
    }
    public void setWorkingPath(File workingPath) {
        this.workingPath = workingPath;
    }

    // 保存ファイル名保持変数
    private String fileName;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // 現在時刻保持用変数
    private String currentTime;
    public String getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    // 総バイト数保持用変数
    private long contentSize;
    public long getContentSize() {
        return contentSize;
    }
    public void setContentSize(long contentSize) {
        this.contentSize = contentSize;
    }

    Manager(String initialPath){
        this.workingPath = new File(initialPath);
    }

    public static void main(String[] args) {
        Manager manager = new Manager("None");
        FileDelete del = new FileDelete();

        boolean end = false;

        while (!end){
            boolean progress = false;

            // URLの入力
            InputURL inputURL = new InputURL();
            ItagContains itagContains = new ItagContains();
            ConnectHTML connectHTML = new ConnectHTML();

            while (true){
                manager.setInputUrl(inputURL.getInputURL());
                // HTMLの取得
                manager.setHtmlContent(connectHTML.getHTML(manager.getInputUrl()));
                if (!manager.getHtmlContent().equals("NotMatch")){
                    if (itagContains.judgeItagContains(manager.getHtmlContent())){
                        break;
                    }
                }
            }

            // フォーマットとitagの取得
            InputExtension inputExtension = new InputExtension();
            manager.setExtension(inputExtension.getInputExtension());
            if (manager.getExtension().equals("mp3")) { //.mp3
                // 音質のitagのListを取得
                ItagAudioList itagAudioList = new ItagAudioList();
                manager.setItagAudioList(itagAudioList.getItagAudioList());
            } else if (manager.getExtension().equals("mp4")) { //.mp4
                // 音質のitagのListを取得
                ItagAudioList itagAudioList = new ItagAudioList();
                manager.setItagAudioList(itagAudioList.getItagAudioList());
                // 選択された画質のitagのListを取得
                SelectQuality selectQuality = new SelectQuality();
                ItagVideoList itagVideoList = new ItagVideoList();
                manager.setInputQuality(selectQuality.getSelectedQuality());
                manager.setItagVideoList(itagVideoList.getItagVideoList(manager.getInputQuality()));
            }

            // 保存先パスの取得
            if (manager.getWorkingPath().getPath().equals("None")){
                FileLocation fileLocation = new FileLocation();
                manager.setWorkingPath(fileLocation.getFileLocation());
            }

            // ファイル名の入力
            VideoTitle videoTitle = new VideoTitle();
            System.out.println("\n> Title : " + videoTitle.getFileName(manager.getHtmlContent()) + ".");
            NameSetting nameSetting = new NameSetting();
            manager.setFileName(nameSetting.fileNameSetting());

            // 音声データURLの取得
            AnalysisURL scanningURL = new AnalysisURL();
            manager.setAudioURL(scanningURL.getURL(manager.getHtmlContent(), manager.getItagAudioList()));
            if (manager.getAudioURL().equals("NotMatch")) {
                System.err.println("\n> Couldn't Get Audio URL.");
            }

            // 映像データURLの取得
            manager.setVideoURL(scanningURL.getURL(manager.getHtmlContent(), manager.getItagVideoList()));
            if (manager.getVideoURL().equals("NotMatch")) {
                System.err.println("\n> Couldn't Get Video URL.");
            }

            // フォーマットがmp4かつ画質が720p以下だった場合
            DataDownload download = new DataDownload();
            AllByte allByte = new AllByte();
            if (manager.getExtension().equals("mp4") && manager.getVideoURL().equals("NotMatch")) {
                if (manager.getInputQuality().equals("360p") || manager.getInputQuality().equals("480p") || manager.getInputQuality().equals("720p")) {
                    // 動画itagの取得
                    ItagMovieList itagMovieList = new ItagMovieList();
                    manager.setItagMovieList(itagMovieList.getItagMovieList(manager.getInputQuality()));
                    // 動画データURLの取得
                    manager.setMovieURL(scanningURL.getURL(manager.getHtmlContent(), manager.getItagMovieList()));
                    if (manager.getMovieURL().equals("NotMatch")) {
                        System.err.println("\n> Couldn't Get Movie URL.");
                        progress = true;
                    } else {
                        System.out.println("\n> Found Movie URL.");
                    }
                    if (!progress){
                        // コンテンツサイズの取得
                        manager.setContentSize(allByte.getAllByte(manager.getMovieURL()));
                        // 動画データのダウンロード
                        System.out.println("\n> Movie URL \"" + manager.getMovieURL() + "\".");
                        System.out.println("\n> Downloading Movie Data...");
                        if (download.getData(manager.getMovieURL(), manager.getContentSize(), manager.getWorkingPath() + manager.getFileName(), ".mp4")){
                            System.out.println("\n  Success.");
                        } else {
                            System.out.println("\n  Failure.");
                            del.delete(manager.getWorkingPath() + "/" + manager.getFileName() + ".mp4");
                        }
                        progress = true;
                    }
                }
            }

            if (!progress){
                // 音声データのダウンロード
                System.out.println("\n> Audio URL \"" + manager.getAudioURL() + "\".");
                System.out.println("\n> Downloading Audio Data...");
                // 時間の取得
                Time date = new Time();
                manager.setCurrentTime(date.getTime());
                // コンテンツサイズの取得
                manager.setContentSize(allByte.getAllByte(manager.getAudioURL()));
                // 指定が音声ファイルのみだった場合
                if (manager.getExtension().equals("mp3")) {
                    if (download.getData(manager.getAudioURL(), manager.getContentSize(), manager.getWorkingPath() + "/" + manager.getFileName(), ".mp3")){
                        System.out.println("\n  Success.");
                        System.out.println("\n> Download Completed.");
                    } else {
                        System.out.println("\n  Failure.");
                        del.delete(manager.getWorkingPath() + "/" + manager.getFileName() + ".mp3");
                    }
                    progress = true;
                } else {
                    if (download.getData(manager.getAudioURL(), manager.getContentSize(), manager.getWorkingPath() + "/audio" + manager.getCurrentTime(), ".mp3")){
                        System.out.println("\n  Success.");
                    } else {
                        System.out.println("\n  Failure.");
                        del.delete(manager.getWorkingPath() + "/audio" + manager.getCurrentTime() + ".mp3");
                        progress = true;
                    }
                }
            }

            if (!progress){
                // コンテンツサイズの取得
                manager.setContentSize(allByte.getAllByte(manager.getVideoURL()));
                // 映像データのダウンロード
                System.out.println("\n> Video URL \"" + manager.getVideoURL() + "\".");
                System.out.println("\n> Downloading Video Data...");
                if (download.getData(manager.getVideoURL(), manager.getContentSize(), manager.getWorkingPath() + "/video" + manager.getCurrentTime(), ".mp4")){
                    System.out.println("\n  Success.");
                } else {
                    System.out.println("\n  Failure.");
                    del.delete(manager.getWorkingPath() + "/audio" + manager.getCurrentTime() + ".mp3");
                    del.delete(manager.getWorkingPath() + "/video" + manager.getCurrentTime() + ".mp4");
                    progress = true;
                }
            }

            if (!progress){
                // 保存ファイルの重複回避
                del.delete(manager.getWorkingPath() + "/" + manager.getFileName() + ".mp4");

                // 音声データと映像データの合成
                System.out.println("\n> Compositing Data...");
                CompositionData compositionData = new CompositionData();
                compositionData.Composition(manager.getWorkingPath() + "/audio" + manager.getCurrentTime() + ".mp3",
                        manager.getWorkingPath() + "/video" + manager.getCurrentTime() + ".mp4",
                        manager.getWorkingPath() + "/" + manager.getFileName() + ".mp4");

                // 音声データと映像データの削除
                System.out.println("\n> Delete Waste Data...");
                del.delete(manager.getWorkingPath() + "/audio" + manager.getCurrentTime() + ".mp3");
                del.delete(manager.getWorkingPath() + "/video" + manager.getCurrentTime() + ".mp4");
                System.out.println("  Success.");

                // ダウンロード完了
                System.out.println("\n> Download Completed.");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nContinue (Y/N)>");
            if (!scanner.nextLine().equalsIgnoreCase("y")){
                end = true;
            }
        }
    }
}
