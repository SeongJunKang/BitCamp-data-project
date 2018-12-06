package step34.exam01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    Socket socket = null;
    InputStream in = null;
    OutputStream out = null;
    Scanner in2 = null;
    
    try {
      // 1) 서버 소켓을 준비한다. 
      // => 사용되지 않는 포트 번호를 지정해야 한다.
      System.out.println("서버 준비 중...");
      serverSocket = new ServerSocket(9999);
      
      // 2) 대기열에서 첫 번째 클라이언트 연결을 가져온다.
      // => 만약 대기열에 클라이언트가 없다면 기다린다.
      // => 일정 시간이 지나도(timeout) 클라이언트의 연결이 없으면 예외 발생!
      System.out.println("클라이언트 대기 중...");
      socket = serverSocket.accept();
      
      // 3) 클라이언트 쪽과 입출력을 수행할 객체를 얻는다.
      in = socket.getInputStream();
      in2 = new Scanner(in);
      
      out = socket.getOutputStream();
      
      // 4) 클라이언트가 보낸 데이터 읽기
      String message = in2.nextLine();
      
      // 5) 화면 출력
      System.out.printf("%s님 반갑습니다.\n", message);
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {in2.close();} catch (Exception e) {}
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
      try {serverSocket.close();} catch (Exception e) {}
    }
  }

}
