package bitcamp.pms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class PMSServer {
  ServerSocket serverSocket;

  public PMSServer() throws Exception {
    serverSocket = new ServerSocket(this.getServerPort());
  }
  
  private void close() {
    try {
      serverSocket.close();
    } catch (Exception e) {
    }
    
  }
  
  private void execute() {
    Scanner in  = null;
    PrintStream out = null;
    Socket socket = null;
    try {
    socket = serverSocket.accept();
    in = new Scanner(
        new BufferedInputStream(socket.getInputStream()));
    out = new PrintStream(
        new BufferedOutputStream(socket.getOutputStream()));
    String command =null;
    while(true) {
      command = in.nextLine();
      if(command.equals("quit"))
        break;
      out.println("너가보낸 명령어 : "+command);
      out.println();
      out.flush();
    }
    out.println("잘가세요");
    out.println();
    out.flush();
    
    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
    } finally {
      try { in.close();} catch(Exception e) {}
      try { out.close();} catch(Exception e) {}
      try { socket.close();} catch(Exception e) {}
    }
  }
  
  private int getServerPort() {
    String value = System.getProperty("port");
    if (value != null)
      return Integer.parseInt(value);
    return 9999;
  }

  public static void main(String[] args) {
    PMSServer server = null;
    try {
      server = new PMSServer();
      System.out.println("PMSServer 실행 중...");
      server.execute();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      server.close();
    }
  }

}
