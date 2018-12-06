package step34$Server_Client.exam04;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpClient {
  public static void main(String[] args) {
    System.out.printf("웹주소?");
    Scanner keyScan =new Scanner(System.in);
    
    // 1) URL을 분석하여 서버주소, 포트번호, 파일경로를 추출한다.
    // => ex) http://www.naver.com/test/okok.html
    String input = keyScan.nextLine();
    String url = input.replace("http://", "");
    String host = url.substring(0, url.indexOf("/"));
    String path = url.substring(url.indexOf("/"));

    Socket socket = null;
    PrintStream out = null;
    Scanner in = null;
    try {
      System.out.printf("%s 서버에 연결하기...\n",host);
      socket = new Socket(host, 80);
      System.out.printf("%s 서버에 연결됨...\n",host);
      out = new PrintStream(socket.getOutputStream());
      in = new Scanner(socket.getInputStream());
      // 웹 서버에 요청하기.
      // www.zdnet.co.kr/news/news_view.asp?artice_id=20160427134958&lo=z40
      // 1)요청자원의 URL 정보를 보낸다.
      // GET /news/news_view.asp?artice_id=20160427134958&lo=z40 HTTP/1.1
      out.printf("GET %s HTTP/1.1\n",path);
      // 2)요청을 받는 서버의 이름을 보낸다
      // Host: www.zdnet.co.kr
      out.printf("Host: %s\n",host);
      // 3) 요청 끝임을 표현하는 빈줄을 보낸다.
      out.println();
      // [웹 서버로부터 응답 받기]
      String line = null;
      try {
        while (true) {
          line = in.nextLine();
          System.out.println(line);
        }
      } catch (Exception e) {
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        out.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
      try {
        socket.close();
      } catch (Exception e) {
      }
      try {
        keyScan.close();
      } catch (Exception e) {
      }
    }
  }
}
