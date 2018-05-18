import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;;

class Example5 {

    public static void main(String[] args) {
        String path = args[0];

        try {
            System.out.println(getContent(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getContent(String path) throws IOException {

        Path p = Paths.get(path);

        String content = new String(Files.readAllBytes(p), "UTF-8");

        return content;
    }
}