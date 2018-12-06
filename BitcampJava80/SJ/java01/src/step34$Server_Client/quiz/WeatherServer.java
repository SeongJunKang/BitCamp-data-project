package step34$Server_Client.quiz;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class WeatherServer {

  public static void main(String[] args) {
    ServerSocket serverSocket = null;    
    Socket socket = null; 
     try {  
        System.out.println("서버 준비중...");
        serverSocket = new ServerSocket(9999);
        while (true) {
          System.out.println("클라이언트 대기중...");
          socket = serverSocket.accept();         
          echo(socket);
        }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try{serverSocket.close();} catch (Exception e) {}
    }

  } 
  
  private static void echo(Socket socket) {
       
    PrintStream out = null;
    Scanner in = null;
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
        
        out.println(tokor(message));
        
      }
      
    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류");
      e.printStackTrace();      
    } finally {      
      try{in.close();} catch (Exception e) {}
      try{out.close(); } catch (Exception e) {}
      try{socket.close();} catch (Exception e) {}      
    }  
    
  }

  private static String tokor(String word) {
    Socket socket = null;    
    Scanner in = null;    
    PrintStream out = null;
    String code = CityCode.cCode(word);
    if(code.equals("nocity")) {
      return "등록되지 않은 도시입니다.";
    }
    try {      
      socket = new Socket("weather.naver.com", 80);            
      in = new Scanner(socket.getInputStream());      
      out = new PrintStream(socket.getOutputStream());
      out.printf("GET /rgn/cityWetrCity.nhn?cityRgnCd=%s HTTP/1.1\n", code);
      out.println("Host: weather.naver.com");
      out.println();
      
      //웹 서버로부터 응답 받아 버퍼에 저장한다.
      StringBuilder buffer = new StringBuilder();
      String line;      
      try {
        while (true) {
          line = in.nextLine();          
//          System.out.println(line);
          buffer.append(line);
          
        } 
        
      } catch (Exception e) {
        
      }
      String output = "지역 : "+word+", ";
      //오전 온도
      String startTag = "<li class=\"nm\"><b>오전</b> <span class=\"temp\">";
      String endTag = "</span><em class=\"dgr\">";
      int startIndex = buffer.indexOf(startTag);
      int endIndex = buffer.indexOf(endTag, startIndex);
      String cont =buffer.substring(startIndex + startTag.length(), endIndex);
      String temp;
      if (cont.substring(0, 2).contains("."))
        temp=cont.substring(0, 1);
      else if(cont.substring(0, 2).contains("-"))
        temp=cont.substring(0, 3);
      else
        temp=cont.substring(0, 2);
       output += "온도 : "+ 
          temp+
          cont.substring(cont.length()-2)
             + "℃, 강수확률 : ";
       //강수확률
      startTag = "<span class=\"rain\"><strong>";
      endTag = "</strong>";
      startIndex = buffer.indexOf(startTag);
      endIndex = buffer.indexOf(endTag, startIndex);
      output += buffer.substring(startIndex + startTag.length(), endIndex);
//      // 오후 온도
//      startTag = "<li class=\"nm\"><b>오후</b> <span class=\"temp\">";
//      endTag = "</span><em class=\"dgr\">";
//      startIndex = buffer.indexOf(startTag);
//      endIndex = buffer.indexOf(endTag, startIndex);
//       output += "오후온도 : "+ 
//          buffer.substring(startIndex + startTag.length(), endIndex) 
//             + "℃, 오후강수확률";
//       startTag = "<span class=\"rain\"><strong>";
//       endTag = "</strong></span></li>";
//       startIndex = buffer.indexOf(startTag);
//       endIndex = buffer.indexOf(endTag, startIndex);
//       output += buffer.substring(startIndex + startTag.length(), endIndex);
      return  output;
      
    } catch (Exception e) {
    } finally {    
        try {out.close();} catch (Exception e) {}        
        try {in.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
    }   
    return "실행 오류";
  }

}
