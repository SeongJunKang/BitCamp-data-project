package step34$Server_Client.exam02;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("사용법 : EchoClinet 메시지");
    }
    Socket socket = null;
    PrintStream out = null;
    Scanner in = null;
    try {
        socket = new Socket("localhost", 9999);
        out = new PrintStream(socket.getOutputStream());
        in = new Scanner(socket.getInputStream());
        out.println(args[0]);
        String returnMessage = in.nextLine();
        System.out.println(returnMessage);
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try{ out.close(); }catch(Exception e) {}
      try{ in.close(); }catch(Exception e) {}
      try{ socket.close(); }catch(Exception e) {}
    }
  }
}
