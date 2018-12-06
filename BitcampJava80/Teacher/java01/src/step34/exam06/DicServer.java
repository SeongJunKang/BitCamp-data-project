package step34.exam06;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class DicServer {

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    Socket socket = null;
    
    try {
      System.out.println("서버 준비 중...");
      serverSocket = new ServerSocket(9999);
      while (true) {
        System.out.println("클라이언트 대기 중...");
        socket = serverSocket.accept();
        
        new MyThread(socket).start();
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {serverSocket.close();} catch (Exception e) {}
    }
  }
  
  static class MyThread extends Thread {
    Socket socket;
    
    public MyThread(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      Scanner in = null;
      PrintStream out = null;
      String message = null;
      
      try {
        in = new Scanner(socket.getInputStream());
        out = new PrintStream(socket.getOutputStream());
        
        while (true) {
          message = in.nextLine();
          
          if (message.equals("quit")) {
            out.println("즐거운 하루되세요.");
            break;
          }
          
          out.println(toKor(message));
          
        }
        
      } catch (Exception e) {
        System.out.println("클라이언트 통신 오류!");
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
    
    private String toKor(String word) {
      Socket socket = null;
      Scanner in = null;
      PrintStream out = null;
      
      try {
        socket = new Socket("endic.naver.com", 80);
        in = new Scanner(socket.getInputStream());
        out = new PrintStream(socket.getOutputStream());
        
        // 네이버 사전 서버에 요청한다.
        out.printf("GET /search.nhn?sLn=kr&searchOption=all&query=%s HTTP/1.1\n", word);
        out.println("Host: endic.naver.com");
        out.println();
        
        // 네이버의 응답을 버퍼에 저장한다.
        StringBuilder buffer = new StringBuilder();
        String line;
        try {
          while (true) {
            line = in.nextLine();
            buffer.append(line);
          }
        } catch (Exception e) {}
        
        // 버퍼에 저장된 내용을 분석하여 한국어 번역 부분을 발췌한다.
        String startTag = "<span class=\"fnt_k05\">";
        String endTag = "</span>";
        int startIndex = buffer.indexOf(startTag);
        int endIndex = buffer.indexOf(endTag, startIndex);
        
        return buffer.substring(startIndex + startTag.length(), endIndex);
        
      } catch (Exception e) {
        e.printStackTrace();
        
      } finally {  
        try {out.close();} catch (Exception e) {}
        try {in.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
      return "실행 오류!";
    }
    
  }
  

}









