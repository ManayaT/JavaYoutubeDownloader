import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDelete {
    public void delete(String path) {
        try {
            Files.deleteIfExists(Paths.get(path));

        } catch (IOException e) {
            System.out.println("削除が正常に行われませんでした:" + e);
        }
    }
}
