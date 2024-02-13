import java.io.File;
import java.util.Scanner;

public class FileLocation {
    public File getFileLocation (){

        Scanner scanner = new Scanner(System.in);
        File inputPath;

        while (true){
            System.out.print("\n> File Location Example.\n  /Users/k22000kk/Downloads\nFile Location? >");
            inputPath = new File(scanner.nextLine());
            // 保存先パスが存在しない場合は再入力
            if (inputPath.exists()) {
                return inputPath;
            } else {
                System.err.println("> File Doesn't Exist.");
            }
        }
    }
}
