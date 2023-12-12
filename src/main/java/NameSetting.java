import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NameSetting {

    private final ArrayList<String> forbiddenList = new ArrayList<>(Arrays.asList("\\", "$", "/", ":", "*", "?", "\"", "<", ">", "|"));

    public String fileNameSetting (){

        Scanner scanner = new Scanner(System.in);
        String fileName;

        while (true) {
            // 禁則文字の表示
            System.out.print("\n> Forbidden Characters.\n  \\\n  $\n  /\n  :\n  *\n  ?\n  \"\n  <\n  >\n  |\nFile Name? >");
            fileName = scanner.nextLine();
            // 禁則文字の検査
            boolean containsForbiddenCharacter = false;
            for (String element : forbiddenList) {
                if (fileName.contains(element)) {
                    containsForbiddenCharacter = true;
                    System.out.println("Forbidden Characters " + element + ".");
                    break;
                }
            }

            if (!containsForbiddenCharacter) {
                return fileName;
            }
        }
    }
}
