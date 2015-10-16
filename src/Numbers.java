public class Numbers {

    public static void main(String args[]) {

        System.out.println("Hello World");

        byte b;
        short s;
        int i;

        for (i = -256; i < 0x100; i++) {

            s = (short) i;
            b = (byte) i;

            System.out.print(b + "\t" + hex(i) + "\t" + hex(b) + " " + bin(b) + "\t");
            System.out.println(s + "\t" + hex(s) + " " + bin(s));

        }
    }

    public static String hex(byte n) {
        String digit = "0123456789abcfef";
        String str = "";

        str += digit.charAt((n >>> 4) & 0x0F);
        str += digit.charAt(n & 0x0F);

        return str;
    }

    public static String hex(short n) {
        String digit = "0123456789ABCDEF";
        String str = "";

        str += digit.charAt((n >>> 12) & 0x0F);
        str += digit.charAt((n >>> 8) & 0x0F);
        str += digit.charAt((n >>> 4) & 0x0F);
        str += digit.charAt(n & 0x0F);

        return str;
    }

    public static String hex(int n) {
        short lo = (short) (n & 0xFFFF), hi = (short) (n >>> 16);

        return hex(hi) + "'" + hex(lo);
    }

    public static String bin(byte n) {
        String bit = "0123456789ABCDEF";
        String str = "";

        str += bit.charAt((n >>> 7) & 1);
        str += bit.charAt((n >>> 6) & 1);
        str += bit.charAt((n >>> 5) & 1);
        str += bit.charAt((n >>> 4) & 1);
        str += "'";
        str += bit.charAt((n >>> 3) & 1);
        str += bit.charAt((n >>> 2) & 1);
        str += bit.charAt((n >>> 1) & 1);
        str += bit.charAt(n & 1);

        return str;
    }

    public static String bin(short n) {
        byte lo = (byte) (n & 255), hi = (byte) (n >>> 8);

        return bin(hi) + "'" + bin(lo);
    }
}