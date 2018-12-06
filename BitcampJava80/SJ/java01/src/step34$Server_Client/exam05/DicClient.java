package step34$Server_Client.exam05;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DicClient {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    Socket socket = null;
    PrintStream out = null;
    Scanner in = null;
    String input = "";
    
    try {
        socket = new Socket("localhost", 9999);
        out = new PrintStream(socket.getOutputStream());
        in = new Scanner(socket.getInputStream());
        while(true){
          System.out.print("영어 단어 ? ");
          input = keyScan.nextLine();
          out.println(input);
          System.out.println(in.nextLine());
          if("quit".equals(input)) {
            break;
          }
        } 
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try{ out.close(); }catch(Exception e) {}
      try{ in.close(); }catch(Exception e) {}
      try{ socket.close(); }catch(Exception e) {}
      try{ keyScan.close(); }catch(Exception e) {}
    }
  }
}
