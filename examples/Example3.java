import java.util.ArrayList;
import java.util.List;

public class Variable3 {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();

        strings.add("test");

        String first = strings.get(0);

        strings.remove(0);

        System.out.println(strings);
    }

}