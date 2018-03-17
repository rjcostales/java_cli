import java.util.Date;

public class Fibonacci {

    static int fibonacci(int n) {

        if (n > 1)
            return fibonacci(n - 1) + fibonacci(n - 2);
        else
            return n;
    }

    public static void main(String argv[]) {

        Date start = new Date();
        int n = fibonacci(47);
        Date end = new Date();

        System.out.println(n);
        System.out.println((end.getTime() - start.getTime()) / 1000.0);
    }
}