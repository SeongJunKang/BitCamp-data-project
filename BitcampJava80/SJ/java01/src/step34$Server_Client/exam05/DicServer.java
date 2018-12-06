package step34$Server_Client.exam05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class DicServer {

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
        out.println(toKor(message));
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

  private static String toKor(String word) {
    Socket socket = null;
    PrintStream out = null;
    Scanner in = null;
    try {
      socket = new Socket("endic.naver.com", 80);
      out = new PrintStream(socket.getOutputStream());
      in = new Scanner(socket.getInputStream());
      // 네이버 사전 서버에 요청한다.
      out.printf("GET /search.nhn?sLn=kr&searchOption=all&query=%s HTTP/1.1\n", word);
      out.println("Host: endic.naver.com");
      out.println();
      
      // 네이버의 응답을 버퍼에 담는다.
      StringBuilder buffer = new StringBuilder();
      String line = null;
      try {
        while (true) {
          line = in.nextLine();
          buffer.append(line);
        }
      } catch (Exception e) {  }
      
      //버퍼에 저장된 내용을 분석하여 한국어 번역 부분을 발췌한다.
      String startTag ="<span class=\"fnt_k05\">";
      String endTag = "</span>";
      int startIndex = buffer.indexOf(startTag);
      int endIndex = buffer.indexOf(endTag,startIndex);
      return buffer.substring(startIndex+startTag.length(), endIndex);
      
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
