package hacking;

import java.util.Scanner;

public class Solution1 {


    private static final Scanner scanner = new Scanner(System.in);

    private static void test(int N) {
        if (N % 2 == 1)
            System.out.println("Weird");
        else if (N >= 6 && N <= 20)
            System.out.println("Weird");
        else
            System.out.println("Not Weird");
    }

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int n = 1; n <= 100; n++) {
            System.out.print(n + " ");
            test(n);
        }

        scanner.close();
    }
}