package step35.exam03;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient implements Runnable {
  Scanner keyScan = new Scanner(System.in);
  Socket socket = null;
  Scanner in = null;
  PrintStream out = null;
  
  public ChatClient() {
    try {
      socket = new Socket("localhost", 9999);
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      
      //서버로부터 받는 메시지는 다른 스레드에게 맡긴다.
      new Thread(this).start();
      
    } catch (Exception e) {
      e.printStackTrace();

    }
  }
  
  public void execute() {
    String input = null;
    try {
      while (true) {
        System.out.print("> ");
        input = keyScan.nextLine();
        
        out.println(input);

        if (input.equals("quit"))
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {  
      try {keyScan.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {in.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }
  
  @Override
  public void run() {
    try {
      while (true) {
        System.out.println(in.nextLine());
      }
    } catch (Exception e) {} 
  }
  
  public static void main(String[] args) {
    ChatClient client = new ChatClient();
    client.execute();
  }
  
}







