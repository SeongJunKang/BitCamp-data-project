package step34$Server_Client.exam05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CosServer {

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    Socket socket = null;
    try {
      System.out.println("서버 준비중");
      serverSocket = new ServerSocket(9999);
      while(true) {
        System.out.println("클라이언트 대기중....");
        socket = serverSocket.accept();
        echo(socket);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {        serverSocket.close();      } catch (Exception e) {      }
    }
  }

  private static void echo(Socket socket) {
    String message = null;
    PrintStream out = null;
    Scanner in = null;
    try {
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      while (true) {
        
        message = in.nextLine();
        if (message.equals("quit")) {
          out.println("Good bye.");
          break;
        }
        System.out.println(toKor(message));
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("클라이언트 통신 오류");
    } finally {
      try {        in.close();      } catch (Exception e) {  }
      try {     out.close();      } catch (Exception e) {   }
      try {        socket.close();      } catch (Exception e) {   }
    }
  }

  private static String toKor(String page) {
    Socket socket = null;
    PrintStream out = null;
    Scanner in = null;
    try {
      socket = new Socket("www.icid.kr", 80);
      out = new PrintStream(socket.getOutputStream());
      in = new Scanner(socket.getInputStream());
      // 
      // http://www.icid.kr/
      out.printf("GET /main.html?page=%s&keyword=배합금지&keyfield=Search_all&sort_inci=&sort_inci2=&sort_eng=&sort_eng2=&sort_kr=&sort_kr2=&sort_state=&sort_state2=&sort_mix=&sort_mix2=&page_num=10 HTTP/1.1\n",page);
      out.println("Host: www.icid.kr");
      out.println("User-Agent: Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36"
          + " (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
      out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/\\*;q=0.8");
      out.println();
      
      StringBuilder buffer = new StringBuilder();
      String line = null;
      String[] cosmetics;
      try {
        while (true) {
          line = in.nextLine();
//          System.out.println(line);
          buffer.append(line);
        }
      } catch (Exception e) {  }
      String startTag ="<td width=\"150\" bgcolor=\"#f2f2f2\">";
      String endTag = "</font></span></p>";
      int startIndex = buffer.indexOf(startTag);
      int endIndex = buffer.indexOf(endTag,startIndex);
      
      String value = buffer.substring(startIndex+startTag.length(), endIndex);
      value = value.replace("<p align=\"center\"><span style=\"font-size:8pt;\"><font face=\"돋움\">", "");
      return value.replace(" ", "");
      
      
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {        out.close();     } catch (Exception e) {      }
      try {        in.close();      } catch (Exception e) {      }
      try {        socket.close();  } catch (Exception e) {      }
    }
    return "없는 단어 혹은 실행 오류";
  }
}
