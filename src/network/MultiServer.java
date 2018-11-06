package network;

import  java.io.*;
import  java.net.*;
import  java.util.*;

class   MultiServer {

  public static void main(String[]args) {

    System.out.println("Starting MultiServer");

    ServerSocket server = null;

    try {

      server = new ServerSocket(80);

    } catch (IOException e) {

      System.err.println("Server failed");
      System.exit(1);
    }

    System.out.println("Server : " + server.toString());

    while (true) {

      Socket  socket = null;

      try {

        socket = server.accept();

      } catch(Exception e) {

        System.err.println("Socket failed");
        System.exit(1);
      }

      new ConnectionThread(socket).start();
    }
  }

}
