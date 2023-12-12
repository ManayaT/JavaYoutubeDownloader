import java.util.Scanner;

public class InputURL {
    public String getInputURL() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n> VideoURL Example.\n \"https://www.youtube.com/watch?v=SrgASS4O8I8\"\n \"https://youtu.be/YP61xB66_Ic?si=XleALR3czQYnLpMj\"\nInputVideoURL >");
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
