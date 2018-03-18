public class Hanoi {

    public static void main(String[] args) {
        int nDisks = 5;
        doTowers(nDisks, 'A', 'B', 'C');
    }

    public static void doTowers(int n, char from, char inter, char to) {
        if (n == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(n - 1, from, to, inter);
            System.out.println("Disk " + n + " from " + from + " to " + to);
            doTowers(n - 1, inter, from, to);
        }
    }
}
