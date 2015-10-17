import java.util.Date;

public class Sieve {

    public static void main(String argv[]) {

        int size = 10000;

        boolean[] flag = new boolean[size];
        int prime;
        long count = 15;

        System.out.println("Started... ");
        Date start = new Date();

        try {

            for (int i = 0; i < size; i++) {
                if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0 ||
                        i % 11 == 0 || i % 13 == 0 || i % 17 == 0 || i % 19 == 0 ||
                        i % 23 == 0 || i % 29 == 0 || i % 31 == 0 || i % 37 == 0 ||
                        i % 41 == 0 || i % 43 == 0 || i % 47 == 0)
                    flag[i] = false;

                else
                    flag[i] = true;
            }

            for (int i = 53; i < size; i++) {
                if (flag[i]) {

                    prime = i;
                    count++;
                    System.out.println(prime);

                    for (int k = i + i; k < size; k += prime)
                        flag[k] = false;

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        Date stop = new Date();
        long delta = stop.getTime() - start.getTime();

        System.out.println(count + " primes in " + delta + " msec");
    }
}
