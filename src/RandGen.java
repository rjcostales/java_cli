import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Random;

public class RandGen {

    public static void main(String argv[]) throws Exception {

        System.out.println("Started... ");
        Date start = new Date();

        Random rand = new Random();
        double d;
        double sum1 = 0.0;
        double sum2 = 0.0;

        FileOutputStream fos = new FileOutputStream("data");
        DataOutputStream dos = new DataOutputStream(fos);

        for (int i = 0; i < 1000; i++) {

            d = rand.nextGaussian();
            dos.writeBytes(d + "\r");

            sum1 += d;
            sum2 += d * d;

            /*
             * double d = Math.RandGen(); d += Math.RandGen(); d += Math.RandGen();
             * d += Math.RandGen(); d += Math.RandGen(); d += Math.RandGen(); d +=
             * Math.RandGen(); d += Math.RandGen(); d += Math.RandGen(); d +=
             * Math.RandGen(); d += Math.RandGen(); d += Math.RandGen() - 6;
             */

            dos.writeBytes(d + "\r");

        }
        dos.close();
        fos.close();

        Date stop = new Date();
        System.out.println("Done " + (stop.getTime() - start.getTime()) / 1000.0);
        System.out.println(sum1 + " " + sum2);
    }
}
