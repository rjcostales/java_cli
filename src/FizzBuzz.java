public class FizzBuzz {

    public static void main(String argv[]) {
        for (int i = 0; i < 100; i++)
            System.out.println(i + ":" + fizzBuzz(i));
    }

    public static String fizzBuzz(int n) {
        if (n % 3 == 0) {
            if (n % 5 == 0) {
                return "fizzbuzz";
            } else {
                return "fizz";
            }
        } else if (n % 5 == 0) {
            return "buzz";
        }
        return String.valueOf(n);
    }

    public static String fizzBuzz2(int n) {

        if (n % 15 == 0) {
            return "fizzbuzz";
        } else if (n % 5 == 0) {
            return "buzz";
        } else if (n % 3 == 0) {
            return "fizz";
        }
        return String.valueOf(n);
    }
}
