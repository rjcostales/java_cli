import java.util.Date;

public class Fibonacci {

    public static void main(String argv[]) {

        Date start = new Date();
        int n = fibonacci(40);
        Date end = new Date();

        System.out.println(n);
        System.out.println(end.getTime() - start.getTime());
        System.out.println(start.toString());
        System.out.println(end.toString());
    }

    static int fibonacci(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
