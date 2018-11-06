package network;

import java.io.*;
import java.net.*;
import java.util.*;

public class ConnectionThread extends Thread {

    // Attributes
    Socket socket = null;

    // Constructor
    ConnectionThread(Socket socket) {
        super("MultiServer");
        // this.setPriority(MIN_PRIORITY);
        this.socket = socket;
        System.out.println(new Date() + " : " + socket.toString());
    }

    // Main
    public void run() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String string = new String();
            String filename = new String();

            while ((string = reader.readLine()) != null) {
                //System.out.println(string);
                if (string.length() == 0)
                    break;
                int a = string.indexOf("GET") + 5;
                int b = string.indexOf("HTTP");

                if (b > a)
                    filename = string.substring(a, b).trim();
            }

            if (filename.equals(""))
                filename = "index.html";

            BufferedInputStream input = new BufferedInputStream(new FileInputStream(filename), 32);

            BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream(), 32);

            byte buffer[] = new byte[32];
            int i = 0;
            long total = 0;

            System.out.println("Requesting " + filename);

            try {

                long ti = (new Date()).getTime();

                while ((i = input.read(buffer, 0, 32)) != -1) {
                    output.write(buffer, 0, i);
                    output.flush();
                    total += i;
                }

                long t = (new Date()).getTime();

                System.out.println("Sent " + filename + " " + total + " bytes in " + (t - ti) + " sec");
            } catch (IOException e) {
            }

            reader.close();
            input.close();
            output.close();

            socket.close();
        } catch (Exception e) {
        }
    }

}
