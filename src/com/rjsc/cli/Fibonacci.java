package com.rjsc.cli;

import java.util.Date;

public class Fibonacci {

    public static void main(String argv[]) {

        Date start = new Date();
        long n = fibonacci(93);
        Date end = new Date();

        System.out.println(n);
        System.out.println(end.getTime() - start.getTime());
        System.out.println(start.toString());
        System.out.println(end.toString());
    }

    static long fibonacci(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            case 6:
                return 8;
            case 7:
                return 13;
            case 8:
                return 21;
            case 9:
                return 34;
            case 10:
                return 55;
            default:
                return 55 * fibonacci(n - 9) + 34 * fibonacci(n - 10);
        }
    }
}
