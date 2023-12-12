import java.util.Scanner;

public class InputExtension {
    public String getInputExtension() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("\n> Supported Extension.\n  mp3\n  mp4\nExtension? >");
            String inputExtension = scanner.nextLine();
            if (inputExtension.equals("mp3")) { //.mp3
                return "mp3";
            } else if (inputExtension.equals("mp4")) { //.mp4
                return "mp4";
            } else {
                System.err.println("> Not Supported.");
            }
        }
    }
}
