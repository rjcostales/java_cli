<<<<<<< HEAD
import java.util.Date;

public class Fibonacci {

    static long fibonacci(long n) {

        if (n > 1)
            return fibonacci(n - 1) + fibonacci(n - 2);
        else
            return n;
    }

    public static void main(String argv[]) {

        Date start = new Date();
        long n = fibonacci(47);
        Date end = new Date();

        System.out.println(n);
        System.out.println(end.getTime() - start.getTime() / 1000.0);
    }
}
=======
import java.util.Date;

public class Fibonacci {

    static long fibonacci(long n) {

        if (n > 1)
            return fibonacci(n - 1) + fibonacci(n - 2);
        else
            return n;
    }

    public static void main(String args[]) {

        Date start = new Date();
        long n = fibonacci(47);
        Date end=  new Date();

        System.out.println(n);
        System.out.println((end.getTime() - start.getTime()) / 1000.0);
    }
}
>>>>>>> edc83827a154c3e8f69565c709e7c0159c59a548
