package step34$Server_Client.exam02;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    Socket socket = null;
    try {
      System.out.println("서버 준비중");
      serverSocket = new ServerSocket(9999);
      while (true) {
        System.out.println("클라이언트 대기중...");
        socket = serverSocket.accept();
        echo(socket);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try{serverSocket.close();} catch(Exception e) {}
    }

  }
  private static void echo(Socket socket) {
    String message = null;
    PrintStream out = null;
    Scanner in = null;
    try{
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      message = in.nextLine();
      out.println(message);
      System.out.println(message);
      } catch(Exception e){
        System.out.println("클라이언트 통신 오류");
      } finally {
        try{ in.close(); }catch(Exception e) {}
        try{ out.close(); }catch(Exception e) {}
        try{socket.close();} catch(Exception e) {}
      }
  }
}
