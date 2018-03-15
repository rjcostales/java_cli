public class Fibonacci {

    static long fibonacci(long n) {

        if (n > 1)
            return fibonacci(n - 1) + fibonacci(n - 2);
        else
            return n;
    }

    public static void main(String args[]) {

        long start = System.nanoTime();
        long n = fibonacci(40);
        long end = System.nanoTime();

        System.out.println(n);
        System.out.println((end - start) / 1000000000.0);
    }
}
