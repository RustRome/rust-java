import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

class Example6 {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Luke");
        names.add("Finn");

        new Thread(() -> {
            for (String name : names) {
                System.out.println(name);
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            names.add("Mark" + i);
        }

    }

}