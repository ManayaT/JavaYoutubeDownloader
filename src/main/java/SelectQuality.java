import java.util.Scanner;

public class SelectQuality {
    public String getSelectedQuality() {

        Scanner scanner = new Scanner(System.in);
        String selectQuality;

        while (true){
            System.out.print("\n> Supported Quality.\n  360p\n  480p\n  720p\n  720p60\n  1080p\n  1080p60\nQuality? >");
            selectQuality = scanner.nextLine();

            if (selectQuality.equals("360p")) { // 360p
                return "360p";
            } else if (selectQuality.equals("480p")) { // 480p
                return "480p";
            }else if (selectQuality.equals("720p")) { // 720p
                return "720p";
            }else if (selectQuality.equals("720p60")) { // 720p60
                return "720p60";
            }else if (selectQuality.equals("1080p")) { // 1080p
                return "1080p";
            }else if (selectQuality.equals("1080p60")) { // 1080p60
                return "1080p60";
            }

            System.out.println("> Not Supported.");
        }
    }
}
