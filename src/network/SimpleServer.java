package network;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleServer {

    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;

        String string = new String();
        String filename = new String();

        System.out.println("SimpleServer");

        try {

            server = new ServerSocket(80);

        } catch (IOException e) {

            System.err.println(e.toString());
        }

        while (true) {

            try {

                socket = server.accept();

            } catch (IOException e) {

                System.err.println(e.toString());
            }

            System.out.println((new Date()) + " " + socket);

            try {

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedInputStream file = null;

                // System.out.println((new Date()) + " reception start");
                while ((string = input.readLine()) != null) {

                    // System.out.println(string);
                    if (string.length() == 0)
                        break;

                    int a = string.indexOf("GET") + 5;
                    int b = string.indexOf("HTTP");

                    if (b > a) {
                        filename = string.substring(a, b).trim();
                        if (filename.equals(""))
                            filename = "index.html";
                    }
                }

                // System.out.println((new Date()) + " reception end");
                // System.out.println(filename);

                try {

                    file = new BufferedInputStream(new FileInputStream(filename), 32);
                    BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream(), 32);

                    byte buffer[] = new byte[32];
                    int i = 0;
                    int total = 0;

                    // System.out.println("Sending : " + filename);
                    // System.out.println((new Date()) + " transmit start");
                    long ti = (new Date()).getTime();

                    while ((i = file.read(buffer, 0, 32)) != -1) {

                        output.write(buffer, 0, i);
                        output.flush();
                        total += i;
                    }

                    long t = (new Date()).getTime();

                    System.out.println("Sent " + filename + " " + total + " bytes in " + (t - ti) + " sec");

                    output.close();
                    file.close();

                } catch (FileNotFoundException e) {

                    PrintWriter writer =
                            new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                    writer.println("HTTP/1.1 404 Object Not Found");
                    writer.println("Server: Microsoft-IIS/5.0");
                    writer.println("Date: " + (new Date()).toString());
                    writer.println("Connection: close\n");
                    writer.flush();

                    writer.close();

                    System.out.println("Not Found " + filename);

                }

                input.close();
                socket.close();

            } catch (IOException e) {

                System.err.println(e.toString());
            }
        }
    }

}
