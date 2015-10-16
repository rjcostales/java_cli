import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class GenerateList {

    public static void main(String argv[]) {
        make("test.txt");
        List<String> list = read("test.txt");

        Collections.sort(list);

        for (String aList : list) {
            System.out.print(aList + " ");
        }
    }

    public static List<String> read(String name) {
        List<String> list = new ArrayList<String>();
        String line;

        try {
            FileReader fr = new FileReader(name);
            LineNumberReader br = new LineNumberReader(fr);

            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return list;
    }

    public static void make(String name) {
        int count = 1000;
        Random rand = new Random();

        try {
            FileWriter fw = new FileWriter(name);
            PrintWriter pw = new PrintWriter(fw);

            while (count-- > 0) {

                int n = rand.nextInt(900000) + 100000;
                pw.printf("%s\n", n);
            }
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
