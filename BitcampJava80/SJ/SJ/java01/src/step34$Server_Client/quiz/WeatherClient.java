package step34$Server_Client.quiz;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class WeatherClient {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);    
    Socket socket = null;    
    Scanner in = null;    
    PrintStream out = null;
    String input = null;
    
    try {      
      socket = new Socket("localhost", 9999);            
      in = new Scanner(socket.getInputStream());      
      out = new PrintStream(socket.getOutputStream());
      
      while (true) {
        System.out.print("도시 이름? ");
        input = keyScan.nextLine();
         
        out.println(input);
        System.out.println(in.nextLine());

        if (input.equals("quit")) {
          break;
        }        
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
}
