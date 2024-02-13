import java.util.Scanner;

public class InputURL {
    public String getInputURL() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n> VideoURL Example.\nInputVideoURL >");
            String inputURL = scanner.nextLine();
            // 対応していないURLの場合は再入力
            if (inputURL.contains("https://www.youtube.com/watch?v=") || inputURL.contains("https://youtu.be/")) {
                return inputURL;
            } else {
                System.err.println("> Not Supported.");
            }
        }
    }
}
