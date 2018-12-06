package step35.exam03;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient implements Runnable {
  Socket socket = null;
  PrintStream out = null;
  Scanner in = null;
  Scanner keyScan = new Scanner(System.in);

  public ChatClient() {
    try {
      socket = new Socket("localhost", 9999);
      out = new PrintStream(socket.getOutputStream());
      in = new Scanner(socket.getInputStream());
      // 서버로부터 받는 메시지는 다른 스레드에게 맡긴다.
      new Thread(this).start();
    } catch (Exception e) {
    }
  }

  public void execute() {
    // 주구장창 보내기만 하는것.
    String input = null;
    try {
      while (true) {
        System.out.print("나 > ");
        input = keyScan.nextLine();
        out.println(input);
        if ("quit".equals(input)) {
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        out.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
      try {
        socket.close();
      } catch (Exception e) {
      }
      try {
        keyScan.close();
      } catch (Exception e) {
      }
    }
  }

  @Override
  public void run() {
    try {
      while (true) {
        System.out.println(in.nextLine());
      }
    } catch (Exception e) {
    }
  }
  public static void main(String[] args) {
      ChatClient chatClient = new ChatClient();
      chatClient.execute();
  }
}
