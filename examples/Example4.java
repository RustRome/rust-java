
public class Example4 {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(fibonacci(n));
    }

    public static long fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}