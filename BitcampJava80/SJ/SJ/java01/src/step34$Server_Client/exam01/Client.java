package step34$Server_Client.exam01;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    Socket socket = null;
    OutputStream out = null;
    PrintStream out2 = null;
    InputStream in = null;
    try {
      /* 1)서버에 연결한다.
       * => 서버에서 연결을 승인할 떄 까지 리턴하지 않는다.
       * => 만약 서버가 죽었거나, 지정된 시간동안 응답이 없을 때 (Timeout)
       *    예외가 발생한다. 
       */
        System.out.println("서버 연결중....");
        socket = new Socket("localhost", 9999);
        // 2) 서버 쪽으로 데이터를 보내고 받을 입출력 스트림을 얻는다.
        out = socket.getOutputStream();
        out2 = new PrintStream(out);
  
        in = socket.getInputStream();
  
        // 3) 서버로 데이터 보내기
        // => 서버에서 데이터를 받아야만 println()은 리턴한다. => blocking 방식
        System.out.println("서버 데이터 전송중");
        out2.println("홍길동");
        System.out.println("요청 완료 !");
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try{ out2.close(); }catch(Exception e) {}
      try{ out.close(); }catch(Exception e) {}
      try{ in.close(); }catch(Exception e) {}
      try{ socket.close(); }catch(Exception e) {}
    }
  }
}
