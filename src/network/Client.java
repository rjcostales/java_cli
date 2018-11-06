package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {

        final String host = "http://www.linkedin.com/in/rjcostales/en";
        String filename;

        System.out.println("Client");
        BufferedReader reader;

        try {

            reader = new BufferedReader(new FileReader("resources/database.dat"));

            while (true) {

                filename = reader.readLine();

                if (filename.equals(""))
                    break;

                URL url = new URL(host + filename);

                filename = filename.replace('/', '_');

                System.out.println(filename);

                BufferedInputStream input = new BufferedInputStream(url.openStream(), 1024);
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(filename), 1024);

                byte buffer[] = new byte[1024];
                int len;

                while ((len = input.read(buffer, 0, 1024)) != -1) {
                    output.write(buffer, 0, len);
                }

                System.out.println(url.getFile() + " end transmission");

                input.close();
                output.close();
            }

            reader.close();

        } catch (UnknownHostException e) {

            System.err.println("Trying to connect to unknown host: " + e);

        } catch (IOException e) {

            System.err.println("IOException: " + e);
        }
        System.exit(0);
    }
}
