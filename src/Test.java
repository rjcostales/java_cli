class Test {

    public static void main(String args[]) {

        char c = 0x000A;
        System.out.println(c);
    }
}

class Something {

    static int n = 0;

    public Something() {
        n++;
        System.out.println("I am alive " + n);
    }

    public void status() {
        System.out.println("okay");
    }

    public void die() {
        n--;
    }
}

