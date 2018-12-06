package step35$Thread.quiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ChatClient {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    System.out.print("아이피는? ");
    String server = keyScan.nextLine();
    System.out.print("포트번호는? ");
    int port = Integer.parseInt(keyScan.nextLine());
    System.out.print("이름은 ?");
    String name = keyScan.nextLine();
    try {
      Socket socket = new Socket(server, port);
      Thread thread1 = new SenderThread(socket, name);
      Thread thread2 = new ReceiverThread(socket);
      thread1.start();
      thread2.start();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
  }

  static class ReceiverThread extends Thread {
    Socket socket;

    ReceiverThread(Socket socket) {
      this.socket = socket;
    }

    public void run() {
      try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
          String str = reader.readLine();
          if (str == null)
            break;
          System.out.println(str);
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }

  static class SenderThread extends Thread {
    Socket socket;
    String name;

    SenderThread(Socket socket, String name) {
      this.socket = socket;
      this.name = name;
    }

    public void run() {
      try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println(name);
        writer.flush();
        while (true) {
          String str = reader.readLine();
          if (str.equals("bye"))
            break;
          writer.println(str);
          writer.flush();
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      } finally {
        try {
          socket.close();
        } catch (Exception e) {
        }
      }
    }
  }
}
